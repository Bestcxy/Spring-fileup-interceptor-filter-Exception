package com.bestcxx.stu.fileup.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.bestcxx.stu.fileup.exception.MyException;

@Controller
public class FileUpController {

	/**
	 * 1、放弃在xml中限制文件上传大小，改为自己处理 
	 * 2、intercepter是必须的，对于判断文件大小而言
	 * 3、使用全局或者类级别的@ExceptionHandler(Exception.class)
	 * 4、同时使用全局异常和类级别异常，类级别起作用
	 * 5、建议使用全局级别的
	 * 
	 * 需呀 intercepter的配合
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public Object handleException(Exception ex, HttpServletRequest request) {
		if (ex instanceof org.springframework.web.multipart.MaxUploadSizeExceededException) {
			request.setAttribute("msg", "文件超过长度");
		}
		else if (ex instanceof MyException) {
			request.setAttribute("msg", "自定义异常：文件超过长度");
		}else{
			request.setAttribute("msg", "未知错误："+ex.getMessage());
		}
		return "error";
	}

	@RequestMapping(value = "fileup", method = { RequestMethod.POST })
	public ModelAndView fileUp(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
			// 创建一个通用的多部分解析器
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			// 判断 request 是否有文件上传,即多部分请求
			if (multipartResolver.isMultipart(request)) {
				// 转换成多部分request
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				// 取得request中的所有文件名
				Iterator<String> iter = multiRequest.getFileNames();
				while (iter.hasNext()) {
					// 记录上传过程起始时的时间，用来计算上传时间
					int pre = (int) System.currentTimeMillis();
					// 取得上传文件
					MultipartFile file = multiRequest.getFile(iter.next());
					if (file != null) {
						// 取得当前上传文件的文件名称
						String myFileName = file.getOriginalFilename();
						// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
						if (myFileName.trim() != "") {
							System.out.println("上传文件名字" + myFileName);
							// 重命名上传后的文件名
							String fileName = "demoUpload" + file.getOriginalFilename();
							System.out.println("保存文件名字：" + fileName);
							// 定义上传路径
							String path = "D:/" + fileName;
							File localFile = new File(path);
							file.transferTo(localFile);

						}
					}
					// 记录上传该文件后的时间
					int finaltime = (int) System.currentTimeMillis();
					System.out.println("上传消耗时间：" + (finaltime - pre) + " 毫秒");
				}

			}
			return new ModelAndView("success");
	}
}

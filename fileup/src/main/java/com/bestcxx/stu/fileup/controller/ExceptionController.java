package com.bestcxx.stu.fileup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import com.bestcxx.stu.fileup.exception.MyException;

/**
 * 页面异常参考链接：http://www.cnblogs.com/shanheyongmu/p/5872442.html
 * 
 * 接口处理参考链接：http://blog.csdn.net/nmgrd/article/details/52734193
 *
 * 文件上传过大参考链接：https://my.oschina.net/scjelly/blog/523705
 */
@Controller
public class ExceptionController {
	//捕获本来的异常
	//优先级比全局异常高
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex, WebRequest request) {
		request.setAttribute("msg","异常捕获:"+this.getClass()+" "+ex.getMessage(), RequestAttributes.SCOPE_REQUEST);
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("ex", ex);
		return mav;
	}
 

	/**
	 * 异常处理测试
	 * @return
	 */
	@GetMapping("exception")
	public String exception() throws Exception{
		if(true){
			throw new MyException("报错");			
		}
		
		return "success";
	}
}

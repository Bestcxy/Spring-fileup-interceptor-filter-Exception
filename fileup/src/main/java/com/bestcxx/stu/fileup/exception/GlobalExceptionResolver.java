package com.bestcxx.stu.fileup.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class GlobalExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView modelAndView=new ModelAndView();  
		 System.out.println("异常信息输出："+ex.toString());
		//如果是文件太大
		if (ex instanceof MaxUploadSizeExceededException) {
            long maxSize = ((MaxUploadSizeExceededException) ex).getMaxUploadSize();
            System.out.println(this.getClass()+" 上传文件太大，不能超过" + maxSize/1024/1024 + "mb"); // 打印错误信息
            
            //将错误信息传到页面  
            modelAndView.addObject("msg",this.getClass()+" 出现异常:"+"上传文件太大，不能超过" + maxSize/1024/1024 + "mb"+ex.getMessage()); 
            
            //指向到错误界面  
            modelAndView.setViewName("error");  
            return modelAndView;
        } 
		
		
        if(ex instanceof MyException){ //自定义异常
        	 modelAndView.addObject("msg","自定义异常:"+ex.getMessage());  
        }else{  
            //如果该 异常类型不是系统 自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）。  
        	modelAndView.addObject("msg","未知异常:"+ex.getMessage());  
        }  
		
        //将错误信息传到页面  
        modelAndView.addObject("msg","出现异常:"+ex.getMessage());  
          
        //指向到错误界面  
        modelAndView.setViewName("error");  
          
        return modelAndView;
	}

}

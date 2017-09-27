package com.bestcxx.stu.fileup.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常配置
 * @author Administrator
 *
 */
@ControllerAdvice
public class ExceptionResolver {
	
	@ExceptionHandler(RuntimeException.class)
    public ModelAndView handlerRuntimeException(RuntimeException ex){
		if(ex instanceof MaxUploadSizeExceededException){
			return new ModelAndView("error").addObject("msg", "文件太大！");			
		}
		return new ModelAndView("error").addObject("msg", "未知错误："+ex);	
    }
	
	@ExceptionHandler(Exception.class)
    public ModelAndView handlerMaxUploadSizeExceededException(Exception ex){
		if(ex instanceof Exception){
			return new ModelAndView("error").addObject("msg", ex);			
		}
		
		return new ModelAndView("error").addObject("msg", "未知错误："+ex);	
		
    }

}

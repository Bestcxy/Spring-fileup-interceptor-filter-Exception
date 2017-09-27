package com.bestcxx.stu.fileup.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bestcxx.stu.fileup.exception.MyException;

public class MyInterceptor implements HandlerInterceptor {
	private long maxSize;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(this.getClass()+" preHandle开始："+System.currentTimeMillis());
		System.out.println(this.getClass()+" 自定义拦截器访问前："+maxSize);
		 if(request!=null && ServletFileUpload.isMultipartContent(request)) {
	            ServletRequestContext ctx = new ServletRequestContext(request);
	            long requestSize = ctx.contentLength();
	            if (requestSize > maxSize) {
	            	System.out.println(this.getClass()+" preHandle结束："+System.currentTimeMillis()+" 文件太大主动抛出异常"); 
	            	//throw new MaxUploadSizeExceededException(maxSize);
	                throw new MyException(maxSize+"文件太大超了");
	            }
	        }
		System.out.println(this.getClass()+" preHandle结束："+System.currentTimeMillis());
		return true;
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(this.getClass()+" postHandle开始："+System.currentTimeMillis());
		System.out.println(this.getClass()+" 自定义拦截器访问中："+maxSize);
		System.out.println(this.getClass()+" postHandle结束："+System.currentTimeMillis());
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println(this.getClass()+" afterCompletion开始："+System.currentTimeMillis());
		System.out.println(this.getClass()+" 自定义拦截器访问后："+maxSize);
		System.out.println(this.getClass()+" afterCompletion结束："+System.currentTimeMillis());

	}

	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}
	
	

}

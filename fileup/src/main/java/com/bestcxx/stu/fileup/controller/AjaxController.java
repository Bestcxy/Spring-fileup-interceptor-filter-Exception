package com.bestcxx.stu.fileup.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {
	
	@ResponseBody
	@PostMapping("ajaxCheckUserName")
	public HashMap<String,Object> ajaxCheckUserName(){
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("result", "YES");
		map.put("msg", "只是一个默认测试访问");
		return map;
		
	}
	
	@ExceptionHandler(Exception.class)       
    public HashMap<String,Object> handleException(Exception ex,HttpServletRequest request) {     
		HashMap<String,Object> map=new HashMap<String,Object>();
        if(ex instanceof org.springframework.web.multipart.MaxUploadSizeExceededException){  
        	
    		map.put("result", "YES");
    		map.put("msg", "文件太大");
    		  
        }
        return map;
    }  
	@PostMapping("ajaxfile")
	public HashMap<String,Object> ajaxfile(){
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("result", "YES");
		map.put("msg", "只是一个默认测试访问");
		return map; 
	}
	

}

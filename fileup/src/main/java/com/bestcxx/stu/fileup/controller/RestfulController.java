package com.bestcxx.stu.fileup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bestcxx.stu.fileup.model.AjaxRespnseModel;

/**
 * Spring MVC 接口返回json格式的方式有两种
 * 1、Maven
 * <!-- json 支持 -->
        <dependency>
	      <groupId>com.fasterxml.jackson.core</groupId>
	      <artifactId>jackson-core</artifactId>
	      <version>${jackson.version}</version>
    	</dependency>
	    <dependency>
	      <groupId>com.fasterxml.jackson.core</groupId>
	      <artifactId>jackson-databind</artifactId>
	      <version>${jackson.version}</version>
	    </dependency>
 * 方式一：对于单个方法，增加注解 
 *  @ResponseBody
 * 
 * 方式二：
 * 增加配置
 * <!-- 实体 json 自动映射转化 -->
  <bean id="jsonConverter"class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
  	<property name="supportedMediaTypes" value="application/json"/>
  </bean>
 *
 */
@RestController
public class RestfulController {
	
	@GetMapping(value="restfulGetResponseBody")
	@ResponseBody
	public AjaxRespnseModel<String> restfulGetResponseBody(){
		System.out.println(this.getClass()+" restfulGetResponseBody开始："+System.currentTimeMillis());
		AjaxRespnseModel<String> a=new AjaxRespnseModel<String>();
		a.setResult("RESTful风格测试");
		a.setMsg("RESTful风格测试,仅仅用户测试get方法。");
		
		//线程停止1000毫秒
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.getClass()+" restfulGetResponseBody结束："+System.currentTimeMillis());
		return a;
	}
	
	@GetMapping(value="restfulGetNoResponseBody")
	public AjaxRespnseModel<String> restfulGetNoResponseBody(){
		AjaxRespnseModel<String> a=new AjaxRespnseModel<String>();
		a.setResult("RESTful风格测试");
		a.setMsg("RESTful风格测试,仅仅用户测试get方法。");
		return a;
	}

}

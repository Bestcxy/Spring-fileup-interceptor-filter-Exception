package com.bestcxx.stu.fileup.model;

import java.io.Serializable;
import java.util.ArrayList;

public class AjaxRespnseModel<T> implements Serializable{
	
	private static final long serialVersionUID = 2059101782016947358L;
	//结果标识
	private String result;
	private String msg;
	private ArrayList<T> list;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ArrayList<T> getList() {
		return list;
	}
	public void setList(ArrayList<T> list) {
		this.list = list;
	}
	
	
}

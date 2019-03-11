package com.product.demo.bean;

import java.io.Serializable;

public class ResBean implements Serializable{

	private String data;
	
	private String adminFlag;

	public ResBean(String data,String adminFlag){
		this.data = data;
		this.adminFlag = adminFlag;
	}
	
	public ResBean(){
		
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(String adminFlag) {
		this.adminFlag = adminFlag;
	}
	
	
}

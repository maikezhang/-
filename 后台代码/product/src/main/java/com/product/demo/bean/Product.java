package com.product.demo.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	@NotNull(message="name can not be null")
	private String name;
	
	private String desc;
	
	@NotNull(message="type can not be null")
	private String type;
	
	private String remark;
	
	@NotNull(message = "price can not be null")
	private float price;
	
	private String filePath;
	
	private String filePathCover;

	private Integer status;


	

	Product(){
		
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getFilePathCover() {
		return filePathCover;
	}

	public void setFilePathCover(String filePathCover) {
		this.filePathCover = filePathCover;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	

}

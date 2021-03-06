package com.dbs.publisher.model;

import java.io.Serializable;

public class Product implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Long productId;
	private String productName;
	private String picUrl;
	private Double productPrice;
	
	
	public Product() {
		super();
	}

	public Product(Long productId, String productName, String picUrl, Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.picUrl = picUrl;
		this.productPrice = productPrice;
	}
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", picUrl="
				+ picUrl + ", productPrice=" + productPrice + "]";
	}
}

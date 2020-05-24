package com.dbs.subscriber.model;

import java.io.Serializable;

public class Cart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Product product;
	private Integer productQuantity;
	
	
	public Cart() {
		super();
	}
	
	public Cart(Product product, Integer productQuantity) {
		super();
		this.product = product;
		this.productQuantity = productQuantity;
	}




	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		return "ItemEntity [product=" + product + ", productQuantity=" + productQuantity + "]";
	}
	
	

}

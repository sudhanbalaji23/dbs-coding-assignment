package com.dbs.subscriber.model;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

	private List<Product> product;
	 
    public ProductList() {
    	product = new ArrayList<>();
    }

	public List<Product> getProductList() {
		return product;
	}

	public void setProductList(List<Product> product) {
		this.product = product;
	}
 
    
    
    
    
}

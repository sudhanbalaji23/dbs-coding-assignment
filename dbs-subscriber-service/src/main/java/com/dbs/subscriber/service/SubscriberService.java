package com.dbs.subscriber.service;

import java.util.List;

import com.dbs.subscriber.model.Product;

public interface SubscriberService {
	
	List<Product> getAllProducts();
	
	Product getProductById(Long productId);
	
	void updateProducts(Product product);
}
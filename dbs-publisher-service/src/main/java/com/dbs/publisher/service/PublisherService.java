package com.dbs.publisher.service;

import java.util.List;

import com.dbs.publisher.model.Product;

public interface PublisherService {
	
	List<Product> getAllProducts();
	
	Product getProductById(Long productId);
}
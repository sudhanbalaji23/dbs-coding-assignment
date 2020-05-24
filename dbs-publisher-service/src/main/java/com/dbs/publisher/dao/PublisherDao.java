package com.dbs.publisher.dao;

import java.util.List;

import com.dbs.publisher.model.Product;

public interface PublisherDao {
	
	List<Product> getAllProducts();
	
	Product getProductById(Long productId);
}

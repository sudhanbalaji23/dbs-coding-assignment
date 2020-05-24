package com.dbs.subscriber.dao;

import java.util.List;

import com.dbs.subscriber.model.Product;

public interface SubscriberDao {
	
	List<Product> getAllProducts();
	
	Product getProductById(Long productId);
	
	void updateProducts(Product product);
}

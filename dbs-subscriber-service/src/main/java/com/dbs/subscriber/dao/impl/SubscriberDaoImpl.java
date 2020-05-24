package com.dbs.subscriber.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dbs.subscriber.client.PublisherClient;
import com.dbs.subscriber.dao.ProductRepository;
import com.dbs.subscriber.dao.SubscriberDao;
import com.dbs.subscriber.model.Product;

@Repository
public class SubscriberDaoImpl implements SubscriberDao{
	
	@Autowired
	PublisherClient publisherClient;
	
	@Autowired 
	ProductRepository productRepository;
	
	protected Logger logger = Logger.getLogger(SubscriberDaoImpl.class.getName());
	
	public SubscriberDaoImpl() {
		super();
	}

	/*
	 * Get all products via publisher-service using feign client
	 */

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = publisherClient.getProducts();
		logger.info("ProductList.size() = "+products.size());
		return products;
	}

	
	/*
	 * Get product for the matching productId via publisher-service using feign client
	 * Param @Long
	 */
	
	@Override
	public Product getProductById(Long productId) {
		Product Product = publisherClient.productById(productId);
		logger.info("Product.getProductName() = "+Product.getProductName());
		return Product;
	}


	/*
	 * Save products selected listened by RabbitMQ in database
	 * Param @Product
	 */
	
	@Override
	public void updateProducts(Product product) {
		 Product savedProduct = productRepository.save(product);
		 logger.info("savedProduct :: "+savedProduct.toString());
	}

}

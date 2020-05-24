package com.dbs.subscriber;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dbs.subscriber.client.PublisherClient;
import com.dbs.subscriber.model.Product;

@SpringBootTest
class DbsSubscriberServiceApplicationTests {

	
	private Logger logger = Logger.getLogger(DbsSubscriberServiceApplicationTests.class.getName());
	
	@Autowired
	private PublisherClient publisherClient;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllProductsTest() throws Exception {
		List<Product> products = publisherClient.getProducts();
		assertNotNull(products);
		assertTrue(products.size() > 4);
	}

	@Test
	public void getProductByIdTest() throws Exception {

		Product testCyber = new Product(2L, "Cyber Insurance", "cyber-insurance.jpg", 3000D);
		Product product =  publisherClient.productById(testCyber.getProductId());
		logger.info("DbsSubscriberServiceApplicationTests ::: getProductByIdTest ::: Product :::  "+product);
		assertNotNull(product);
		assertTrue(product.getProductName().equalsIgnoreCase("Cyber Insurance"));
		
	}

}

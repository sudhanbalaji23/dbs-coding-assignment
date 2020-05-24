package com.dbs.publisher.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.publisher.dao.PublisherDao;
import com.dbs.publisher.model.Product;
import com.dbs.publisher.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherDao productDao;
	
	
	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public Product getProductById(Long productId) {
		return productDao.getProductById(productId);
	}

}

package com.dbs.subscriber.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.subscriber.dao.SubscriberDao;
import com.dbs.subscriber.model.Product;
import com.dbs.subscriber.service.SubscriberService;

@Service
public class SubscriberServiceImpl implements SubscriberService {

	@Autowired
	private SubscriberDao subscriberDao;
	
	@Override
	public List<Product> getAllProducts() {
		return subscriberDao.getAllProducts();
	}

	@Override
	public Product getProductById(Long productId) {
		return subscriberDao.getProductById(productId);
	}

	@Override
	public void updateProducts(Product product) {
		subscriberDao.updateProducts(product);
	}


}

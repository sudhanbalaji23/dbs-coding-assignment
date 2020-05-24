package com.dbs.publisher.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dbs.publisher.dao.PublisherDao;
import com.dbs.publisher.model.Product;

/*
 * This is STUB DAO
 */
@Repository
public class PublisherDaoImpl implements PublisherDao{
	
	private List<Product> productList;
	
	public PublisherDaoImpl() {
		productList = new ArrayList<Product>();

		Product commercial = new Product(1L,"Commercial Insurance","commercial-general-insurance.jpg", 5000D);
		Product cyber = new Product(2L,"Cyber Insurance","cyber-insurance.jpg", 3000D);
		Product finLines = new Product(3L,"Financial Lines","financial-lines.jpg", 6000D);
		Product group = new Product(4L,"Group Insurance","group-personal-accident.jpg", 10000D);
		Product marine = new Product(5L,"Marine Insurance","marine.jpg", 3000D);
		
		productList.add(commercial);
		productList.add(cyber);
		productList.add(finLines);
		productList.add(group);
		productList.add(marine);
		
	}

	@Override
	public List<Product> getAllProducts() {
		return productList;
	}

	@Override
	public Product getProductById(Long productId) {
		for(Product productEntity: this.productList) {
			if(productEntity.getProductId().equals(productId)) {
				return productEntity;
			}
		}
		return null;
	}

}

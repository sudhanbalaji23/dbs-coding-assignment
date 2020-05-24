package com.dbs.subscriber.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.subscriber.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

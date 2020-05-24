/**
 * 
 */
package com.dbs.subscriber.client;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.dbs.subscriber.dao.impl.SubscriberDaoImpl;
import com.dbs.subscriber.model.Product;

import feign.FeignException;

/**
 * @author Sudhan Balaji
 *
 */
public class PublisherClientFallback implements PublisherClient {

	private final Throwable cause;
	protected Logger logger = Logger.getLogger(PublisherClientFallback.class.getName());

	public PublisherClientFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public List<Product> getProducts() {
		if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
           logger.info("PublisherClientFallback ::: getProducts ::: FeignException ::: "+cause);
        }
		return new ArrayList<Product>();
	}

	@Override
	public Product productById(Long productId) {
		if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
			 logger.info("PublisherClientFallback ::: productById ::: FeignException ::: "+cause);
        }
		return new Product();
	}

}

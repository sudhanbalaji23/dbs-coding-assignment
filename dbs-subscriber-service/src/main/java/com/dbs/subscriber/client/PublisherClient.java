/**
 * 
 */
package com.dbs.subscriber.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbs.subscriber.model.Product;

/**
 * @author Sudhan Balaji
 *
 */
@FeignClient(name = "productsClient", url = "http://localhost:8080", fallbackFactory = PublisherClientFallbackFactory.class)
public interface PublisherClient {
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/products")
	public List<Product> getProducts();
	
	@RequestMapping(method = RequestMethod.GET, path = "/products/{productId}")
	public Product productById(@PathVariable("productId") Long productId);
	

}

/**
 * 
 */
package com.dbs.subscriber.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.transaction.annotation.Transactional;

import com.dbs.subscriber.binding.PublisherBinding;
import com.dbs.subscriber.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Sudhan Balaji
 *
 */

@EnableBinding(PublisherBinding.class)
public class RabbitMQListener {

	@Autowired
	SubscriberService subscriberService;
	
	protected Logger logger = Logger.getLogger(RabbitMQListener.class.getName());

	@StreamListener(target = PublisherBinding.SHOPPING_CART_CHANNEL)
	@Transactional
	public void processMessage(String msg) {
		logger.info("RabbitMQListener :: selected product before updating to DB :: "+msg);
		ObjectMapper mapper = new ObjectMapper();
		Product selectedProduct = null;
		try {
			selectedProduct = mapper.readValue(msg, Product.class);
		} catch (JsonProcessingException e) {
			logger.info("RabbitMQListener :: Error while processing JSON product :: "+msg);
		}
		subscriberService.updateProducts(selectedProduct);
	}

}

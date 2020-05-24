package com.dbs.publisher.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.publisher.binding.PublisherBinding;
import com.dbs.publisher.model.Cart;
import com.dbs.publisher.model.Product;
import com.dbs.publisher.service.PublisherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@ComponentScan(basePackages = { "com.dbs.publish" })
public class PublisherController {

	protected Logger logger = Logger.getLogger(PublisherController.class.getName());
	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private PublisherService productService;

	@Autowired
	PublisherBinding binding;

	@RequestMapping(value = "/products")
	public List<Product> allProducts() {
		logger.info("dbs-publisher-service allProducts() invoked");
		List<Product> products = productService.getAllProducts();
		logger.info("dbs-publisher-service allProducts() found: " + products.size());
		return products;
	}

	@RequestMapping(value = "/products/{productId}")
	public Product productById(@PathVariable("productId") Long productId) {
		logger.info("dbs-publisher-service productById() invoked");
		Product product = productService.getProductById(productId);
		logger.info("dbs-publisher-service productById() found: " + product);
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(product);
			Message<String> msg = MessageBuilder.withPayload(jsonString).build();
			binding.output().send(msg);
		} catch (JsonProcessingException e) {
			logger.info("JsonProcessingException while parsing : " + product);
		}
		return product;
	}

	private int ifProductExists(Long id, List<Cart> itemEntityList) {
		for (int i = 0; i < itemEntityList.size(); i++) {
			if (itemEntityList.get(i).getProduct().getProductId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

	@RequestMapping(value = "/products1/{productId}", method = RequestMethod.GET)
	public String productById(@PathVariable("productId") Long productId, HttpSession session) {
		List<Cart> itemEntityList = new ArrayList<Cart>();

		if (session.getAttribute("item") == null) {
			itemEntityList = new ArrayList<Cart>();

			Product productEntity = productService.getProductById(productId);
			Cart itemEntity = new Cart(productEntity, 1);
			itemEntityList.add(itemEntity);

			session.setAttribute("item", itemEntityList);
		} else {
			itemEntityList = (List<Cart>) session.getAttribute("item");

			// verify whether item is already exist or not
			int index = this.ifProductExists(productId, itemEntityList);
			if (index == -1) {
				Product productEntity = productService.getProductById(productId);
				Cart itemEntity = new Cart(productEntity, 1);
				itemEntityList.add(itemEntity);
			} else {
				int quantity = itemEntityList.get(index).getProductQuantity() + 1;
				itemEntityList.get(index).setProductQuantity(quantity);
			}
			session.setAttribute("item", itemEntityList);
		}
		return "redirect:/cart";
	}

}

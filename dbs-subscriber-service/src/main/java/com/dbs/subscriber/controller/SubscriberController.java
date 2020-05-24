package com.dbs.subscriber.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dbs.subscriber.model.Cart;
import com.dbs.subscriber.model.Product;
import com.dbs.subscriber.service.SubscriberService;

@Controller
@RequestMapping(value = "subscribe")
public class SubscriberController {

	/*
	 * adding logger
	 */
	protected Logger logger = Logger.getLogger(SubscriberController.class.getName());

	@Autowired
	private SubscriberService subscriberService;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String productList(ModelMap model) {
		model.put("listProducts", subscriberService.getAllProducts());
		return "home";
	}

	@RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	public String productById(@PathVariable("productId") Long productId, HttpSession session) {

		List<Cart> cartList = new ArrayList<Cart>();

		if (session.getAttribute("item") == null) {
			cartList = new ArrayList<Cart>();

			Product Product = subscriberService.getProductById(productId);
			Cart Cart = new Cart(Product, 1);
			cartList.add(Cart);

			session.setAttribute("item", cartList);
		} else {
			cartList = (List<Cart>) session.getAttribute("item");

			// verify whether item is already exist or not
			int index = this.ifProductExists(productId, cartList);
			if (index == -1) {
				Product Product = subscriberService.getProductById(productId);
				Cart Cart = new Cart(Product, 1);
				cartList.add(Cart);
			} else {
				int quantity = cartList.get(index).getProductQuantity() + 1;
				cartList.get(index).setProductQuantity(quantity);
			}
			session.setAttribute("item", cartList);
		}
		return "cart";
	}

	@RequestMapping(value = "/removeProduct/{productId}", method = RequestMethod.GET)
	public String removeProdById(@PathVariable("productId") Long productId, HttpSession session) {
		List<Cart> CartList = (List<Cart>) session.getAttribute("item");
		int index = this.ifProductExists(productId, CartList);
		CartList.remove(index);
		session.setAttribute("item", CartList);
		return "cart";
	}

	private int ifProductExists(Long id, List<Cart> CartList) {
		for (int i = 0; i < CartList.size(); i++) {
			if (CartList.get(i).getProduct().getProductId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

}

/**
 * 
 */
package com.dbs.subscriber.binding;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Sudhan Balaji
 *
 */
public interface PublisherBinding {

	String SHOPPING_CART_CHANNEL = "shoppingCartChannel";

    @Input(SHOPPING_CART_CHANNEL)
    SubscribableChannel getSelectedProduct();
    
}

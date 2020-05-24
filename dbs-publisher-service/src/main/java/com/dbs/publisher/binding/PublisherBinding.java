/**
 * 
 */
package com.dbs.publisher.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author Sudhan Balaji
 *
 */
public interface PublisherBinding {

	@Output("shoppingCartChannel")
    MessageChannel output();

}


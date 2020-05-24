/**
 * 
 */
package com.dbs.subscriber.client;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

/**
 * @author Sudhan Balaji
 *
 */
@Component
public class PublisherClientFallbackFactory implements FallbackFactory<PublisherClient>{

	@Override
	public PublisherClient create(Throwable cause) {
		return new PublisherClientFallback(cause);
	}

}


package com.dbs.subscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.dbs.subscriber.binding.PublisherBinding;


@EnableBinding(PublisherBinding.class)
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class DbsSubscriberServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbsSubscriberServiceApplication.class, args);
	}

}

package com.dbs.publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.dbs.publisher.binding.PublisherBinding;

@SpringBootApplication
@EnableBinding(PublisherBinding.class)
@EnableDiscoveryClient
public class DbsPublisherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbsPublisherServiceApplication.class, args);
	}

}

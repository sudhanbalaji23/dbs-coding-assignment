package com.dbs.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DbsShoppingcartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbsShoppingcartServiceApplication.class, args);
	}

}

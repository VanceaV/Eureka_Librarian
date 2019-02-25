package com.smoothstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaLibrarianApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaLibrarianApplication.class, args);
	}

}

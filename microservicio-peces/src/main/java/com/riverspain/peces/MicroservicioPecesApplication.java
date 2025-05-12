package com.riverspain.peces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicioPecesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioPecesApplication.class, args);
	}

}

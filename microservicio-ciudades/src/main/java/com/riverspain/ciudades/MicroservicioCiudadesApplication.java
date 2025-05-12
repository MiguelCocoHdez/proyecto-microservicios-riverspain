package com.riverspain.ciudades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicioCiudadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioCiudadesApplication.class, args);
	}

}

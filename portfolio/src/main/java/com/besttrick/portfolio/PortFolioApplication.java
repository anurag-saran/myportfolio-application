package com.besttrick.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PortFolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortFolioApplication.class, args);
	}

}

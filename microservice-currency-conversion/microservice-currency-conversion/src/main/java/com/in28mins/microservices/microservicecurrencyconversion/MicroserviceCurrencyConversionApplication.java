package com.in28mins.microservices.microservicecurrencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceCurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCurrencyConversionApplication.class, args);
	}

}

package com.in28mins.microservices.microservicenamingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceNamingServerApplication.class, args);
	}

}

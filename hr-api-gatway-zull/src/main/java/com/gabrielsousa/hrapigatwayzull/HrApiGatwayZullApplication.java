package com.gabrielsousa.hrapigatwayzull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HrApiGatwayZullApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApiGatwayZullApplication.class, args);
	}

}

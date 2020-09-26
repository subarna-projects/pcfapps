package com.example.CoverageCalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients("com.example.CoverageCalculator")
@SpringBootApplication
public class CoverageCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoverageCalculatorApplication.class, args);
	}

}

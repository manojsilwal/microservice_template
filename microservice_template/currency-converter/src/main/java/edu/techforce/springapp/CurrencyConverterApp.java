package edu.techforce.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("edu.techforce.springapp")
@EnableCircuitBreaker
@EnableDiscoveryClient
public class CurrencyConverterApp {
	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterApp.class, args);
	}
}

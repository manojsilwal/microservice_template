package com.techforce.springBatch_demo;

import com.techforce.springBatch_demo.FileStorage.FileStorageProperties;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableBatchProcessing
@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class SpringBatchDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchDemoApplication.class, args);
	}
}

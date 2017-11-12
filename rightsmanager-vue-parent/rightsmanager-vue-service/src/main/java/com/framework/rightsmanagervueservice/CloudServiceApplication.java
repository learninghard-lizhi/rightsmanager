package com.framework.rightsmanagervueservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@Configuration
@MapperScan(basePackages = {"com.framework.rightsmanagervueservice.dao"})
public class CloudServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CloudServiceApplication.class, args);
	}
}

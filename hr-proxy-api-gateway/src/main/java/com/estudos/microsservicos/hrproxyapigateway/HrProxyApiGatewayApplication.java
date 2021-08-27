package com.estudos.microsservicos.hrproxyapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import jdk.jfr.Enabled;

@SpringBootApplication
@EnableEurekaClient
public class HrProxyApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrProxyApiGatewayApplication.class, args);
	}

}

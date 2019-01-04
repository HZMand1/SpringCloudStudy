package com.forezp.scfchapter1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerOneApplication.class, args);
	}

}


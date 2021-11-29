package com.zk.esdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class EsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsDemoApplication.class, args);
	}

}

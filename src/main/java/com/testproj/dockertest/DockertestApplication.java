package com.testproj.dockertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class DockertestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockertestApplication.class, args);
	}

}

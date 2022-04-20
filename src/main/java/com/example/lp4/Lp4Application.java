package com.example.lp4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = {"com.example.lp4.controller"})
public class Lp4Application {

	public static void main(String[] args) {
		SpringApplication.run(Lp4Application.class, args);
	}

}

package com.jptest.epc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.jptest.epc.controllers.EPCController;

@EnableAutoConfiguration 
@ComponentScan(basePackages = "com.jptest.epc")
@SpringBootApplication
public class EpcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpcApplication.class, args);
	}

}

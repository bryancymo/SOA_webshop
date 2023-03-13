package com.webshop.SOA_webshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.webshop.SOA_webshop.controllers.WebshopController;

@SpringBootApplication
public class SoaWebshopApplication {

	public static void main(String[] args) {
		WebshopController wc = new WebshopController();
		SpringApplication.run(SoaWebshopApplication.class, args);		
		
	}

}

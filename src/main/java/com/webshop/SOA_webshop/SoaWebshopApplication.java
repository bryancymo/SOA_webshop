package com.webshop.SOA_webshop;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.webshop.SOA_webshop.contents.User;
import com.webshop.SOA_webshop.contents.Webshop;

@SpringBootApplication
public class SoaWebshopApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SoaWebshopApplication.class, args);
		
		Webshop webshop = new Webshop();
		
		webshop.addProduct(1, "SOA for dummies", 20.00);
		
		webshop.login("admin", "admin");
		
		webshop.buyProductsById(1, 20);
		
		webshop.showCartContent();
		webshop.checkout();
		
		
		
	}

}

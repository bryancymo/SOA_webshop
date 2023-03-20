package com.webshop.SOA_webshop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webshop.SOA_webshop.contents.CartItem;


public class ShippingService {
	
	public boolean shipItems(List<CartItem> cart, String address) {
		
		if(address.isBlank()) {
			return false;
		}
		
		System.out.printf("Items worden verzonden naar %s", address);
		return true;
		
	}

}

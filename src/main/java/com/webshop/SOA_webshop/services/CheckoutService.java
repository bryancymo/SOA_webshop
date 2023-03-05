package com.webshop.SOA_webshop.services;

import java.util.List;

import com.webshop.SOA_webshop.contents.CartItem;

public class CheckoutService {
	
	private CartService cartService;
	
	public CheckoutService(CartService cartService) {
		this.cartService = cartService;
	}
	
	public boolean checkout(String currentUser) {
		
		List<CartItem> cartItems = cartService.getCartItems(currentUser);
		
		if(cartItems.isEmpty()) {
			System.out.println("Geen items in de cart");
			return false;
		}
		
		double totalPrice = cartService.getTotalPrice(currentUser);
		
		cartService.clearCart(currentUser);
		
		System.out.printf("Je moet €%.2f betalen", totalPrice);
		
		return true;
		
	}

}

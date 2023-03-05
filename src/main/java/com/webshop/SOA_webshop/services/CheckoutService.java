package com.webshop.SOA_webshop.services;

import java.util.List;

import com.webshop.SOA_webshop.contents.CartItem;

public class CheckoutService {
	
	private CartService cartService;
	
	public CheckoutService(CartService cartService) {
		this.cartService = cartService;
	}
	
	public boolean checkout() {
		
		List<CartItem> cartItems = cartService.getCartItems();
		
		if(cartItems.isEmpty()) {
			System.out.println("No items in the cart, you cannot checkout");
			return false;
		}
		
		double totalPrice = cartService.getTotalPrice();
		
		cartService.clearCart();
		
		System.out.printf("Je moet %d betalen", totalPrice);
		
		return true;
		
	}

}

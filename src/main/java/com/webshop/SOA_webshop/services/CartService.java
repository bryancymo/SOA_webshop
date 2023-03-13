package com.webshop.SOA_webshop.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.webshop.SOA_webshop.contents.CartItem;

public class CartService {	
	
	private Map<String, List<CartItem>> carts;
	
	public CartService() {
		carts = new HashMap<>();
	}
	
	public void addItemToCart(String username, CartItem cartItem) {
        List<CartItem> cart = carts.get(username);
        if (cart == null) {
            cart = new ArrayList<>();
            carts.put(username, cart);
        }
        cart.add(cartItem);
	}
	
	public void changeQuantity(String username, CartItem ci, int quantity) {
		for(CartItem cartItem : carts.get(username)) {
			if(cartItem == ci) {
				cartItem.setQuantity(quantity);
			}
		}
	}
	
	public void removeItemFromCart(String username, CartItem cartItem) {
		carts.get(username).remove(cartItem);
	}
	
	public List<CartItem> getCartItems(String username) {
		return carts.get(username);
	}
	
	public double getTotalPrice(String username) {
		double totalPrice = 0;
		
		for(CartItem cartItem : carts.get(username)) {
			totalPrice += cartItem.getProduct().getPrice() * cartItem.getQuantity();
		}
		
		return totalPrice;
	}
	
	public void clearCart(String username) {
		carts.remove(username);
	}
	
}

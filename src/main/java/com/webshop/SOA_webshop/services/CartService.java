package com.webshop.SOA_webshop.services;

import java.util.ArrayList;
import java.util.List;

import com.webshop.SOA_webshop.contents.CartItem;

public class CartService {

	private List<CartItem> cartItemList = new ArrayList<>();
	
	public void addItemToCart(CartItem cartItem) {
		cartItemList.add(cartItem);
	}
	
	public void changeQuantity(CartItem ci, int quantity) {
		for(CartItem cartItem : cartItemList) {
			if(cartItem == ci) {
				cartItem.setQuantity(quantity);
			}
		}
	}
	
	public void removeItemFromCart(CartItem cartItem) {
		cartItemList.remove(cartItem);
	}
	
	public List<CartItem> getCartItems() {
		return cartItemList;
	}
	
	public double getTotalPrice() {
		double totalPrice = 0;
		
		for(CartItem cartItem : cartItemList) {
			totalPrice += cartItem.getProduct().getPrice() * cartItem.getQuantity();
		}
		
		return totalPrice;
	}
	
	public void clearCart() {
		this.cartItemList.clear();
	}
	
}

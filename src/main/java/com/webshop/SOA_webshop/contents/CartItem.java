package com.webshop.SOA_webshop.contents;

public class CartItem {
	
	private Product product;
	private int quantity;
	
	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

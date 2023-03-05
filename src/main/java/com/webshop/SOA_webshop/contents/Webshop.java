package com.webshop.SOA_webshop.contents;

import java.util.List;

import com.webshop.SOA_webshop.controllers.WebshopController;

public class Webshop {
	
	private WebshopController webShopController;
	
	public Webshop() {
		this.webShopController = new WebshopController();
	}
	
	public void addProduct(int id, String name, double price) {
		Product product = new Product(id, name, price);
		webShopController.addProduct(product);
	}
	
	public void showProducts() {
		List<Product> products = this.webShopController.getAllProducts();
		System.out.println("Overzicht van alle products:");
	    for (Product product : products) {
            System.out.printf("%s - €%d", product.getName(), product.getPrice());
        }
	}
	
	public void buyProductsById(int productid, int quantity) {
		List<Product> products = this.webShopController.getAllProducts();
		for(Product product : products) {
			if(product.getId() == productid) {
				CartItem cartItem = new CartItem(product, quantity);
				this.webShopController.addItemToCart(cartItem);
			}
		}
		

	}
	
	public void showCartContent() {
		List<CartItem> cartItems = webShopController.getCartItems();
        System.out.println("\nCart Items:");
        for (CartItem cartItem : cartItems) {
            System.out.printf("%s - %d x €%.2f%n", cartItem.getProduct().getName(), cartItem.getQuantity(), cartItem.getProduct().getPrice());
        }
        System.out.println("Totale prijs: €" + webShopController.getTotalPrice());
    }
	
	public void checkout() {
		this.webShopController.checkout();
	}
	
	public void login(String username, String password) {
		this.webShopController.login(username, password);
	}
	
	public void logout() {
		this.webShopController.logout();
	}

}

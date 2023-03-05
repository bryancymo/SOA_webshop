package com.webshop.SOA_webshop.controllers;

import java.util.List;

import com.webshop.SOA_webshop.contents.CartItem;
import com.webshop.SOA_webshop.contents.Product;
import com.webshop.SOA_webshop.services.CartService;
import com.webshop.SOA_webshop.services.CheckoutService;
import com.webshop.SOA_webshop.services.ProductService;

public class WebshopController {
	private ProductService productService;
	private CartService cartService;
	private CheckoutService checkoutService;
	
	public WebshopController() {
		this.productService = new ProductService();
		this.cartService = new CartService();
		this.checkoutService = new CheckoutService(cartService);
	}
	
	
	public void addProduct(Product product) {
        productService.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    public Product getProductById(int id) {
        return productService.getProductById(id);
    }

    public void addItemToCart(CartItem cartItem) {
        cartService.addItemToCart(cartItem);
    }

    public void removeItemFromCart(CartItem cartItem) {
        cartService.removeItemFromCart(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartService.getCartItems();
    }

    public double getTotalPrice() {
        return cartService.getTotalPrice();
    }
    
    public boolean checkout() {
    	return checkoutService.checkout();
    }

}

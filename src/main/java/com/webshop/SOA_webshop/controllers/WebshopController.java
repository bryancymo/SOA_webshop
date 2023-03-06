package com.webshop.SOA_webshop.controllers;

import java.util.List;

import com.webshop.SOA_webshop.contents.CartItem;
import com.webshop.SOA_webshop.contents.Product;
import com.webshop.SOA_webshop.services.CartService;
import com.webshop.SOA_webshop.services.CheckoutService;
import com.webshop.SOA_webshop.services.LoginService;
import com.webshop.SOA_webshop.services.ProductService;
import com.webshop.SOA_webshop.services.ShippingService;

public class WebshopController {
	private ProductService productService;
	private CartService cartService;
	private CheckoutService checkoutService;
	private LoginService loginService;
	private String currentUser;
	private ShippingService shippingService;
	
	public WebshopController() {
		this.productService = new ProductService();
		this.cartService = new CartService();
		this.checkoutService = new CheckoutService(cartService);
		this.loginService = new LoginService();
		this.shippingService = new ShippingService();
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
        cartService.addItemToCart(currentUser, cartItem);
    }

    public void removeItemFromCart(CartItem cartItem) {
        cartService.removeItemFromCart(currentUser, cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartService.getCartItems(currentUser);
    }

    public double getTotalPrice() {
        return cartService.getTotalPrice(currentUser);
    }
    
    public boolean checkout() {
    	boolean checkout = checkoutService.checkout(currentUser);
    	
    	if(checkout) {
    		System.out.println("De items worden zo snel mogelijk verzonden");
    		return shippingService.shipItems(cartService.getCartItems(currentUser), currentUser);
    	} else {
    		System.out.println("Er zijn geen items verzonden");
    	}
    	
    	return checkout;
    }
    
    public void login(String username, String password) {
    	
    	if(this.loginService.login(username, password)) {
    		currentUser =  username;
    	} else {
    		currentUser = "";
    	}
    }
    
    public void logout() {
    	this.loginService.logout();
    	currentUser = "";
    }

}

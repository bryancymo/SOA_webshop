package com.webshop.SOA_webshop.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

	@GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

	@GetMapping("products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

	@PostMapping("/carts/{username}/{productId}/{quantity}")
    public void addItemToCart(@PathVariable String username, @PathVariable int productId, @PathVariable int quantity) {
		CartItem cartItem = new CartItem(getProductById(productId), quantity);
        cartService.addItemToCart(username, cartItem);
    }

	@DeleteMapping("/carts/{username}/{productId}/{quantity}")
    public void removeItemFromCart(@PathVariable String username, @PathVariable int productId, @PathVariable int quantity) {
		CartItem cartItem = new CartItem(getProductById(productId), quantity);
        cartService.removeItemFromCart(username, cartItem);
    }

	@GetMapping("/carts/{username}")
    public List<CartItem> getCartItems(@PathVariable String username) {
        return cartService.getCartItems(username);
    }

   @DeleteMapping("/carts/{userId}")
   public void clearCart(@PathVariable String username) {
      cartService.clearCart(username);
   }
	
   @GetMapping("/carts/{username}")
    public double getTotalPrice(@PathVariable String username) {
        return cartService.getTotalPrice(username);
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

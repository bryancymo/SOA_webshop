package com.webshop.SOA_webshop.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webshop.SOA_webshop.contents.CartItem;
import com.webshop.SOA_webshop.contents.Product;
import com.webshop.SOA_webshop.services.CartService;
import com.webshop.SOA_webshop.services.CheckoutService;
import com.webshop.SOA_webshop.services.LoginService;
import com.webshop.SOA_webshop.services.ProductService;
import com.webshop.SOA_webshop.services.ShippingService;

@RestController
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
	
	@GetMapping("/")
	public String ping() {
		return "This works";
	}
//
//	@PostMapping("/products")
//	public void addProduct(@RequestBody int id, @RequestBody String productName, @RequestBody double price) {
//		Product product = new Product(id, productName, price);
//        productService.addProduct(product);
//    }
//
//	@GetMapping("/products")
//    public String getAllProducts() {
////        return productService.getAllProducts();
//		return "hello world";
//    }
//
//	@GetMapping("products/{id}")
//    public Product getProductById(@PathVariable int id) {
//        return productService.getProductById(id);
//    }
//
//	@PostMapping("/carts/{username}/{productId}/{quantity}")
//    public void addItemToCart(@PathVariable String username, @PathVariable int productId, @PathVariable int quantity) {
//		CartItem cartItem = new CartItem(getProductById(productId), quantity);
//        cartService.addItemToCart(currentUser, cartItem);
//    }
//
//	@DeleteMapping("/carts/{username}/{productId}/{quantity}")
//    public void removeItemFromCart(@PathVariable String username, @PathVariable int productId, @PathVariable int quantity) {
//		CartItem cartItem = new CartItem(getProductById(productId), quantity);
//        cartService.removeItemFromCart(currentUser, cartItem);
//    }
//
//	@GetMapping("/carts/{username}")
//    public List<CartItem> getCartItems(@PathVariable String username) {
//        return cartService.getCartItems(currentUser);
//    }
//
//   @DeleteMapping("/carts/{username}")
//   public void clearCart(@PathVariable String username) {
//      cartService.clearCart(currentUser);
//   }
//
//   @GetMapping("/carts/{username}")
//    public double getTotalPrice(@PathVariable String username) {
//	   return cartService.getTotalPrice(currentUser);
//    }
//
//    public boolean checkout() {
//    	boolean checkout = checkoutService.checkout(currentUser);
//
//    	if(checkout) {
//    		System.out.println("De items worden zo snel mogelijk verzonden");
//    		return shippingService.shipItems(cartService.getCartItems(currentUser), currentUser);
//    	} else {
//    		System.out.println("Er zijn geen items verzonden");
//    	}
//
//    	return checkout;
//    }
//
//    @GetMapping("/login/{username}/{password}")
//    public void login(String username, String password) {
//
//    	if(this.loginService.login(username, password)) {
//    		currentUser =  username;
//    	} else {
//    		currentUser = "";
//    	}
//    }
//
//    public void logout() {
//    	this.loginService.logout();
//    	currentUser = "";
//    }

}

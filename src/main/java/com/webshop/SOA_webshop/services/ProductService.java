package com.webshop.SOA_webshop.services;

import java.util.ArrayList;
import java.util.List;

import com.webshop.SOA_webshop.contents.Product;

public class ProductService {

	private List<Product> productList = new ArrayList<>();
	
	public void addProduct(Product prod) {
		productList.add(prod);
	}
	
	public List<Product> getAllProducts() {
		return productList;
	}
	
	public Product getProductById(int id) {
		for (Product prod : productList) {
			if (prod.getId() == id) {
				return prod;
			}
		}
		
		return null;
	}
	
}

package com.webshop.SOA_webshop.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.webshop.SOA_webshop.contents.CartItem;
import com.webshop.SOA_webshop.contents.Product;
import com.webshop.SOA_webshop.databaseConnection.DatabaseConnection;

public class CartService {	
	
	private Map<String, List<CartItem>> carts;
	
	
	public CartService() {
		carts = new HashMap<>();
	}
	
	public void addItemToCart(String username, CartItem cartItem) {
//        List<CartItem> cart = carts.get(username);
//        if (cart == null) {
//            cart = new ArrayList<>();
//            carts.put(username, cart);
//        }
//        cart.add(cartItem);
		int rowsAffected;
		try {
			
			MysqlDataSource ds = new MysqlDataSource();
			ds.setDatabaseName("DATABASE");
			ds.setUser("USERNAME");
			ds.setPassword("USER PASSWORD");
			ds.setServerName("localhost");
			ds.setPort(3306);
			Connection connection = ds.getConnection();
			
			rowsAffected = connection.createStatement().executeUpdate(String.format("INSERT IGNORE INTO CartItems VALUES (%s, %d, %d)", username, cartItem.getProduct().getId(), cartItem.getQuantity()));
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void changeQuantity(String username, CartItem ci, int quantity) {
		for(CartItem cartItem : carts.get(username)) {
			if(cartItem == ci) {
				cartItem.setQuantity(quantity);
			}
		}
	}
	
	public void removeItemFromCart(String username, CartItem cartItem) {
		int rowsAffected;
		try {
			
			MysqlDataSource ds = new MysqlDataSource();
			ds.setDatabaseName("DATABASE");
			ds.setUser("USERNAME");
			ds.setPassword("USER PASSWORD");
			ds.setServerName("localhost");
			ds.setPort(3306);
			Connection connection = ds.getConnection();
			
			rowsAffected = connection.createStatement().executeUpdate(String.format("DELETE FROM CartItems WHERE Username = %s AND ProductID = %d", username, cartItem.getProduct().getId()));
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<CartItem> getCartItems(String username) {

		List<CartItem> cartItems = new ArrayList<>();
		ResultSet resultSet;
		try {
			
			MysqlDataSource ds = new MysqlDataSource();
			ds.setDatabaseName("DATABASE");
			ds.setUser("USERNAME");
			ds.setPassword("USER PASSWORD");
			ds.setServerName("localhost");
			ds.setPort(3366);
			Connection connection = ds.getConnection();
			
			resultSet = connection.createStatement().executeQuery(String.format("SELECT * FROM CartItems WHERE Username = %s", username));
			
			while(resultSet.next()) {
				int productID = resultSet.getInt(2);
				int quantity = resultSet.getInt(3);
				
				ResultSet resultSet2 = connection.createStatement().executeQuery(String.format("SELECT * FROM Products WHERE ProductID = %s", productID));
				while(resultSet2.next()) {
					Product prod = new Product(resultSet2.getInt(1), resultSet2.getString(2), resultSet2.getDouble(3));
					cartItems.add(new CartItem(prod, quantity));
				}
				
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cartItems;
	}
	
	public double getTotalPrice(String username) {
		double price = 0;
		ResultSet resultSet;
		try {
			
			MysqlDataSource ds = new MysqlDataSource();
			ds.setDatabaseName("DATABASE");
			ds.setUser("USERNAME");
			ds.setPassword("USER PASSWORD");
			ds.setServerName("localhost");
			ds.setPort(3366);
			Connection connection = ds.getConnection();
			
			resultSet = connection.createStatement().executeQuery(String.format("SELECT SUM(ProductPrice) FROM Products p JOIN CartItems ci ON  p.ProductID = ci.ProductID WHERE ci.Username = %s", username));
			
			while(resultSet.next()) {
				price += resultSet.getDouble(1);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return price;
	}
	
	public void clearCart(String username) {
		
		int rowsAffected;
		try {
			
			MysqlDataSource ds = new MysqlDataSource();
			ds.setDatabaseName("DATABASE");
			ds.setUser("USERNAME");
			ds.setPassword("USER PASSWORD");
			ds.setServerName("localhost");
			ds.setPort(3366);
			Connection connection = ds.getConnection();
			
			rowsAffected = connection.createStatement().executeUpdate(String.format("DELETE FROM CartItems WHERE Username = %s", username));
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		carts.remove(username);
	}
	
}

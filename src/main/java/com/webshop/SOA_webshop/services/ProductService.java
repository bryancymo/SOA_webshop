package com.webshop.SOA_webshop.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.webshop.SOA_webshop.contents.Product;
import com.webshop.SOA_webshop.databaseConnection.DatabaseConnection;


public class ProductService {
	
	public void addProduct(Product prod) {
		int rowsAffected;
		try {
			
			MysqlDataSource ds = new MysqlDataSource();
			ds.setDatabaseName("DATABASE");
			ds.setUser("USERNAME");
			ds.setPassword("USER PASSWORD");
			ds.setServerName("localhost");
			ds.setPort(3366);
			Connection connection = ds.getConnection();
			
			rowsAffected = connection.createStatement().executeUpdate(String.format("INSERT IGNORE INTO Products VALUES (%d, %s, %f)", prod.getId(), prod.getName(), prod.getPrice()));
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Product> getAllProducts() {
		
		List<Product> productList = new ArrayList<>();
		ResultSet resultSet;
		try {
			
			MysqlDataSource ds = new MysqlDataSource();
			ds.setDatabaseName("DATABASE");
			ds.setUser("USERNAME");
			ds.setPassword("USER PASSWORD");
			ds.setServerName("localhost");
			ds.setPort(3366);
			Connection connection = ds.getConnection();
			
			resultSet = connection.createStatement().executeQuery(String.format("SELECT * FROM Products"));
			
			while(resultSet.next()) {
				productList.add(new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3)));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productList;
	}
	
	public Product getProductById(int id) {
		ResultSet resultSet;
		try {
			
			MysqlDataSource ds = new MysqlDataSource();
			ds.setDatabaseName("DATABASE");
			ds.setUser("USERNAME");
			ds.setPassword("USER PASSWORD");
			ds.setServerName("localhost");
			ds.setPort(3366);
			Connection connection = ds.getConnection();
			
			resultSet = connection.createStatement().executeQuery(String.format("SELECT * FROM Products WHERE ProductID = %d", id));
			
			while(resultSet.next()) {
				return new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}

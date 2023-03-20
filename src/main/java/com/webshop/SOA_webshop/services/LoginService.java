package com.webshop.SOA_webshop.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.webshop.SOA_webshop.contents.User;


public class LoginService {
	
	private Map<String, User> users;
	
	public LoginService() {
		users = new HashMap<>();
		User user1 = new User("admin", "admin");
		User user2 = new User("joran", "1234");
		users.put(user1.getUsername(), user1);
		users.put(user2.getUsername(), user2);
	}
	
	public boolean login(String username, String password) {
//		String passwordToMatch = users.get(username).getPassword();
		
		ResultSet resultSet;
		try {
			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3366/db","user","password");
			MysqlDataSource ds = new MysqlDataSource();
			ds.setDatabaseName("DATABASE");
			ds.setUser("USERNAME");
			ds.setPassword("USER PASSWORD");
			ds.setServerName("localhost");
			ds.setPort(3366);
			Connection connection = ds.getConnection();
			
			resultSet = connection.createStatement().executeQuery(String.format("SELECT Pw FROM Users WHERE Username = '%s'", username));
			String passwordToMatch = null;
			
			while(resultSet.next()) {
				System.out.println(resultSet);
				passwordToMatch = resultSet.getString(1);
			}
			connection.close();
			if(passwordToMatch != null && passwordToMatch.equals(password)) {
				System.out.printf("Ingelogd als: %s%n", username);
				return true;
			} else {
				System.out.println("Combinatie gebruikersnaam-wachtwoord bestaat niet");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void logout() {
		System.out.println("Je bent succesvol uitgelogd");
	}

}

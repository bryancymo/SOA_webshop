package com.webshop.SOA_webshop.databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	
	
	public Connection getDbConnection() {
		
		Connection connection;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3366/db","user","password");
			
//			Statement statement;
//            statement = connection.createStatement();
//            ResultSet resultSet;
//            resultSet = statement.executeQuery(
//                "select * from Products");
//
//            while (resultSet.next()) {
//            	System.out.println(resultSet.getInt(1)+"  "+resultSet.getString(2)+"  "+resultSet.getString(3));  
//            }
			
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}

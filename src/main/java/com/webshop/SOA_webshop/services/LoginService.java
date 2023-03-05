package com.webshop.SOA_webshop.services;

import java.util.HashMap;
import java.util.Map;

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
		String passwordToMatch = users.get(username).getPassword();
		
		if(passwordToMatch != null && passwordToMatch.equals(password)) {
			System.out.printf("Ingelogd als: %s%n", username);
			return true;
		} else {
			System.out.println("Combinatie gebruikersnaam-wachtwoord bestaat niet");
			return false;
		}
	}
	
	public void logout() {
		System.out.println("Je bent succesvpol uitgelogd");
	}

}

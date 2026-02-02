package org.hdcd.Rombok.model;

import lombok.Data;

@Data
public class User {
	private final String username;
	private String email;
	
	public User(String username, String email) {
		this.username = username;
		this.email = email;
	}
}

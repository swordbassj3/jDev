package org.hdcd.Rombok.service;

import java.util.ArrayList;
import java.util.List;

import org.hdcd.Rombok.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final List<User> users = new ArrayList<>();
	
	public User createUser(User user) {
		users.add(user);
		return user;
	}
	
	public List<User> getAllUsers(){
		return users;
	}
}

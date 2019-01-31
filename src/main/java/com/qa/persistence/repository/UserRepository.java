package com.qa.persistence.repository;

import com.qa.persistence.domain.User;

public interface UserRepository {
	
	String getAllUsers();
	User findUser(Long userId);
	String addUser(String user);
	String updateUser(Long userId, String user);
	String removeUser(Long userId);

}

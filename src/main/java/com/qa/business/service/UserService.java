package com.qa.business.service;

import com.qa.persistence.domain.User;

public interface UserService {

	String getAllUsers();

	User findUser(Long userId);

	String addUser(String user);

	String updateUser(Long userId, String user);

	String removeUser(Long userId);

}

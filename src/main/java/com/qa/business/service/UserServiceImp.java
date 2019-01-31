package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.User;
import com.qa.persistence.repository.UserRepository;

public class UserServiceImp implements UserService {
	
	@Inject
	private UserRepository repo;
	
	public String getAllUsers() {
		return repo.getAllUsers();
	}
	
	public User findUser(Long userId) {
		return repo.findUser(userId);
	}
	
	public String addUser(String user) {
		return repo.addUser(user);
	}
	
	public String updateUser(Long userId, String user) {
		return repo.updateUser(userId, user);
	}
	
	public String removeUser(Long userId) {
		return repo.removeUser(userId);
	}

	public UserRepository getRepo() {
		return repo;
	}

	public void setRepo(UserRepository repo) {
		this.repo = repo;
	}

}

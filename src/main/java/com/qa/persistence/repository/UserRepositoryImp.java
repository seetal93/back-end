package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class UserRepositoryImp implements UserRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getAllUsers() {
		Query query = manager.createQuery("Select a FROM User a");
		@SuppressWarnings("unchecked")
		Collection<User> users = (Collection<User>) query.getResultList();
		return util.getJSONForObject(users);
	}
	
	public User findUser(Long userId) {
		return manager.find(User.class, userId);
	}
	
	@Transactional(REQUIRED)
	public String addUser(String user) {
		User aUser = util.getObjectForJSON(user, User.class);
		manager.persist(aUser);
		return "{\"message\": \"user has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateUser(Long userId, String user) {
		User userInDB = findUser(userId);
		if (userInDB != null) {
			manager.remove(userInDB);
			User userUpdateInDB = util.getObjectForJSON(user, User.class);
			manager.persist(userUpdateInDB);
		}
		return "{\"message\": \"user has been sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String removeUser(Long userId) {
		User userInDB = findUser(userId);
		if (userInDB != null) {
			manager.remove(userInDB);
		}
		return "{\"message\": \"user has been sucessfully removed\"}";
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}

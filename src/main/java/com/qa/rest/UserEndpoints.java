package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.UserService;

@Path("/fetch")
public class UserEndpoints {

	@Inject
	private UserService service;

	@Path("/getAllUsers")
	@GET
	@Produces({ "application/json" })
	public String getAllUsers() {
		return service.getAllUsers();
	}
	
	@Path("/addUser/")
	@POST
	@Produces({ "application/json" })
	public String addUser(String user) {
		return service.addUser(user);
	}

	@Path("/updateUser/{id}")
	@POST
	@Produces({ "application/json" })
	public String updateUser(@PathParam("id") Long userId, String user) {
		return service.updateUser(userId, user);
	}

	@Path("/removeUser/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String removeUser(@PathParam("id") Long userId) {
		return service.removeUser(userId);
	}
	
	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

}

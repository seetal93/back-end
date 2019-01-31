package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.DBEntryService;

@Path("/fetch")
public class DBEntryEndpoints {
	@Inject
	private DBEntryService service;

	@Path("/getAllDBEntries")
	@GET
	@Produces({ "application/json" })
	public String getAllDBEntries() {
		return service.getAllDBEntries();
	}
	
	@Path("/addDBEntry/")
	@POST
	@Produces({ "application/json" })
	public String addDBEntry(String dbentry) {
		return service.addDBEntry(dbentry);
	}

	@Path("/updateDBEntry/{id}")
	@POST
	@Produces({ "application/json" })
	public String updateDBEntry(@PathParam("id") Long id, String dbentry) {
		return service.updateDBEntry(id, dbentry);
	}

	@Path("/removeDBEntry/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String removeDBEntry(@PathParam("id") Long id) {
		return service.removeDBEntry(id);
	}
	
	public DBEntryService getService() {
		return service;
	}

	public void setService(DBEntryService service) {
		this.service = service;
	}

}

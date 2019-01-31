package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.DBEntry;
import com.qa.persistence.repository.DBEntryRepository;

public class DBEntryServiceImp implements DBEntryService {
	
	@Inject
	private DBEntryRepository repo;
	
	public String getAllDBEntries() {
		return repo.getAllDBEntries();
	}
	
	public DBEntry findDBEntry(Long id) {
		return repo.findDBEntry(id);
	}
	
	public String addDBEntry(String dbentry) {
		return repo.addDBEntry(dbentry);
	}
	
	public String updateDBEntry(Long id, String dbentry) {
		return repo.updateDBEntry(id, dbentry);
	}
	
	public String removeDBEntry(Long userId) {
		return repo.removeDBEntry(userId);
	}

	public DBEntryRepository getRepo() {
		return repo;
	}

	public void setRepo(DBEntryRepository repo) {
		this.repo = repo;
	}

}



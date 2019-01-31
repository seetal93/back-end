package com.qa.business.service;

import com.qa.persistence.domain.DBEntry;

public interface DBEntryService {
	
	String getAllDBEntries();
	DBEntry findDBEntry(Long id);
	String addDBEntry(String dbentry);
	String updateDBEntry(Long id, String dbentry);
	String removeDBEntry(Long id);


}


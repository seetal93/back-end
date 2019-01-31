package com.qa.persistence.repository;

import com.qa.persistence.domain.DBEntry;

public interface DBEntryRepository {

	String getAllDBEntries();
	DBEntry findDBEntry(Long id);
	String addDBEntry(String dbentry);
	String updateDBEntry(Long id, String dbentry);
	String removeDBEntry(Long id);
}

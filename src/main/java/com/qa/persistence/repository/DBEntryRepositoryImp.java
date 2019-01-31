package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.DBEntry;
import com.qa.util.JSONUtil;

public class DBEntryRepositoryImp implements DBEntryRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllDBEntries() {
		Query query = manager.createQuery("Select a FROM DBEntry a");
		@SuppressWarnings("unchecked")
		Collection<DBEntry> entries = (Collection<DBEntry>) query.getResultList();
		return util.getJSONForObject(entries);
	}
	
	public DBEntry findDBEntry(Long id) {
		return manager.find(DBEntry.class, id);
	}
	
	@Transactional(REQUIRED)
	public String addDBEntry(String dbentry) {
		DBEntry aDBEntry = util.getObjectForJSON(dbentry, DBEntry.class);
		manager.persist(aDBEntry);
		return "{\"message\": \"database entry has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateDBEntry(Long id, String dbentry) {
		DBEntry entryInDB = findDBEntry(id);
		if (entryInDB != null) {
			manager.remove(entryInDB);
			DBEntry entryUpdateInDB = util.getObjectForJSON(dbentry, DBEntry.class);
			manager.persist(entryUpdateInDB);
		}
		return "{\"message\": \"database entry has been sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String removeDBEntry(Long id) {
		DBEntry entryInDB = findDBEntry(id);
		if (entryInDB != null) {
			manager.remove(entryInDB);
		}
		return "{\"message\": \"database entry has been sucessfully removed\"}";
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

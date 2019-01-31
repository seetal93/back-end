package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DBEntry")
public class DBEntry {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Size(min = 0, max = 32)
	@Column(name = "dogName")
	private String dogName;
	
	@Size(min = 0, max = 32)
	@Column(name = "status")
	private String status;
	
	@Size(min = 0, max = 32)
	@Column(name = "breedOfDog")
	private String breedOfDog;
	
	@Size(min = 0, max = 32)
	@Column(name = "about")
	private String about;
	
	@Column(name = "image")
	private String image;
	
	public DBEntry() {
		
	}
	
	public DBEntry(String dogName, String status, String breedOfDog, String age, String about, String image) {
		this.dogName = dogName;
		this.status = status;
		this.breedOfDog = breedOfDog;
		this.about = about;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBreedOfDog() {
		return breedOfDog;
	}

	public void setBreedOfDog(String breedOfDog) {
		this.breedOfDog = breedOfDog;
	}


	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}

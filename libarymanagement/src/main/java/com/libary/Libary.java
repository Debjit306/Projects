package com.libary;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Libary")

//POJO class
public class Libary {

	@Id
	@Column(name = "bookId")
	private int id;

	@Column(name = "bookName")
	private String bookName;

	@Column(name = "publisherName")
	private String publisherName;

	@Column(name = "dateOfPublish")
	private int dateOfPublish;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public int getDateOfPublish() {
		return dateOfPublish;
	}

	public void setDateOfPublish(int dateOfPublish) {
		this.dateOfPublish = dateOfPublish;
	}

}

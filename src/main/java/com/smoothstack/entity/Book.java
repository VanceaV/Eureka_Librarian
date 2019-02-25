package com.smoothstack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "tbl_book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", unique = true, nullable = false)
	private long id;

	@Column(name = "title")
	private String title;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "authId", referencedColumnName = "authorId", insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Author author;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pubId", referencedColumnName = "publisherId", insertable = true, updatable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Publisher publisher;

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

}
package com.smoothstack.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "tbl_book_copies")
public class BookCopies {

	@EmbeddedId
	private BookCopiesId id;

	@Column(name = "no_of_copies")
	private int noOfCopies;

	public BookCopiesId getId() {
		return id;
	}

	public void setId(BookCopiesId id) {
		this.id = id;
	}

	@Column(name = "book_id")
	public Book getBook() {
		return id.getBook();
	}

	public void setBook(Book book) {
		this.id.setBook(book);
	}

	@Column(name = "branch_id")
	public LibraryBranch getLibraryBranch() {
		return id.getLibraryBranch();
	}

	public void setLibraryBranch(LibraryBranch libraryBranch) {
		this.id.setLibraryBranch(libraryBranch);
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public void decrementNumberOfCopies() {
		if (noOfCopies > 0)
			noOfCopies--;
	}

	public void incrementNumberOfCopies() {
		noOfCopies++;
	}

}

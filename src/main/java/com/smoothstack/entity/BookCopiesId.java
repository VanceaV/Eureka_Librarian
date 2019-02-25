package com.smoothstack.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Embeddable
public class BookCopiesId implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookId", referencedColumnName = "book_id", insertable = true, updatable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Book book;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branchId", referencedColumnName = "branch_id", insertable = true, updatable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private LibraryBranch libraryBranch;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LibraryBranch getLibraryBranch() {
		return libraryBranch;
	}

	public void setLibraryBranch(LibraryBranch libraryBranch) {
		this.libraryBranch = libraryBranch;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		else if (!(obj instanceof BookCopiesId))
			return false;
		else {
			BookCopiesId bookCopiesId = (BookCopiesId) obj;
			return book.getId() == bookCopiesId.book.getId()
					&& libraryBranch.getId() == bookCopiesId.libraryBranch.getId();
		}
	}

	@Override
	public int hashCode() {

		int a = 100;
		int b = 123;

		return (int) (a * book.getId() + b * libraryBranch.getId() + hashCode());

	}

}



package com.smoothstack.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Embeddable
public class BookLoansId implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id", referencedColumnName = "book_id", insertable = true, updatable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Book book;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_id", referencedColumnName = "branch_id", insertable = true, updatable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private LibraryBranch libraryBranch;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "card_no", referencedColumnName = "card_no", insertable = true, updatable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Borrower borrower;
	
	
	

	

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

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		else if (!(obj instanceof BookLoansId))
			return false;
		else {
			BookLoansId bookLoansId = (BookLoansId) obj;
			return book.getId() == bookLoansId.book.getId()
					&& libraryBranch.getId() == bookLoansId.libraryBranch.getId()
					&& borrower.getId() == bookLoansId.borrower.getId();
		}
	}

	@Override
	public int hashCode() {

		int a = 100;
		int b = 123;
		int c = 125;

		return (int) (a * book.getId() + b * libraryBranch.getId() + c * borrower.getId() + hashCode());
	}

}



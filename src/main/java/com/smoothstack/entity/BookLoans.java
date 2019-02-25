package com.smoothstack.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "tbl_book_loans")

public class BookLoans {

	@EmbeddedId
	private BookLoansId id;

	@Column(name = "date_out")
	private LocalDate dateOut;

	@Column(name = "due_date")
	private LocalDate dueDate;

	@Column(name = "book_id")
	public Book getBook() {
		return id.getBook();
	}

	public void setBook(Book book) {
		id.setBook(book);
	}

	@Column(name = "branch_id")
	public LibraryBranch getLibraryBranch() {
		return id.getLibraryBranch();
	}

	public void setLibraryBranch(LibraryBranch libraryBranch) {
		id.setLibraryBranch(libraryBranch);
		
	}

	@Column(name = "card_no")
	public Borrower getBorrower() {
		return id.getBorrower();
	}

	public void setBorrower(Borrower borrower) {
		id.setBorrower(borrower);
	}

	public BookLoansId getId() {
		return id;
	}
	

	public void setId(BookLoansId id) {
		this.id = id;
	}

	public LocalDate getDateOut() {
		return dateOut;
	}

	public void setDateOut(LocalDate dateOut) {
		this.dateOut = dateOut;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

}


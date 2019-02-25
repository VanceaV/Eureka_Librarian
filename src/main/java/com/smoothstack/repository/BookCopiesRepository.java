package com.smoothstack.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smoothstack.Idao.IBookCopiesDao;
import com.smoothstack.entity.BookCopies;

@Service
@Transactional
public class BookCopiesRepository {

	@Autowired
	private IBookCopiesDao bookCopiesDao;

	public BookCopies getBookCopiesByBookIdAndBranchId(long bookId, long branchId) {
		return bookCopiesDao.getByBookIdAndBranchId(bookId, branchId);
	}

	public List<BookCopies> getAllBookCopies() {
		return bookCopiesDao.findAll();
	}

	public List<BookCopies> getAllBookCopiesByBranchId(long branchId) {
		return bookCopiesDao.getAllbyBranch(branchId);
	}

	public void updateNumberOfCopies(int numberOfCopies, long bookId, long branchId) {
		bookCopiesDao.updateNumberOfCopies(numberOfCopies, bookId, branchId);
	}

	public void incrementNumberOfCopiesbyOne(long bookId, long branchId) {
		BookCopies bookCopies = bookCopiesDao.getByBookIdAndBranchId(bookId, branchId);
		bookCopies.incrementNumberOfCopies();
		bookCopiesDao.save(bookCopies);

	}

	public void decrementNumberOfCopiesbyOne(long bookId, long branchId) {

		BookCopies bookCopies = bookCopiesDao.getByBookIdAndBranchId(bookId, branchId);
		bookCopies.decrementNumberOfCopies();
		bookCopiesDao.save(bookCopies);

	}
	

}



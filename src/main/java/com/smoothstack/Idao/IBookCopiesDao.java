package com.smoothstack.Idao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.smoothstack.entity.BookCopies;

public interface IBookCopiesDao extends JpaRepository<BookCopies, Long> {

	@Query("select noOfCopies from tbl_book_copies b where b.id.book.id=?1 and b.id.libraryBranch.id=?2")
	int getNumberOfCopiesByBookIdAndBranchId(long bookId, long branchId);

	@Modifying
	@Query("update tbl_book_copies b set b.noOfCopies = ?1 where b.id.book.id=?2 and b.id.libraryBranch.id=?3")
	void updateNumberOfCopies(int numberOfCopies, long bookId, long branchId);

	@Query("select b from tbl_book_copies b where b.id.libraryBranch.id=?1")
	List<BookCopies> getAllbyBranch(long branchId);

	@Query("select b from tbl_book_copies b  where b.id.book.id=?1 and b.id.libraryBranch.id=?2")
	BookCopies getByBookIdAndBranchId(long bookId, long branchId);

}

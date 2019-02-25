package com.smoothstack.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.entity.Book;
import com.smoothstack.entity.LibraryBranch;
import com.smoothstack.repository.BookCopiesRepository;
import com.smoothstack.repository.LibraryBranchRepository;

@RestController
@RequestMapping("/lms/librarian")
public class BookCopiesController {

	@Autowired
	private LibraryBranchRepository libraryBranchRepository;
	@Autowired
	private BookCopiesRepository bookCopiesRepository;

	@GetMapping("/libraryBranches")
	public ResponseEntity<List<LibraryBranch>> getAllLibraryBranches() {
		List<LibraryBranch> list = libraryBranchRepository.getAll();
		return new ResponseEntity<List<LibraryBranch>>(list, HttpStatus.OK);
	}

	@PutMapping("/libraryBranches/libraryBranch")
	public ResponseEntity<LibraryBranch> updateLibraryBranchDetails(@RequestBody LibraryBranch libraryBranch) {
		libraryBranchRepository.update(libraryBranch);
		return new ResponseEntity<LibraryBranch>(HttpStatus.OK);

	}

	@PutMapping("/libraryBranches/libraryBranch/updateNumberOfCopies")
	public ResponseEntity<LibraryBranch> updateNumberOfcopies(@RequestParam("numberOfCopies") int numberOfCopies,
			@RequestParam("bookId") long bookId, @RequestParam("branchId") long branchId) {
		bookCopiesRepository.updateNumberOfCopies(numberOfCopies, bookId, branchId);
		return new ResponseEntity<LibraryBranch>(HttpStatus.OK);
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooksWithAtLeastOneCopy(@RequestParam("branchId") long branchId) {
		List<Book> books = bookCopiesRepository.getAllBookCopies().stream()
				.filter(b -> b.getLibraryBranch().getId() == branchId).filter(b -> b.getNoOfCopies() > 0)
				.map(b -> b.getBook()).collect(Collectors.toList());
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

}

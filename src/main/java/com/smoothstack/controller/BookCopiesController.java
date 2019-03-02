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
import com.smoothstack.service.BookCopiesService;
import com.smoothstack.service.LibraryBranchService;

@RestController
@RequestMapping("/lms/librarian")
public class BookCopiesController {

	@Autowired
	private LibraryBranchService libraryBranchService;
	@Autowired
	private BookCopiesService bookCopiesService;

	@GetMapping("/libraryBranches")
	public ResponseEntity<List<LibraryBranch>> getAllLibraryBranches() {
		List<LibraryBranch> list = libraryBranchService.getAll();
		return new ResponseEntity<List<LibraryBranch>>(list, HttpStatus.OK);
	}

	@PutMapping("/libraryBranches/libraryBranch")
	public ResponseEntity<LibraryBranch> updateLibraryBranchDetails(@RequestBody LibraryBranch libraryBranch) {

		try {
			libraryBranchService.update(libraryBranch);
		} catch (Exception e) {
			return new ResponseEntity<LibraryBranch>(HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<LibraryBranch>(HttpStatus.OK);

	}

	@PutMapping("/libraryBranches/updateNumberOfCopies")
	public ResponseEntity<LibraryBranch> updateNumberOfcopies(@RequestParam("numberOfCopies") int numberOfCopies,
			@RequestParam("bookId") long bookId, @RequestParam("branchId") long branchId) {
		try {
			bookCopiesService.updateNumberOfCopies(numberOfCopies, bookId, branchId);
		} catch (Exception e) {
			return new ResponseEntity<LibraryBranch>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<LibraryBranch>(HttpStatus.OK);
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooksWithAtLeastOneCopy(@RequestParam("branchId") long branchId) {
		List<Book> books = bookCopiesService.getAllBookCopies().stream()
				.filter(b -> b.getLibraryBranch().getId() == branchId).filter(b -> b.getNoOfCopies() > 0)
				.map(b -> b.getBook()).collect(Collectors.toList());
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

}

package com.zemoso.blinklist.controller;

import java.util.List;
import java.util.Optional;

import com.zemoso.blinklist.service.IBooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zemoso.blinklist.exception.ResourceNotFoundException;
import com.zemoso.blinklist.model.Book;


@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BooksController {
	private static final Logger logger = LoggerFactory.getLogger(BooksController.class);
	@Autowired
	public IBooks booksService;

	@GetMapping("/")
	public List<Book> getAllBooks() {
		logger.debug("Method: getAllBooks(), Info: method started");
		List<Book> books =  null;
		try {
			books =  booksService.getBooks();
			logger.debug("Method: getAllBooks(), Info: method end: " + books.toString());
		} catch (ResourceNotFoundException  rnfe) {
			logger.error("Requested Books not found : " + rnfe.getMessage());
		}
		return books;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable(value = "id") long bookId) {
		logger.debug("Method: getBookById(), Info: method started");
		Optional<Book> book = null;
		try {
			;book = booksService.findBook(bookId);
			logger.debug("Method: getBookById(), Info: method end: " + book.toString());
		} catch (ResourceNotFoundException  rnfe) {
			logger.error("Requested Book not found : " + rnfe.getMessage());
		}
		return ResponseEntity.ok().body(book);
	}
}

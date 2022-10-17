package com.zemoso.blinklist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.blinklist.exception.ResourceNotFoundException;
import com.zemoso.blinklist.model.Book;
import com.zemoso.blinklist.repository.BooksRepository;

@Service
public class BooksService implements IBooks {
	
	@Autowired
	private BooksRepository bookRepository;

	public List<Book> getBooks() throws ResourceNotFoundException {
		return bookRepository.findAll();
	}
	
	public Optional<Book> findBook(Long bookId) throws ResourceNotFoundException {
		return bookRepository.findById(bookId);
	}
}

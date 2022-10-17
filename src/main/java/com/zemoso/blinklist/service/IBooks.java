package com.zemoso.blinklist.service;

import com.zemoso.blinklist.exception.ResourceNotFoundException;
import com.zemoso.blinklist.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBooks {
    public List<Book> getBooks() throws ResourceNotFoundException;
    public Optional<Book> findBook(Long bookId) throws ResourceNotFoundException;
}

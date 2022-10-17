package com.zemoso.blinklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zemoso.blinklist.model.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long>{

}

package com.example.demospring.repository;

import com.example.demospring.entity.Author;
import com.example.demospring.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findAllByAuthor(Author author);
}

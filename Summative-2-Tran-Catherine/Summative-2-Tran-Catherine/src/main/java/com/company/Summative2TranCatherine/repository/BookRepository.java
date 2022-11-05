package com.company.Summative2TranCatherine.repository;

import com.company.Summative2TranCatherine.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllBooksByAuthor(Integer authorId);

}

package com.company.Summative2TranCatherine.repository;

import com.company.Summative2TranCatherine.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}

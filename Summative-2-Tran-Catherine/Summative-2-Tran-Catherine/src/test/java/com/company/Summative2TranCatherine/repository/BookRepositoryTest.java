package com.company.Summative2TranCatherine.repository;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith((SpringJUnit4ClassRunner.class))
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    AuthorRepository authorRepo;

    @Autowired
    BookRepository bookRepo;

    @Autowired
    PublisherRepository publisherRepo;

    @Before
    public void setUp() throws Exception {
        authorRepo.deleteAll();
        bookRepo.deleteAll();
        publisherRepo.deleteAll();
    }

    @Test
    public void shouldGetBooksByAuthor() {
        // update code
    }
}
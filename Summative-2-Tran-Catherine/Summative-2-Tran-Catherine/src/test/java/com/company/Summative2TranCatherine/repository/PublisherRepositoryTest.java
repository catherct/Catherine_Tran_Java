package com.company.Summative2TranCatherine.repository;

import com.company.Summative2TranCatherine.model.Author;
import com.company.Summative2TranCatherine.model.Book;
import com.company.Summative2TranCatherine.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

public class PublisherRepositoryTest {

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
    public void shouldCreateReadDeletePublishers() throws Exception {

//        Publisher publisher = new Publisher();
//        publisher.setName("HarperCollins");
//        publisher = publisherRepo.save(publisher);
//
//        publisher = publisherRepo.save(publisher);
//
//        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());
//
//        assertEquals(publisher1.get(), publisher);
//
//        publisherRepo.deleteById(publisher.getId());
//
//        publisher1 = publisherRepo.findById(publisher.getId());
//
//        assertFalse(book1.isPresent());
    }

    @Test
    public void shouldReadAllPublishers() throws Exception {
        // update code
    }

    @Test
    public void shouldUpdatePublisher() throws Exception {
        // update code
    }
}
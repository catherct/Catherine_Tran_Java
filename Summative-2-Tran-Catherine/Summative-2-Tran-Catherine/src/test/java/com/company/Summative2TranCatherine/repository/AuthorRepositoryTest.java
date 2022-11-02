package com.company.Summative2TranCatherine.repository;

import com.company.Summative2TranCatherine.model.Author;
import com.company.Summative2TranCatherine.model.Book;
import com.company.Summative2TranCatherine.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.*;

public class AuthorRepositoryTest {

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
    public void shouldCreateReadDeleteAuthors() throws Exception {

        Author author = new Author();
        author.setFirstName("Lemony");
        author.setLastName("Snicket");
        author.setStreet("123 Misery Lane");
        author.setCity("Topeka");
        author.setState("Kansas");
        author.setPostalCode("12345");
        author.setPhone("12345678901");
        author.setEmail("snicket@penguinbooks.com");
        author = authorRepo.save(author);

        Optional<Author> author1 = authorRepo.findById(author.getId());

        assertEquals(author1.get(), author);

        authorRepo.deleteById(author.getId());

        author1 = authorRepo.findById(author.getId());

        assertFalse(author1.isPresent());
    }

    @Test
    public void shouldReadAllAuthors() throws Exception {
        // update code
    }

    @Test
    public void shouldUpdateAuthors() throws Exception {
        // update code
    }
}
package com.company.Summative2TranCatherine.repository;

import com.company.Summative2TranCatherine.model.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith((SpringJUnit4ClassRunner.class))
@SpringBootTest
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
        author.setPhone("234-567-8901");
        author.setEmail("snicket@harpercollins.com");
        author = authorRepo.save(author);

        Optional<Author> author1 = authorRepo.findById(author.getId());

        assertEquals(author1.get(), author);

        authorRepo.deleteById(author.getId());

        author1 = authorRepo.findById(author.getId());

        assertFalse(author1.isPresent());
    }

    @Test
    public void shouldReadAllAuthors() throws Exception {

        Author author1 = new Author();
        author1.setFirstName("Lemony");
        author1.setLastName("Snicket");
        author1.setStreet("123 Misery Lane");
        author1.setCity("Topeka");
        author1.setState("Kansas");
        author1.setPostalCode("12345");
        author1.setPhone("12345678901");
        author1.setEmail("snicket@penguinbooks.com");
        author1 = authorRepo.save(author1);

        Author author2 = new Author();
        author2.setFirstName("Amy");
        author2.setLastName("Tan");
        author2.setStreet("123 Lucky Ave");
        author2.setCity("San Francisco");
        author2.setState("California");
        author2.setPostalCode("98743");
        author2.setPhone("354-875-0983");
        author2.setEmail("amytan@penguinbooks.com");
        author2 = authorRepo.save(author2);

        List<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);

        authors = authorRepo.findAll();

        assertFalse(authors.isEmpty());

    }

    @Test
    public void shouldUpdateAuthors() throws Exception {

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

        author.setStreet("234 Misery Lane");
        author = authorRepo.save(author);

        assertNotSame(author1.get(), author);

    }
}
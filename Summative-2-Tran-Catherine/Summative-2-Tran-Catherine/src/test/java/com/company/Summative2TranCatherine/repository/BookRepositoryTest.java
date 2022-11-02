package com.company.Summative2TranCatherine.repository;

import com.company.Summative2TranCatherine.model.Author;
import com.company.Summative2TranCatherine.model.Book;
import com.company.Summative2TranCatherine.model.Publisher;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

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
    public void shouldCreateReadDeleteBook() throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("HarperCollins");
        publisher = publisherRepo.save(publisher);

        Author author = new Author();
        author.setFirstName("Lemony");
        author.setLastName("Snicket");
        author = authorRepo.save(author);

        Book book = new Book();
        book.setId(book.getId());
        book.setTitle("The Penultimate Peril");
        book.setAuthorId(author.getId());
        book.setPublishDate(LocalDate.of(2005, 10, 18));
        book.setPublisherId(publisher.getId());
        book.setIsbn("98DI9834OP");
        book.setPrice(new BigDecimal(8.99));

        book = bookRepo.save(book);

        Optional<Book> book1 = bookRepo.findById(book.getId());

        assertEquals(book1.get(), book);

        bookRepo.deleteById(book.getId());

        book1 = bookRepo.findById(book.getId());

        assertFalse(book1.isPresent());
    }

    @Test
    public void shouldReadAllBooks() throws Exception {
//        Publisher publisher = new Publisher();
//        publisher.setName("Penguin Books");
//        publisher = publisherRepo.save(publisher);
//
//        Author author = new Author();
//        author.setFirstName("Lemony");
//        author.setLastName("Snicket");
//        author = authorRepo.save(author);
//
//        Book book1 = new Book();
//        book1.setId(book1.getId());
//        book1.setTitle("The Penultimate Peril");
//        book1.setAuthorId(author.getId());
//        book1.setPublishDate(LocalDate.of(2005, 10, 18));
//        book1.setPublisherId(publisher.getId());
//        book1.setIsbn("98DI9834OP");
//        book1.setPrice(new BigDecimal(8.99));
//        book1 = bookRepo.save(book1);

        // update code
    }

    @Test
    public void shouldUpdateBooks() throws Exception {
//        Publisher publisher = new Publisher();
//        publisher.setName("Penguin Books");
//        publisher = publisherRepo.save(publisher);
//
//        Author author = new Author();
//        author.setFirstName("Lemony");
//        author.setLastName("Snicket");
//        author = authorRepo.save(author);
//
//        Book book1 = new Book();
//        book1.setId(book1.getId());
//        book1.setTitle("The Penultimate Peril");
//        book1.setAuthorId(author.getId());
//        book1.setPublishDate(LocalDate.of(2005, 10, 18));
//        book1.setPublisherId(publisher.getId());
//        book1.setIsbn("98DI9834OP");
//        book1.setPrice(new BigDecimal(8.99));
//        book1 = bookRepo.save(book1);

        // update code
    }

    @Test
    public void shouldGetBooksByAuthor() throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Books");
        publisher = publisherRepo.save(publisher);

        Author author = new Author();
        author.setFirstName("Lemony");
        author.setLastName("Snicket");
        author = authorRepo.save(author);

        Book book1 = new Book();
        book1.setId(book1.getId());
        book1.setTitle("The Penultimate Peril");
        book1.setAuthorId(author.getId());
        book1.setPublishDate(LocalDate.of(2005, 10, 18));
        book1.setPublisherId(publisher.getId());
        book1.setIsbn("98DI9834OP");
        book1.setPrice(new BigDecimal(8.99));
        book1 = bookRepo.save(book1);

        Book book2 = new Book();
        book2.setId(book2.getId());
        book2.setTitle("The End");
        book2.setAuthorId(author.getId());
        book2.setPublishDate(LocalDate.of(2006, 10, 13));
        book2.setPublisherId(publisher.getId());
        book2.setIsbn("98DIGQ18Z8P");
        book2.setPrice(new BigDecimal(8.99));
        book2 = bookRepo.save(book2);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        books = bookRepo.findAllBooksByAuthor(author.getId());

        assertEquals(books.get(author.getId()), books);

    }
}
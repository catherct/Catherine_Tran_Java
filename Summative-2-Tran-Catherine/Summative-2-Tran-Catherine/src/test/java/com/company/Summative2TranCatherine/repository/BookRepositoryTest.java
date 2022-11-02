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
        publisher.setStreet("123 Harper Ave");
        publisher.setCity("Collinstopia");
        publisher.setState("New York");
        publisher.setPostalCode("98372");
        publisher.setPhone("882-315-6697");
        publisher.setEmail("welovebooks@harpercollins.com");
        publisher = publisherRepo.save(publisher);

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

        Publisher publisher1 = new Publisher();
        publisher1.setName("HarperCollins");
        publisher1.setStreet("123 Harper Ave");
        publisher1.setCity("Collinstopia");
        publisher1.setState("New York");
        publisher1.setPostalCode("98372");
        publisher1.setPhone("882-315-6697");
        publisher1.setEmail("welovebooks@harpercollins.com");
        publisher1 = publisherRepo.save(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Penguin Books");
        publisher2.setStreet("123 Penguin Ave");
        publisher2.setCity("Manhattan");
        publisher2.setState("New York");
        publisher2.setPostalCode("98372");
        publisher2.setPhone("882-316-6635");
        publisher2.setEmail("welovebooksmore@penguinbooks.com");
        publisher2 = publisherRepo.save(publisher2);

        Author author1 = new Author();
        author1.setFirstName("Lemony");
        author1.setLastName("Snicket");
        author1.setStreet("123 Misery Lane");
        author1.setCity("Topeka");
        author1.setState("Kansas");
        author1.setPostalCode("12345");
        author1.setPhone("234-567-8901");
        author1.setEmail("snicket@harpercollins.com");
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

        Book book1 = new Book();
        book1.setId(book1.getId());
        book1.setTitle("The Penultimate Peril");
        book1.setAuthorId(author1.getId());
        book1.setPublishDate(LocalDate.of(2005, 10, 18));
        book1.setPublisherId(publisher1.getId());
        book1.setIsbn("98DI9834OP");
        book1.setPrice(new BigDecimal(8.99));
        book1 = bookRepo.save(book1);

        Book book2 = new Book();
        book2.setId(book2.getId());
        book2.setTitle("The End");
        book2.setAuthorId(author1.getId());
        book2.setPublishDate(LocalDate.of(2006, 10, 13));
        book2.setPublisherId(publisher1.getId());
        book2.setIsbn("98DIGQ18Z8P");
        book2.setPrice(new BigDecimal(8.99));
        book2 = bookRepo.save(book2);

        Book book3 = new Book();
        book3.setId(book3.getId());
        book3.setTitle("Joy Luck Club");
        book3.setAuthorId(author2.getId());
        book3.setPublishDate(LocalDate.of(1989, 1, 1));
        book3.setPublisherId(publisher2.getId());
        book3.setIsbn("98GIN238Z8P");
        book3.setPrice(new BigDecimal(8.99));
        book3 = bookRepo.save(book3);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        books = bookRepo.findAll();

        assertFalse(books.isEmpty());

    }

    @Test
    public void shouldUpdateBooks() throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("HarperCollins");
        publisher.setStreet("123 Harper Ave");
        publisher.setCity("Collinstopia");
        publisher.setState("New York");
        publisher.setPostalCode("98372");
        publisher.setPhone("882-315-6697");
        publisher.setEmail("welovebooks@harpercollins.com");
        publisher = publisherRepo.save(publisher);

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

        book.setIsbn("98DI9834OL");
        book = bookRepo.save(book);

        assertNotSame(book1.get(), book);

    }

    @Test
    public void shouldGetBooksByAuthor() throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("HarperCollins");
        publisher.setStreet("123 Harper Ave");
        publisher.setCity("Collinstopia");
        publisher.setState("New York");
        publisher.setPostalCode("98372");
        publisher.setPhone("882-315-6697");
        publisher.setEmail("welovebooks@harpercollins.com");
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
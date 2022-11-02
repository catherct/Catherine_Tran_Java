package com.company.Summative2TranCatherine.repository;

import com.company.Summative2TranCatherine.model.Publisher;
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

        Publisher publisher = new Publisher();
        publisher.setName("HarperCollins");
        publisher.setStreet("123 Harper Ave");
        publisher.setCity("Collinstopia");
        publisher.setState("New York");
        publisher.setPostalCode("98372");
        publisher.setPhone("882-315-6697");
        publisher.setEmail("welovebooks@harpercollins.com");
        publisher = publisherRepo.save(publisher);

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);

        publisherRepo.deleteById(publisher.getId());

        publisher1 = publisherRepo.findById(publisher.getId());

        assertFalse(publisher1.isPresent());
    }

    @Test
    public void shouldReadAllPublishers() throws Exception {

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

        List<Publisher> publishers = new ArrayList<>();
        publishers.add(publisher1);
        publishers.add(publisher2);

        publishers = publisherRepo.findAll();

        assertFalse(publishers.isEmpty());
    }

    @Test
    public void shouldUpdatePublisher() throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("HarperCollins");
        publisher.setStreet("123 Harper Ave");
        publisher.setCity("Collinstopia");
        publisher.setState("New York");
        publisher.setPostalCode("98372");
        publisher.setPhone("882-315-6697");
        publisher.setEmail("welovebooks@harpercollins.com");

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);

        publisher.setCity("Brooklyn");
        publisher = publisherRepo.save(publisher);

        assertNotSame(publisher1.get(), publisher);
    }
}
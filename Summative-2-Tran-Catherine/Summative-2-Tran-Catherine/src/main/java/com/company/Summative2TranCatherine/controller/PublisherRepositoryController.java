package com.company.Summative2TranCatherine.controller;

import com.company.Summative2TranCatherine.model.Book;
import com.company.Summative2TranCatherine.model.Publisher;
import com.company.Summative2TranCatherine.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublisherRepositoryController {

    @Autowired
    PublisherRepository publisherRepo;

    public Publisher createPublisher(Publisher publisher) {
        publisher.setId(publisher.getId());
        publisher.setName(publisher.getName());
        publisher.setBooks(publisher.getBooks());
        publisher.setEmail(publisher.getEmail());
        publisher.setPhone(publisher.getPhone());
        publisher.setStreet(publisher.getStreet());
        publisher.setCity(publisher.getCity());
        publisher.setState(publisher.getState());
        publisher.setPostalCode(publisher.getPostalCode());
        publisherRepo.save(publisher);

        return publisher;
    }

    public Publisher getPublisher(int id) {
        List<Publisher> publishers = publisherRepo.findAll();

        Publisher foundPublisher = null;

        for (Publisher targetPublisher : publishers) {
            if (targetPublisher.getId() == id) {
                foundPublisher = targetPublisher;
            }
        }
        return foundPublisher;
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepo.findAll();
    }

    public void updatePublisher(int id, Publisher publisher) {
        List<Publisher> publishers = publisherRepo.findAll();

        for (Publisher foundPublisher : publishers) {
            if (foundPublisher.getId() == id) {
                publishers.set(foundPublisher.getId(), publisher);
            }
        }
    }

    public void deletePublisher(int id) {
        List<Publisher> publishers = publisherRepo.findAll();

        for (Publisher foundPublisher : publishers) {
            if (foundPublisher.getId() == id) {
                publisherRepo.delete(foundPublisher);
            }
        }
    }
}

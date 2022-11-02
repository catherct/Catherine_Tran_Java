package com.company.Summative2TranCatherine.controller;

import com.company.Summative2TranCatherine.model.Author;
import com.company.Summative2TranCatherine.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorRepositoryController {

    @Autowired
    AuthorRepository authorRepo;

    public Author createAuthor(Author author) {
        author.setId(author.getId());
        author.setFirstName(author.getFirstName());
        author.setLastName(author.getLastName());
        author.setBooks(author.getBooks());
        author.setStreet(author.getStreet());
        author.setCity(author.getCity());
        author.setState(author.getState());
        author.setPostalCode(author.getPostalCode());
        author.setEmail(author.getEmail());
        author.setPhone(author.getPhone());
        authorRepo.save(author);

        return author;
    }

    public Author getAuthor(int id) {
        List<Author> authors = authorRepo.findAll();

        Author foundAuthor = null;

        for (Author targetAuthor : authors) {
            if (targetAuthor.getId() == id) {
                foundAuthor = targetAuthor;
            }
        }
        return foundAuthor;
    }

    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    public void updateAuthor(int id, Author author) {
        List<Author> authors = authorRepo.findAll();

        for (Author foundAuthor : authors) {
            if (foundAuthor.getId() == id) {
                authors.set(foundAuthor.getId(), author);
            }
        }
    }

    public void deleteAuthor(int id) {
        List<Author> authors = authorRepo.findAll();

        for (Author foundAuthor : authors) {
            if (foundAuthor.getId() == id) {
                authorRepo.delete(foundAuthor);
            }
        }
    }
}

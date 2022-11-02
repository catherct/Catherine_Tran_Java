package com.company.Summative2TranCatherine.controller;

import com.company.Summative2TranCatherine.model.Book;
import com.company.Summative2TranCatherine.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRepositoryController {

    @Autowired
    BookRepository bookRepo;

    public Book createBook(Book book) {
        book.setId(book.getId());
        book.setTitle(book.getTitle());
        book.setAuthorId(book.getAuthorId());
        book.setIsbn(book.getIsbn());
        book.setPublishDate(book.getPublishDate());
        book.setPublisherId(book.getPublisherId());
        book.setPrice(book.getPrice());
        bookRepo.save(book);

        return book;
    }

    public Book getBook(int id) {

        List<Book> books = bookRepo.findAll();

        Book foundBook = null;

        for (Book targetBook : books) {
            if (targetBook.getId() == id) {
                foundBook = targetBook;
            }
        }
        return foundBook;
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public void updateBook(int id, Book book) {

        List<Book> books = bookRepo.findAll();

        for (Book foundBook : books) {
            if (foundBook.getId() == id) {
                books.set(foundBook.getId(), book);
            }
        }
    }

    public void deleteBook(int id) {

        List<Book> books = bookRepo.findAll();

        for (Book foundBook : books) {
            if (foundBook.getId() == id) {
                bookRepo.delete(foundBook);
            }
        }
    }

    public List<Book> findAllBooksByAuthor(int authorId) {

        List<Book> books = bookRepo.findAll();

        List<Book> authorBooks = null;

        for (Book targetBooks : books) {
            if (targetBooks.getAuthorId() == authorId) {
                authorBooks.add(targetBooks);
            }
        }
        return authorBooks;
    }
}

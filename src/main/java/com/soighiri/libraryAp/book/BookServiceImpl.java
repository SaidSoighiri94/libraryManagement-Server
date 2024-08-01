package com.soighiri.libraryAp.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity saveBook(BookEntity book) {
        return bookRepository.save(book);
    }

    @Override
    public BookEntity updateBook(BookEntity book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(BookEntity book) {
        bookRepository.delete(book);

    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public BookEntity getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public BookEntity getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<BookEntity> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<BookEntity> getBooksByTitleAndAuthor(String title, String author) {
        return bookRepository.findBooksByTitleAndAuthor(title, author);
    }

    @Override
    public List<BookEntity> getBooksByTitleOrAuthor(String title, String author) {
        return bookRepository.findBooksByTitleOrAuthor(title, author);
    }
}

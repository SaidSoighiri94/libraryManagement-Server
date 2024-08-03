package com.soighiri.libraryAp.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
@CrossOrigin
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping(value = "/books")
    public List<BookEntity> getBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping(value = "/{bookId}")
    public BookEntity getBook(@PathVariable (name = "bookId") Long bookId) {
        return bookService.getBookById(bookId);
    }
    @PutMapping(value = "/updateBook")
    public BookEntity updateBook(@RequestBody BookEntity book) {
        return bookService.updateBook(book);
    }
    @DeleteMapping("/delete/{bookId}")
    public void deleteBook(@PathVariable (name = "bookId") Long bookId) {
        bookService.deleteBookById(bookId);
    }
    @PostMapping(value = "/addBook")
    public BookEntity addBook(@RequestBody BookEntity book) {
        return bookService.saveBook(book);
    }

}

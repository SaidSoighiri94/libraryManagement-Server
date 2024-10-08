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

    @PutMapping(value = "/updateBook/{bookId}")
    public BookEntity updateBook(@PathVariable Long bookId,@RequestBody BookEntity bookEntity) {
        bookEntity.setBookId(bookId);
        return bookService.updateBook(bookEntity);
    }

    @DeleteMapping("/delete/{bookId}")
    public void deleteBookByid(@PathVariable (name = "bookId") Long bookId) {
        bookService.deleteBookById(bookId);
    }

    @DeleteMapping(value = "/delete")
    public void deleteBook(@RequestBody BookEntity book) {
        bookService.deleteBook(book);
    }

    @PostMapping(value = "/addBook")
    public BookEntity addBook(@RequestBody BookEntity book) {
        return bookService.saveBook(book);
    }

    @GetMapping(value = "/search/{title}")
    public BookEntity getBookByTitle(@PathVariable (name = "title") String title) {
        return bookService.getBookByTitle(title);
    }
    @GetMapping(value = "search/{isbn}")
    public List<BookEntity> getBookByIsbn(@PathVariable (name = "isbn") String isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    @GetMapping(value = "/search/{author}")
    public List<BookEntity> getBookByAuthor(@PathVariable (name = "author") String author) {
        return bookService.getBooksByAuthor(author);
    }

    @GetMapping(value = "/search/author-title")
    public List<BookEntity> getBookByAuthorAndTitle(@RequestParam (name = "title") String title,@RequestParam (name = "author") String author) {
        return bookService.getBooksByTitleAndAuthor(title, author);
    }

    @GetMapping(value = "search/title-or-author")
    public List<BookEntity> getBooksByTitlesOrAuthor(@RequestParam (name = "title") String title,@RequestParam (name = "author") String author) {
        return bookService.getBooksByTitleOrAuthor(title, author);
    }
    @GetMapping(value = "/search/{categoryName}")
    public List<BookEntity> getBooksByCategoryName(@PathVariable (name = "categoryName") String categoryName) {
        return bookService.getBookByCategoryName(categoryName);
    }

    @GetMapping(value = "/exists/{bookId}")
    public boolean existsBook(@PathVariable (name = "bookId") Long bookId) {
        return bookService.checkIfExist(bookId);
    }
}

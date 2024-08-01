package com.soighiri.libraryAp.book;

import java.util.List;

public interface BookService {
    BookEntity saveBook(BookEntity book);
    BookEntity updateBook(BookEntity book);
    void deleteBook(BookEntity book);
    void  deleteBookById(Long bookId);
    BookEntity getBookById(Long bookId);
    List<BookEntity> getAllBooks();
}

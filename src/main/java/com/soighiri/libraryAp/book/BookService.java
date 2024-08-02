package com.soighiri.libraryAp.book;

import java.util.List;

public interface BookService {
    BookEntity saveBook(BookEntity book);
    BookEntity updateBook(BookEntity book);
    void deleteBook(BookEntity book);
    void  deleteBookById(Long bookId);
    BookEntity getBookById(Long bookId);
    List<BookEntity> getAllBooks();
    BookEntity getBookByTitle(String title);
    List<BookEntity> getBookByIsbn(String isbn);
    List<BookEntity> getBooksByAuthor(String author);
    List<BookEntity> getBooksByTitleAndAuthor(String title, String author);
    List<BookEntity> getBooksByTitleOrAuthor(String title, String author);
    List<BookEntity> getBookByCategoryName(String categoryName);
    boolean checkIfExist(Long bookId);


}

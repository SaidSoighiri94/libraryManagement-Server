package com.soighiri.libraryAp.author;

import com.soighiri.libraryAp.book.BookEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<AuthorEntity> getAllAuthors();
    Optional<AuthorEntity> getAuthorById(Long authorId);
    AuthorEntity saveAuthor(AuthorEntity author);
    void deleteAuthor(Long authorId);
    List<AuthorEntity> findAuthorByBookTitle(String title);
    AuthorEntity updateAuthor(Long authorId, AuthorEntity author);
    List<AuthorEntity> findAuthorByFirstName(String authorFirstName);
    List<AuthorEntity> findAuthorByLastName(String authorLastName);
    List<BookEntity> findBooksByAuthorId(Long authorId);
}

package com.soighiri.libraryAp.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    BookEntity findByTitle(String title);
    @Query("SELECT b FROM BookEntity b WHERE b.author.authorLastName =:author")
    List<BookEntity> findByAuthor(@Param("author") String author);

    @Query("SELECT b FROM BookEntity b WHERE b.title = :title AND b.author.authorLastName = :author")
    List<BookEntity> findBooksByTitleAndAuthor(@Param("title") String title, @Param("author") String author);

    @Query("SELECT b FROM BookEntity b WHERE b.title = :title OR b.author.authorLastName = :author")
    List<BookEntity> findBooksByTitleOrAuthor(@Param("title") String title, @Param("author") String author);
}

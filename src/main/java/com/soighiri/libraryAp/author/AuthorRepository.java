package com.soighiri.libraryAp.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    @Query("SELECT a FROM AuthorEntity a JOIN a.books b WHERE b.title = :title")
    List<AuthorEntity> findAuthorsByBookTitle(@Param("title") String title);

    List<AuthorEntity> findByAuthorFirstName(String authorFirstName);
    List<AuthorEntity> findByAuthorLastName(String authorLastName);
}

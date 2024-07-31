package com.soighiri.libraryAp.athor;

import com.soighiri.libraryAp.book.BookEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorId", nullable = false,unique = true,updatable = false)
    private Long authorId;
    private String authorFirstName;
    private String authorLastName;
    private String authorEmail;
    private String authorAddress;
    private String biography;
    private String nationality;

    @OneToMany(mappedBy ="author")
    private List<BookEntity> books;


}

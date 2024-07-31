package com.soighiri.libraryAp.athor;

import com.soighiri.libraryAp.book.BookEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "AUTHOR")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", nullable = false,unique = true,updatable = false)
    private Long authorId;
    private String authorFirstName;
    private String authorLastName;
    private String authorEmail;
    private String authorAddress;
    private String biography;
    @OneToMany(mappedBy ="author")
    private List<BookEntity> books;


}

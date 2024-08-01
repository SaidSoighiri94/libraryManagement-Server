package com.soighiri.libraryAp.author;

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
    @Column(name = "author_id", nullable = false, unique = true, updatable = false)
    private Long authorId;

    @Column(name = "author_first_name", nullable = false)
    private String authorFirstName;

    @Column(name = "author_last_name", nullable = false)
    private String authorLastName;

    @Column(name = "author_email", nullable = false, unique = true)
    private String authorEmail;

    @Column(name = "author_address")
    private String authorAddress;

    @Column(name = "biography")
    private String biography;

    @OneToMany(mappedBy = "author")
    private List<BookEntity> books;
}

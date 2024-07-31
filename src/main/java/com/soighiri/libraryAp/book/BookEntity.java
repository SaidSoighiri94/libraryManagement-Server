package com.soighiri.libraryAp.book;

import com.soighiri.libraryAp.athor.AuthorEntity;
import com.soighiri.libraryAp.loan.LoanEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId", unique = true,updatable = false,nullable = false)
    private Long bookId;

    private String title;
    private String isbn;
    private Long totalExemplaries;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private AuthorEntity author;

    @OneToMany(mappedBy = "book")
    private List<LoanEntity> loanEntities;



}

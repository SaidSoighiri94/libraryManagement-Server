package com.soighiri.libraryAp.book;

import com.soighiri.libraryAp.author.AuthorEntity;
import com.soighiri.libraryAp.category.CategoryEntity;
import com.soighiri.libraryAp.loan.LoanEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "BOOK")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", unique = true,updatable = false,nullable = false)
    private Long bookId;

    private String title;
    private String isbn;
    private Long totalExemplaries;
    private LocalDate publishedDate;
    private LocalDate registerDate;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    @OneToMany(mappedBy = "book")
    private List<LoanEntity> loanEntities;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private CategoryEntity category;



}

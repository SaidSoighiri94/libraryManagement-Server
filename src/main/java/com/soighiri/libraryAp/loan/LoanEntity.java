package com.soighiri.libraryAp.loan;

import com.soighiri.libraryAp.book.BookEntity;
import com.soighiri.libraryAp.customer.CustomerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "LOAN")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanEntity {

    @EmbeddedId
    private LoanId pk = new LoanId();

    @Column(name = "begin_date", nullable = false)
    private LocalDate beginDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private LoanStatus status;

    @ManyToOne
    @MapsId("book")
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @ManyToOne
    @MapsId("customer")
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}

package com.soighiri.libraryAp.loan;

import com.soighiri.libraryAp.book.BookEntity;
import com.soighiri.libraryAp.customer.CustomerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLoan;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private CustomerEntity customer;

    @Temporal(TemporalType.DATE)
    private Date beginDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;
    private String status;
}

package com.soighiri.libraryAp.loan;

import com.soighiri.libraryAp.book.BookEntity;
import com.soighiri.libraryAp.customer.CustomerEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data


public class LoanId implements Serializable {
    private static final long serialVersionUID = 3912193101593832821L;
    @ManyToOne
    @JoinColumn(name = "bookId", nullable = false)
    private BookEntity bookEntity;
    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private CustomerEntity customerEntity;

    @Column(name = "creationDateTime",nullable = false)
    private LocalDateTime creationDateTime;

}

package com.soighiri.libraryAp.loan;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
@Embeddable
@Data
public class LoanId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long bookId;
    private Long customerId;

}

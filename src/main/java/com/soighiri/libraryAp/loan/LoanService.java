package com.soighiri.libraryAp.loan;

import java.time.LocalDate;
import java.util.List;

public interface LoanService {
    List<LoanEntity> findByDateBefore(LocalDate date);
    List<LoanEntity> findByDateAfter(LocalDate date);
    List<LoanEntity> getAllOpenLoansOfThisCustomer(String email, LoanStatus status);
    LoanEntity getLoanByCriteria(Long bookId, Long customerId,LoanStatus status);
}

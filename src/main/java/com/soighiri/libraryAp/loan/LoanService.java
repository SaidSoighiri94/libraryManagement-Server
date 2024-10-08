package com.soighiri.libraryAp.loan;

import java.time.LocalDate;
import java.util.List;

public interface LoanService {
    List<LoanEntity> findByDateBefore(LocalDate maxEndDate);
    List<LoanEntity> findByDateAfter(LocalDate minEndDate);
    List<LoanEntity> getAllOpenLoansOfThisCustomer(String email, LoanStatus status);
    LoanEntity getLoanByCriteria(Long bookId, Long customerId,LoanStatus status);

    LoanEntity getOpenedLoan(Long customerId, Long loanId);
    LoanEntity closedLoan(LoanEntity loan);
    LoanEntity saveLoan(LoanEntity loan);
    boolean checkIfLoanExists(Long bookId, Long customerId);}

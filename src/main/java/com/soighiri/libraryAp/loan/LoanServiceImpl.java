package com.soighiri.libraryAp.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;
    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    @Override
    public List<LoanEntity> findByDateBefore(LocalDate maxEndDate) {
        return loanRepository.findByEndDateBefore(maxEndDate);
    }

    @Override
    public List<LoanEntity> findByDateAfter(LocalDate minEndDate) {
        return loanRepository.findByEndDateAfter(minEndDate);
    }

    @Override
    public List<LoanEntity> getAllOpenLoansOfThisCustomer(String email, LoanStatus status) {
        return loanRepository.getAllOpenLoansOfThisCustomer(email, status);
    }

    @Override
    public LoanEntity getLoanByCriteria(Long bookId, Long customerId, LoanStatus status) {
        return loanRepository.getLoanByCriteria(bookId, customerId, status);
    }

    @Override
    public LoanEntity getOpenedLoan(Long customerId, Long loanId) {
        return loanRepository.getLoanByCriteria(Long.valueOf(customerId), Long.valueOf(loanId), LoanStatus.OPENED);
    }

    @Override
    public LoanEntity closedLoan(LoanEntity loan) {
        loan.setStatus(LoanStatus.CLOSED);
        return loanRepository.save(loan);
    }

    @Override
    public LoanEntity saveLoan(LoanEntity loan) {
        return loanRepository.save(loan);
    }

    @Override
    public boolean checkIfLoanExists(Long bookId, Long customerId) {
        LoanEntity loan = loanRepository.getLoanByCriteria(bookId, customerId, LoanStatus.OPENED);
        return loan != null;
    }
}

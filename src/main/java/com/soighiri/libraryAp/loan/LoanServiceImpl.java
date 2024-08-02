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
}

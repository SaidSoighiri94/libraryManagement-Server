package com.soighiri.libraryAp.loan;

import com.soighiri.libraryAp.author.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRepository extends JpaRepository<LoanEntity, Long> {


}

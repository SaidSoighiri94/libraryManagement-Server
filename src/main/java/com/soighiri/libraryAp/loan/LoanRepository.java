package com.soighiri.libraryAp.loan;

import com.soighiri.libraryAp.author.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository extends JpaRepository<LoanEntity, Long> {

    // Recherche de tous les prêts dont la date de fin est antérieure à une date donnée.
    List<LoanEntity> findByEndDateBefore(LocalDate maxEndDate);

    // Recherche de tous les prêts dont la date de fin est postérieure à une date donnée.
    List<LoanEntity> findByEndDateAfter(LocalDate minEnDate);

    // Recherche de tous les prêts ouverts (statut spécifié) d'un client avec un email donné (insensible à la casse).
    @Query("SELECT loan FROM LoanEntity loan JOIN loan.pk.customer customer WHERE UPPER(customer.email) = UPPER(?1) AND loan.status =?2 ")
    List<LoanEntity> getAllOpenLoansOfThisCustomer(String email, LoanStatus status);

    // Recherche d'un prêt spécifique en fonction de l'ID du livre, de l'ID du client et du statut du prêt.
    @Query("SELECT loan FROM LoanEntity  loan JOIN loan.pk.book book JOIN loan.pk.customer customer WHERE book.bookId = ?1 AND customer.customerId =?2 AND loan.status = ?3")
    LoanEntity getLoanByCriteria(Long bookId, Long customerId, LoanStatus status);

}

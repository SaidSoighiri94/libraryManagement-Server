package com.soighiri.libraryAp.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByEmail(String email);
}

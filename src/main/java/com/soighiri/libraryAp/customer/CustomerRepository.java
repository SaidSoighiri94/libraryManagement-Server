package com.soighiri.libraryAp.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByEmail(String email);
    List<CustomerEntity> findByLastName(String lastName);

}

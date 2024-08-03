package com.soighiri.libraryAp.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByEmail(String email);
    List<CustomerEntity> findByLastName(String lastName);

    @Query("SELECT  customer FROM  CustomerEntity customer WHERE customer.firstName LIKE %:keyword% OR customer.lastName LIKE " +
            "%:keyword%")
    List<CustomerEntity> findCustomerByKeyword(@Param("keyword") String keyword);

}

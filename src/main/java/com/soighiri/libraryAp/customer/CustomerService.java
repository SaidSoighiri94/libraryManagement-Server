package com.soighiri.libraryAp.customer;

import java.util.List;

public interface CustomerService {
    CustomerEntity saveCustomer(CustomerEntity customer);
    CustomerEntity getCustomerById(Long customerId);
    CustomerEntity getCustomerByEmail(String email);
    CustomerEntity updateCustomer(CustomerEntity customer);
    void deleteCustomerById(Long customerId);
    void deleteCustomer(CustomerEntity customer);
    List<CustomerEntity> getAllCustomers();
    List<CustomerEntity> findCustomersByKeyword(String keyword);

}

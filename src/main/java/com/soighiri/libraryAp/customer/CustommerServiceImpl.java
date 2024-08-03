package com.soighiri.libraryAp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustommerServiceImpl implements CustomerService {
    private  final CustomerRepository customerRepository;
    @Autowired
    public CustommerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public CustomerEntity saveCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public CustomerEntity getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public CustomerEntity getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public CustomerEntity updateCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public void deleteCustomer(CustomerEntity customer) {
        customerRepository.delete(customer);
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<CustomerEntity> findCustomersByKeyword(String keyword) {
        return customerRepository.findCustomerByKeyword(keyword);
    }
}

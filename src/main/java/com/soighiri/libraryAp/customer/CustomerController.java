package com.soighiri.libraryAp.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping(value = "/customers")
    public List<CustomerEntity> findAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/{customerId}")
    public CustomerEntity getCustomer(@PathVariable Long customerId){
        return customerService.getCustomerById(customerId);
    }
    @DeleteMapping(value = "/delete/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId){
        customerService.deleteCustomerById(customerId);
    }

}

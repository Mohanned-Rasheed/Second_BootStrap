package com.example.demo.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;
    //@Qualifier("fake")
    public CustomerService( CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomers(){
        return customerRepo.getCustomer();
    }

    Customer getCustomer(Long id){
        return customerRepo.getCustomer()
                .stream()
                .filter(customer -> customer.getId().equals( id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("customer not found"));
    }
}

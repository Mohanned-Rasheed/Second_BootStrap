package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    //@Qualifier("fake")
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepository = customerRepo;
    }

    List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("customer with id:" + id + " not found"));

    }
}

package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    //@Qualifier("fake")
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepository = customerRepo;
    }

    List<Customer> getCustomers() {
        LOGGER.info("getCustomers Was Called!");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id) {
        LOGGER.info("getCustomer Was Called!");
        return customerRepository.findById(id).orElseThrow(() -> {
            NotFoundException notFoundException = new NotFoundException("customer with id:" + id + " not found");
            LOGGER.error("error in getCustomer {}", id, notFoundException);
            return notFoundException;
        });

    }
}

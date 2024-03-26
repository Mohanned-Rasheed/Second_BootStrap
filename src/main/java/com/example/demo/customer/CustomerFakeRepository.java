package com.example.demo.customer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "fake")
public class CustomerFakeRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomer() {
        return Arrays.asList(
                new Customer(1L,"James Bond","password1"),
                new Customer(2L,"Jamaila Ahmed","password2"));
    }
}

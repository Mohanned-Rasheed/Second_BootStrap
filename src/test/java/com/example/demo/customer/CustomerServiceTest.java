package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {
    @Autowired
    private CustomerRepository CustomerRepository;

    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(CustomerRepository);
    }

    @AfterEach
    void tearDown() {
        CustomerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        //given
        Customer Mohanned = new Customer(1l, "Mohanned", "123456", "mohanned3211@gmail.com");
        Customer Mohanned2 = new Customer(2l, "Mohanned", "123456", "mohanned3211@gmail.com");
        CustomerRepository.saveAll(Arrays.asList(Mohanned, Mohanned2));
        //when
        List<Customer> customers = underTest.getCustomers();
        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        //gien
        Customer Mohanned = new Customer(1l, "Mohanned", "123456", "mohanned3211@gmail.com");
        CustomerRepository.save(Mohanned);
        //when
        Customer actual = underTest.getCustomer(1l);
        assertEquals(1l, actual.getId());
        assertEquals("Mohanned", actual.getName());

    }
}
package com.hkdev.backend.service;

import com.hkdev.backend.persistence.domain.Customer;
import com.hkdev.backend.persistence.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MessageSenderService messageSenderService;

    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer getCustomer(long id) {
        return customerRepository.findOne(id);
    }

    public Customer register(Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findByEmail(customer.getEmail());

        if(existingCustomer.isPresent()) {
            throw new RuntimeException("Customer already exists.");
        } else {
            customerRepository.save(customer);
            messageSenderService.send(customer.getEmail());
        }

        return customer;
    }
}

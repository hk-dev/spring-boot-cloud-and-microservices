package com.hkdev.web;

import com.hkdev.backend.persistence.domain.Customer;
import com.hkdev.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable long id) {
        return customerService.getCustomer(id);
    }

    @RequestMapping(value = "/customer/register", method = RequestMethod.POST)
    public Customer register(@RequestBody Customer customer) {
        return customerService.register(customer);
    }
}

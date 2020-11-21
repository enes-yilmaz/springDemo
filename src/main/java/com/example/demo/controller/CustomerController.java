package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerEntity;
import com.example.demo.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerEntity getCustomer(@PathVariable("customerId") Long customerId) {
        return customerService.getCustomer(customerId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerEntity getCustomer(@RequestParam(name = "name") String name,
                                @RequestParam(name = "surname", required = false) String surname) {
        return customerService.getCustomerByQuery(name, surname);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteCustomer(@PathVariable String customerId) {

    }
}

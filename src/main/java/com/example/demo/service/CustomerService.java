package com.example.demo.service;

import com.example.demo.converter.CustomerToCustomerEntityConverter;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerEntity;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.validator.CustomerRequestValidator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerRequestValidator customerRequestValidator;
    private CustomerToCustomerEntityConverter customerToCustomerEntityConverter;

    public CustomerService(CustomerRepository customerRepository,
                           CustomerRequestValidator customerRequestValidator,
                           CustomerToCustomerEntityConverter customerToCustomerEntityConverter) {
        this.customerRepository = customerRepository;
        this.customerRequestValidator = customerRequestValidator;
        this.customerToCustomerEntityConverter = customerToCustomerEntityConverter;
    }

    public CustomerEntity getCustomer(Long customerId) {
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(customerId);
        return optionalCustomerEntity.orElseThrow(NotFoundException::new);
    }

    public void saveCustomer(Customer customer) {
        customerRequestValidator.validateCustomer(customer);
        CustomerEntity customerEntity = customerToCustomerEntityConverter.convert(customer);
        CustomerEntity savedEntity = customerRepository.save(customerEntity);
        System.out.println(savedEntity.getId());
    }

    public CustomerEntity getCustomerByQuery(String name, String surname) {
        Optional<CustomerEntity> customerEntity = customerRepository.findByNameAndSurname(name, surname);
        return customerEntity.orElseThrow(NotFoundException::new);
    }
}
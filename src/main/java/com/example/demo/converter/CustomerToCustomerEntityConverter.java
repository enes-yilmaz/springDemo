package com.example.demo.converter;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerEntityConverter {

    public CustomerEntity convert(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customer.getName());
        customerEntity.setSurname(customer.getSurname());
        customerEntity.setTelephoneNumber(customer.getTelephoneNumber());
        return customerEntity;
    }
}

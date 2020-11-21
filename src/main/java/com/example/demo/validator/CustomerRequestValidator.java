package com.example.demo.validator;

import com.example.demo.exception.RequestValidationException;
import com.example.demo.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerRequestValidator {

    public void validateCustomer(Customer customer) {
        if (customer.getName() == null || customer.getName().isEmpty()) {
            throw new RequestValidationException("Name cannot be blank");
        }
        if (customer.getSurname() == null || customer.getSurname().isEmpty()) {
            throw new RequestValidationException("Surname cannot be blank");
        }
        if (customer.getTelephoneNumber() == null || customer.getTelephoneNumber().isEmpty()) {
            throw new RequestValidationException("PhoneNumber cannot be blank");
        }
    }
}

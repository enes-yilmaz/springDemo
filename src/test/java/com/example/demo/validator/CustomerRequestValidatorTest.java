package com.example.demo.validator;

import com.example.demo.exception.RequestValidationException;
import com.example.demo.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CustomerRequestValidatorTest {

    private CustomerRequestValidator customerRequestValidator;

    @BeforeEach
    void setUp() {
        customerRequestValidator = new CustomerRequestValidator();
    }

    @Test
    void should_throw_exception_when_name_is_blank() {
        //given
        Customer customer = new Customer();
        customer.setSurname("surname");
        customer.setTelephoneNumber("12312312");

        //when
        Throwable throwable = catchThrowable(() -> customerRequestValidator.validateCustomer(customer));

        //then
        assertThat(throwable).isNotNull().isInstanceOf(RequestValidationException.class).hasMessage("Name cannot be blank");
    }
}
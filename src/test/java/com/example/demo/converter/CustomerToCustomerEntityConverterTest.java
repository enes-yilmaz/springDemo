package com.example.demo.converter;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerToCustomerEntityConverterTest {

    private CustomerToCustomerEntityConverter customerToCustomerEntityConverter;

    @BeforeEach
    void setUp() {
        customerToCustomerEntityConverter = new CustomerToCustomerEntityConverter();
    }

    @Test
    void should_convert() {
        //given
        Customer customer = new Customer();
        customer.setName("name");
        customer.setSurname("soyadu");
        customer.setTelephoneNumber("1231231231");

        //when
        CustomerEntity customerEntity = customerToCustomerEntityConverter.convert(customer);

        //then
        assertThat(customerEntity).isNotNull();
        assertThat(customerEntity.getName()).isEqualTo("name");
        assertThat(customerEntity.getSurname()).isEqualTo("soyadu");
        assertThat(customerEntity.getTelephoneNumber()).isEqualTo("1231231231");
        assertThat(customerEntity.getId()).isNull();
    }
}
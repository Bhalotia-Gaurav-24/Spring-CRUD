package com.example.springdemo02.springdemo02;

import com.example.springdemo02.springdemo02.dao.CustomerDAO;
import com.example.springdemo02.springdemo02.model.Customer;
import com.example.springdemo02.springdemo02.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTestUsingMockito {

    @InjectMocks
    CustomerService service;

    @Mock
    CustomerDAO customerDAO;


    @BeforeEach
    void init(){
        Mockito
                .when(customerDAO.getCustomers())
                .thenReturn(Arrays.asList
                        (new Customer(101, "IBM", "Mumbai"),
                        new Customer(101, "wipro", "Bangalore")));

    }
    @Test
    public void when_get_customer_then_return_customer_list() {
        List<Customer> customers = service.getCustomers();
        Assert.isTrue(customers.size()> 0, "Customer must be greater than zero");
        Assert.isTrue(customers.get(0).getName().equals("IBM"), "The name expected is IBM");
    }

}

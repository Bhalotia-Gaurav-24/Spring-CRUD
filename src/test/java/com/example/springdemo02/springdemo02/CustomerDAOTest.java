package com.example.springdemo02.springdemo02;


import com.example.springdemo02.springdemo02.dao.CustomerDAO;
import com.example.springdemo02.springdemo02.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;


/**
 * @springBootTest tells Spring Boot to look for the main config. class (one with @SpringBootApplication, for instance)
 * and use that to start a spring application context .
 */

@SpringBootTest
public class CustomerDAOTest {

    @Autowired
    CustomerDAO customerDAO;


        @Test
        public void when_get_customer_then_get_list_customer(){
           List<Customer> customer = customerDAO.getCustomers();
            Assert.isTrue((customer.size()> 0),"Expected more than zero objects");
        }


//    @Test
//    public void when_get_customer_then_get_list(){
//        int x=5;
//        int y=10;
//        Assert.isTrue((y>x),"y is supposed to be greater than x");
//    }


//
    @Test
    public void when_get_customer_then_not_null_customer(){
            int id=101;
            Customer customer = customerDAO.getCustomer(id);
           //Assert.isNull(customer != null);
        Assert.isTrue((customer.getId()==id),"matched");
    }
}

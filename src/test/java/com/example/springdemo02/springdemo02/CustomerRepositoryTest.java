package com.example.springdemo02.springdemo02;


import com.example.springdemo02.springdemo02.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerDAO customerDAO;

}

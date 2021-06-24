package com.example.springdemo02.springdemo02.dao;


import com.example.springdemo02.springdemo02.model.Customer;
import com.example.springdemo02.springdemo02.model.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


/**
 * a) JDBC
 * b) Spring Data JDBC (early days : Spring (JDBC) + Hibernate | Spring started support Hibernate)
 * c) Spring Data JPA (Java Persistence API)
 * d) Spring Data JPA Implementation is provided by Hibernate
 */
@Component
public class CustomerDAO {


    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getCustomers() {

        return customerRepository.findAll();


    }


    @Transactional
    public Customer getCustomer(int id) {

        Optional<Customer> optCustomer = customerRepository.findById(id);

        if (optCustomer.isPresent()) {
//            System.out.println("before get....");
            Customer customer = optCustomer.get();
            System.out.println(customer.getId());

//            System.out.println(customer.hashCode());
//            Optional<Customer> optCustomer2 = customerRepository.findById(id);
//            System.out.println(optCustomer2.get().hashCode());


            return customer;

        } else {
            return null;
        }
    }

    @Transactional
    public Customer updateName(int id, String newName) {

        Optional<Customer> optCustomer = customerRepository.findById(id);

        if (optCustomer.isPresent()) {
            Customer customer = optCustomer.get();

            customer.setName(newName);

            System.out.println(" ---- After setName ----");

//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            return customer;

        } else {
            throw new RuntimeException("Customer with Id : " + id + " is not found");
        }
    }


    @Transactional
    public Customer updateAddress(int id, String newAddress) {

        Optional<Customer> optCustomer = customerRepository.findById(id);

        if (optCustomer.isPresent()) {
            Customer customer = optCustomer.get();

            customer.setName(newAddress);

            System.out.println(" ---- After setName ----");

//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            return customer;

        } else {
            throw new RuntimeException("Customer with Id : " + id + " is not found");
        }
    }




    @Transactional
    public Customer createCustomer(int id, String name, String address) {

        Customer customer = new Customer(id, name, address);

        customerRepository.save(customer);
        System.out.println(".save is called");

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return customer;

    }


}

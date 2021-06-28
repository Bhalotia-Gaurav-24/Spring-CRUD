package com.example.springdemo02.springdemo02.dao;


import com.example.springdemo02.springdemo02.model.Customer;
import com.example.springdemo02.springdemo02.model.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    //public String em;


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    EntityManager em;

    public List<Customer> getCustomers() {

        return customerRepository.findAll();


    }


    @Transactional
    public Optional<Customer> getCustomer(int id) {

        Optional<Customer> optCustomer = customerRepository.findById(id);
        return  optCustomer;
//
//        if (optCustomer.isPresent()) {
////            System.out.println("before get....");
//            Customer customer = optCustomer.get();
//            System.out.println(customer.getId());
////            System.out.println(customer.hashCode());
////            Optional<Customer> optCustomer2 = customerRepository.findById(id);
////            System.out.println(optCustomer2.get().hashCode());
//            return customer;
//
//        } else {
//            return null;
//        }
    }

    @Transactional
    public Customer updateName(int id, String newName) {

        Optional<Customer> optCustomer = customerRepository.findById(id);

        if (optCustomer.isPresent()) {
            Customer customer = optCustomer.get();

            customer.setName(newName);

            System.out.println(" ---- After setName ----");


            return customer;

        } else {
            throw new RuntimeException("Customer with Id : " + id + " is not found");
        }
    }

    public void getCustomerByComplexCondition(){
        String sql= "Select id, name from customer";
        Query q= (Query) em.createNativeQuery(sql);

        List<Object[]> result = q.getResultList();
        for (Object[] data: result) {
            Integer id= (Integer) data[0];
            String name= (String) data[1];
            System.out.println(id + " -- " + name);

        }
    }
    public void getCustomerByComplexConditionUsingJpaQL(String name) {
        String sql = "";
        Query q = em.createQuery("from Customer c where c.name= :name", Customer.class);
        q.setParameter("name", name);
        List<Customer> customers = q.getResultList();

        customers.forEach(System.out::println);




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


        return customer;

    }

    public List<Customer> getCustomersByAddress(String address) {

        return customerRepository.findByAddress(address);
    }


    public List<Customer> getCustomersByName(String name) {

        return customerRepository.findByNameStartingWith(name);
    }
}

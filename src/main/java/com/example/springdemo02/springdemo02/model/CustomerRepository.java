package com.example.springdemo02.springdemo02.model;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public List<Customer> findByAddress(String address);

    public List<Customer> findByName(String name);

    public List<Customer> findByNameStartingWith(String name);





}

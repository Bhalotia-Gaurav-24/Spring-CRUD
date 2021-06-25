package com.example.springdemo02.springdemo02.restcontrollers;


import com.example.springdemo02.springdemo02.model.Customer;
import com.example.springdemo02.springdemo02.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(path = "/customers", method = {RequestMethod.GET})
    public List<Customer> handleGetCustomers(){
        return customerService.getCustomers();
    }


    @RequestMapping(path = "/customers/{id}", method = {RequestMethod.GET})
    public Customer getCustomer(@PathVariable Integer id ){
        return customerService.getCustomer(id);
    }


//    @GetMapping Or @RequestMapping(+method=  needs to be used)
    @RequestMapping(path = "/customers", method = {RequestMethod.GET}, params = {"address"})
    public List<Customer> getCustomerByAddress(@RequestParam  String address){

        return Collections.emptyList();
    }

    @PostMapping(path = "/customers")
    public Customer addCustomer(@RequestBody Customer customer ){
        System.out.println(customer.getId() + " -- " + customer.getName() + " -- " + customer.getAddress());
        return null;
    }

    @PutMapping(path = "/customers")
    public Customer modifyCustomer(@RequestBody Customer customer ){
        return null;
    }

    @DeleteMapping(path = "/customers/{id}")
    public Customer deleteCustomer(@PathVariable Integer id ){
        return null;
    }

}

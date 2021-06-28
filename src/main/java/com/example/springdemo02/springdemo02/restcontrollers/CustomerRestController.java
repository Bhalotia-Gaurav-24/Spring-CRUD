package com.example.springdemo02.springdemo02.restcontrollers;


import com.example.springdemo02.springdemo02.model.Customer;
import com.example.springdemo02.springdemo02.model.CustomerVO;
import com.example.springdemo02.springdemo02.services.CustomerNotFoundException;
import com.example.springdemo02.springdemo02.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id ){
        try {
            Customer customer = customerService.getCustomer(id);

            return new ResponseEntity<Customer>(customer,HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        // return customerService.getCustomer(id);
    }


//    @GetMapping Or @RequestMapping(+method=  needs to be used)
    @RequestMapping(path = "/customers-by-address", method = {RequestMethod.GET}, params = {"address"})
    public ResponseEntity<List<Customer>> getCustomerByAddress(@RequestParam String address){

        List<Customer> customers = customerService.getCustomersByAddress(address);
        return new ResponseEntity<>(customers, HttpStatus.OK);
       // return Collections.emptyList();
    }

    @PostMapping(path = "/customers")
    public Customer addCustomer(@RequestBody CustomerVO customerVO ){
        System.out.println(customerVO.getId() + " -- " + customerVO.getName() + " -- " + customerVO.getAddress());
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

    @GetMapping(path = "/customers-by-name", params = {"name"})
    public ResponseEntity<List<Customer>> getCustomerByName(@RequestParam String name){

        List<Customer> customers = customerService.getCustomersByName(name);
        return new ResponseEntity<>(customers, HttpStatus.OK);
        // return Collections.emptyList();
    }

}

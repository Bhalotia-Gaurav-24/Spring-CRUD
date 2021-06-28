package com.example.springdemo02.springdemo02.services;



import com.example.springdemo02.springdemo02.dao.CustomerDAO;
import com.example.springdemo02.springdemo02.model.Customer;
import com.example.springdemo02.springdemo02.model.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Business Logic to be implemented here for all business methods
 * with respect Customer
 */
@Service
public class CustomerService {


    @Autowired
    CustomerDAO customerDAO;


    public List<Customer> getCustomers() {

        return customerDAO.getCustomers();

    }

    public Customer getCustomer(int id) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerDAO.getCustomer(id);

        if(customerOptional.isPresent()){
            return customerOptional.get();

        }
        else{
            throw new CustomerNotFoundException("customer with id "+ id + "not found!");
        }
       // return  customerDAO.getCustomer(id);
    }

    public Customer updateCustomerName(int id, String name) {
        return customerDAO.updateName(id,name);

    }

    public Customer updateCustomerAddress(int id, String address) {
     return customerDAO.updateAddress(id,address);
    }

    public List<Customer> getCustomersByAddress(String address)
    {
        return customerDAO.getCustomersByAddress(address);
    }
    //////////////////////////////
    public Customer createCustomer(CustomerVO customerVO)
    {
        Customer customer  = customerDAO.createCustomer(customerVO.getId(), customerVO.getName(), customerVO.getAddress());

        return customer;
    }

    public List<Customer> getCustomersByName(String name) {

        return customerDAO.getCustomersByName(name);
    }
}
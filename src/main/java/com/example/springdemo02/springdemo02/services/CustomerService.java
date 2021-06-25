package com.example.springdemo02.springdemo02.services;



import com.example.springdemo02.springdemo02.dao.CustomerDAO;
import com.example.springdemo02.springdemo02.model.Customer;
import com.example.springdemo02.springdemo02.model.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Customer getCustomer(int id){
        return  customerDAO.getCustomer(id);
    }

    public Customer updateCustomerName(int id, String name) {
        return customerDAO.updateName(id,name);

    }

    public Customer updateCustomerAddress(int id, String address) {
     return customerDAO.updateAddress(id,address);
    }
    //////////////////////////////
    public Customer createCustomer(CustomerVO customerVO)
    {
        Customer customer  = customerDAO.createCustomer(customerVO.getId(), customerVO.getName(), customerVO.getAddress());

        return customer;
    }
}
package com.example.springdemo02.springdemo02.controllers;

import com.example.springdemo02.springdemo02.model.Customer;
import com.example.springdemo02.springdemo02.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



/**
 * Request Processing Logic
 */
@Controller
public class CustomerController {


    @Autowired
    CustomerService customerService;

    private static final Logger _log = LoggerFactory.getLogger("CustomerController");


    @RequestMapping(path = "/home", method = {RequestMethod.GET})
    public void handleHome(HttpServletRequest request, HttpServletResponse response) throws IOException {


        List<Customer> customers = customerService.getCustomers();
        customers.forEach(System.out::println);

        _log.info("handleHome is executed....");


        response.getWriter().write("<h1>Customer Gaurav</h1>");

    }

    /**
     * Create a RequestMapping for retrieving one single Customer
     * and write the response back printing just the name of the
     * Customer object. The id based on which the customer object
     * is supposed to be retrieved comes as parameter to this mapping
     *
     */


    @RequestMapping(path = "/customer", method = {RequestMethod.GET})
    public void handleGetCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {


        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.getCustomer(id);


        response.getWriter().write("<h1>" + customer.getName() +   customer.getAddress()+  "</h1>");

    }

    /**
     * Create a RequestMapping for path = "/update-name
     */


    @RequestMapping(path = "/update-name", method = {RequestMethod.GET})
    public void SetCustomerName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id= request.getParameter("id");
        int customerid = Integer.parseInt(id);
        String name= request.getParameter("new-name");
        Customer customer = customerService.updateCustomerName(customerid,name);

        response.getWriter().write("<h1>The new name is " + customer.getName() +  "</h1>");

    }


    @RequestMapping(path = "/update-address", method = {RequestMethod.GET})
    public void SetCustomerAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id= request.getParameter("id");
        int c_id = Integer.parseInt(id);
        String address= request.getParameter("new-address");
        Customer customer = customerService.updateCustomerAddress(c_id, address);

        response.getWriter().write("<h1>The new address is " + customer.getAddress() +  "</h1>");

    }


}


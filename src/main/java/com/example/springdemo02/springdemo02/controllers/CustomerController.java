package com.example.springdemo02.springdemo02.controllers;

import com.example.springdemo02.springdemo02.model.Customer;
import com.example.springdemo02.springdemo02.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Request Processing Logic
 */
//@Controller
public class CustomerController {


    @Autowired
    CustomerService customerService;

    private static final Logger _log = LoggerFactory.getLogger("CustomerController");


    @GetMapping(path = "/home")
    public void handleHome(HttpServletRequest request, HttpServletResponse response) throws IOException {


        List<Customer> customers = customerService.getCustomers();
        customers.forEach(System.out::println);

        _log.info("handleHome is executed....");


        response.getWriter().write("<h1>Customer Listing</h1>");

    }

    /**
     * Create a RequestMapping for retrieving one single Customer
     * and write the response back printing just the name of the
     * Customer object. The id based on which the customer object
     * is supposed to be retrieved comes as parameter to this mapping
     */

    @GetMapping(path = "/customer")
    public void handleGetCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        Customer customer = customerService.getCustomer(Integer.parseInt(id));
        response.getWriter().write("<h1>" + customer.getName() + "</h1>");

    }


    /**
     * Create a RequestMapping for path = "/update-names
     * The request sent from the browser would look like : /update-name?id=101&new-name=PWC+INDIA
     * Implement the mapping in such a way that the name changes to whatever is passed in new-name parameter
     * for the customer whose id is whatever the value of id parameter is !
     *
     * to summarize as per the example : the name of customer with id =101 will change to PWC INDIA
     *
     */

    @GetMapping (path ="/update-name")
    public void handleUpdateName(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        String newName = request.getParameter("new-name");

        Customer customer = customerService.updateCustomerName(Integer.parseInt(id), newName);

        response.getWriter().write("<h1>The new name is : " + customer.getName() + "</h1>");



    }

    /**
     *
     * Implement new method in this controller /update-address?id=101&new-address=Mumbai
     * Hints a) Add a new method to CustomerDAO b) add a new method to CustomerService and call the CustomerDAO method
     * c) Call the service method from this new controller method
     *
     * Controller >> Service >> DAO
     *
     */



}

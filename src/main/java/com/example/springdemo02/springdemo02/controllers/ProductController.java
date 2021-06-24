package com.example.springdemo02.springdemo02.controllers;


import com.example.springdemo02.springdemo02.model.Product;
import com.example.springdemo02.springdemo02.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping(path ="/products")

    public void handleGetProducts(HttpServletRequest request, HttpServletResponse response) {

        List<Product> products = productService.getProducts();

        products.forEach(System.out::println);

    }
}

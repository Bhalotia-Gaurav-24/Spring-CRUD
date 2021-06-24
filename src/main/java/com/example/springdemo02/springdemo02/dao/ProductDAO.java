package com.example.springdemo02.springdemo02.dao;


import com.example.springdemo02.springdemo02.model.Product;
import com.example.springdemo02.springdemo02.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductDAO {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts() {

        return productRepository.findAll();
    }
}

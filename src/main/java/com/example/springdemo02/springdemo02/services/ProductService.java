package com.example.springdemo02.springdemo02.services;


import com.example.springdemo02.springdemo02.dao.ProductDAO;
import com.example.springdemo02.springdemo02.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public List<Product> getProducts() {
        return productDAO.getProducts();
    }

}

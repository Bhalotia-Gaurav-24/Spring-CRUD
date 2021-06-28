package com.example.springdemo02.springdemo02.services;

public class CustomerNotFoundException extends Exception{

    public CustomerNotFoundException(){

    }
    public CustomerNotFoundException(String msg){
        super(msg);
    }
}

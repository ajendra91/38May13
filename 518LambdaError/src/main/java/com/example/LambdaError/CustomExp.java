package com.example.LambdaError;

public class CustomExp extends Exception {

    CustomExp(Long id){
        super("id not found"+id);
    }
}

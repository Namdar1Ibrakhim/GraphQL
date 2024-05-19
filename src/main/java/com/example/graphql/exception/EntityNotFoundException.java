package com.example.graphql.exception;


public class EntityNotFoundException extends Exception{

    public EntityNotFoundException(String message){
        super(message);
    }
}

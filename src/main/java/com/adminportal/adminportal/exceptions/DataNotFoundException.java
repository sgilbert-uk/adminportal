package com.adminportal.adminportal.exceptions;

public class DataNotFoundException extends Exception{
    public DataNotFoundException(String errorMsg){
        super(errorMsg);
    }
}

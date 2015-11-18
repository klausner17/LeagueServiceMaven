/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klausner.exceptions;

/**
 *
 * @author DesenSoftware
 */
public class FailureLoginException extends Exception {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public FailureLoginException(){
        message = "";
    }
    
    public FailureLoginException(String message){
        this.message = message;
    }
    
}

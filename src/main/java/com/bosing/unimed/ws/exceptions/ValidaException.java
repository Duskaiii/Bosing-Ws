/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws.exceptions;

import jakarta.xml.ws.WebFault;

/**
 *
 * @author Dzkyy
 */
@WebFault
public class ValidaException extends Exception{
    public ValidaException(String message){
        super(message);
    }
}

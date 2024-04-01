/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bosing.unimed.ws.interfaces;

import com.bosing.unimed.ws.exceptions.ValidaException;
import com.bosing.unimed.ws.model.Endereco;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;

/**
 *
 * @author muril
 */
@WebService
public interface EnderecoWebService {
    
   @WebMethod
   Endereco findById(int id) throws ValidaException;
   
   
   @WebMethod
   Endereco insert(Endereco endereco) throws ValidaException;
   
   @WebMethod
   void update(int id);
   
   @WebMethod
   void delete (int id);
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bosing.unimed.ws.interfaces;

import com.bosing.unimed.ws.exceptions.ValidaException;
import com.bosing.unimed.ws.model.Pessoa;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.sql.SQLException;


/**
 *
 * @author muril
 */
@WebService
public interface PessoaWebService {
   
   @WebMethod
   Pessoa findById(@WebParam int id) throws ValidaException;
   
   
   @WebMethod
   Pessoa insert(Pessoa pessoa) throws ValidaException;
   
   @WebMethod
   void update(int id);
   
   @WebMethod
   void delete (int id);
}

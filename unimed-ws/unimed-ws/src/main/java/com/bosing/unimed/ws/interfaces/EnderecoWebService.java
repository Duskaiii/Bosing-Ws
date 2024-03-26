/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bosing.unimed.ws.interfaces;

import com.bosing.unimed.ws.model.Endereco;
import jakarta.jws.WebMethod;
import java.sql.SQLException;

/**
 *
 * @author muril
 */
public interface EnderecoWebService {
    
   @WebMethod
   Endereco findById(int id) throws SQLException;
   
   
   @WebMethod
   Endereco insert(Endereco endereco) throws SQLException;
   
   @WebMethod
   Endereco update(Endereco endereco)throws SQLException;
   
   @WebMethod
   void delete (int id);
    
}

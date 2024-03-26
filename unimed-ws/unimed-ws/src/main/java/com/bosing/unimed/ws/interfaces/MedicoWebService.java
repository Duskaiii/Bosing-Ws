/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bosing.unimed.ws.interfaces;

import com.bosing.unimed.ws.exceptions.ValidaException;
import com.bosing.unimed.ws.model.Medico;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;


/**
 *
 * @author muril
 */
@WebService
public interface MedicoWebService {
   
   @WebMethod
   Medico findById(@WebParam int id) throws ValidaException;
   
   
   @WebMethod
   Medico insert(Medico medico) throws ValidaException;
   
   @WebMethod
   void update(int id);
   
   @WebMethod
   void delete (int id);
   
   @WebMethod
   void inativar(int id);
   
   @WebMethod
   void ativar(int id);
    
}

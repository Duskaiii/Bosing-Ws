/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bosing.unimed.ws.interfaces;

import com.bosing.unimed.ws.model.Paciente;
import jakarta.jws.WebMethod;
import java.sql.SQLException;


/**
 *
 * @author muril
 */
public interface PessoaWebService {
   
   @WebMethod
   Paciente findById(int id) throws SQLException;
   
   
   @WebMethod
   Paciente inserir(Paciente paciente) throws SQLException;
   
   @WebMethod
   Paciente atualizar(Paciente paciente)throws SQLException;
   
   @WebMethod
   void deletar (int id);
}

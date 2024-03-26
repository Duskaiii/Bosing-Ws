/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bosing.unimed.ws.interfaces;

import com.bosing.unimed.ws.model.Paciente;
import com.bosing.unimed.ws.model.Pessoa;
import jakarta.jws.WebMethod;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author muril
 */
public interface PacienteWebService {
    
   @WebMethod
   ArrayList<Paciente> findPessoa(String nome);
   
   @WebMethod
   ArrayList<Pessoa> listAll() throws SQLException;
   
   @WebMethod
   Pessoa findById(int id) throws SQLException;
   
   
   @WebMethod
   Pessoa inserir(Pessoa pessoa) throws SQLException;
   
   @WebMethod
   Pessoa atualizar(Pessoa pessoa)throws SQLException;
   
   @WebMethod
   void deletar (int id);
   
   @WebMethod
   void inativar (int id);
   
   @WebMethod
   void ativar (int id);
   
    
}

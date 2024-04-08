/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws.service;

import com.bosing.unimed.ws.exceptions.ValidaException;
import com.bosing.unimed.ws.model.Endereco;
import com.bosing.unimed.ws.repositories.EnderecoRepository;
import java.sql.SQLException;

/**
 *
 * @author muril
 */
public class EnderecoService {
    
      public Endereco findById(int id) throws ValidaException{
        
        try{
            EnderecoRepository enderecoRep = new EnderecoRepository();
            return  enderecoRep.findById(id);
        }catch(SQLException ex){
            throw new ValidaException("Erro findById");
        }
    }
    
    
    public  Endereco insert( Endereco endereco) throws ValidaException{
        try{
            EnderecoRepository enderecoRep = new EnderecoRepository();
            return  enderecoRep.insert(endereco);
        }
        catch(SQLException ex){
            ex.printStackTrace();
            throw new ValidaException("Erro Insert");
        }
    }
    
    public Endereco upadte (Endereco endereco) throws ValidaException{
        
        try{
            EnderecoRepository  enderecoRep = new EnderecoRepository();
             enderecoRep.update(endereco);
        }
        catch(SQLException ex){
            throw new ValidaException("Erro update");
        }
          return endereco;
    }
}


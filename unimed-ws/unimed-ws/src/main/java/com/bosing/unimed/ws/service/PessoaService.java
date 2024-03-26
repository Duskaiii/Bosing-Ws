/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws.service;

import com.bosing.unimed.ws.exceptions.ValidaException;
import com.bosing.unimed.ws.model.Pessoa;
import com.bosing.unimed.ws.repositories.PessoaRepository;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author muril
 */
public class PessoaService {
    
     private String nome;
    public ArrayList<Pessoa> lisAll() throws SQLException{
        PessoaRepository pessoaRepository = new PessoaRepository();
        return pessoaRepository.listAll();
    }
    
        public ArrayList<Pessoa> fiPessoa(){
       PessoaRepository pessoaRepository = new PessoaRepository();
        return pessoaRepository.findPessoa(nome);
    }
        public Pessoa findById(int id) throws ValidaException{
        try{
            PessoaRepository pessoaRepository = new PessoaRepository();
            return pessoaRepository.findById(id);
        }catch(SQLException ex){
            throw new ValidaException("Erro findById");
        }
    }
    
        
        public Pessoa insert(Pessoa pessoa) throws ValidaException{
        try{
            PessoaRepository pessoaRepository = new PessoaRepository();
            return pessoaRepository.insert(pessoa);
        }catch(SQLException ex){
            throw new ValidaException("Erro Insert");
        }
    }
        
        
        public Pessoa update(Pessoa pessoa) throws ValidaException{
        try{
            PessoaRepository pessoaRepository = new PessoaRepository();
            return pessoaRepository.update(pessoa);
        }catch(SQLException ex){
            throw new ValidaException("Erro update");
        }
    }
                
        public int delete(int Id) throws ValidaException{
        try{
           PessoaRepository pessoaRepository = new PessoaRepository();
            pessoaRepository.delete(Id);
        }
        catch(SQLException ex){
            throw new ValidaException("Erro delete");
        }
         return Id;
   
            
    }

}

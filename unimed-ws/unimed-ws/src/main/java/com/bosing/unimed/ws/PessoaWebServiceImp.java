/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws;

import com.bosing.unimed.ws.exceptions.ValidaException;

import com.bosing.unimed.ws.interfaces.PessoaWebService;
import com.bosing.unimed.ws.model.Pessoa;
import com.bosing.unimed.ws.service.PessoaService;
import jakarta.jws.WebService;


/**
 *
 * @author muril
 */

@WebService (endpointInterface = "com.bosing.unimed.ws.interfaces.PessoaWebService")
public class PessoaWebServiceImp implements PessoaWebService{

    
    @Override
    public Pessoa findById(int id) throws ValidaException  {
             PessoaService pessoaService = new PessoaService();
             return pessoaService.findById(id);   
    }

    @Override
    public Pessoa insert(Pessoa pessoa) throws ValidaException{
        PessoaService pessoaService = new PessoaService();
        
        return pessoaService.insert(pessoa);
    }

    public void delete(int id) {
      PessoaService pessoaService = new PessoaService();
     }

    @Override
    public void update(int id) {
        PessoaService pesServ = new PessoaService();
    }





    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws;

import com.bosing.unimed.ws.exceptions.ValidaException;
import com.bosing.unimed.ws.interfaces.EnderecoWebService;
import com.bosing.unimed.ws.model.Endereco;
import com.bosing.unimed.ws.service.EnderecoService;
import jakarta.jws.WebService;

/**
 *
 * @author muril
 */
@WebService ( endpointInterface = "com.bosing.unimed.ws.interfaces.EnderecoWebService")
public class EnderecoWebServiceImp implements EnderecoWebService{
    
    
    @Override
    public Endereco findById(int id) throws ValidaException  {
             EnderecoService enderecoService = new EnderecoService();
             return enderecoService.findById(id);   
    }

    @Override
    public Endereco insert(Endereco endereco) throws ValidaException{
       EnderecoService enderecoService = new EnderecoService();
        
        return enderecoService.insert(endereco);
    }

    
    public void update(int id){
         EnderecoService enderecoService = new EnderecoService();
    }

    public void delete(int id) {
      EnderecoService enderecoService = new EnderecoService();
     }


}

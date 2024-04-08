/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws;

import com.bosing.unimed.ws.exceptions.ValidaException;
import com.bosing.unimed.ws.interfaces.MedicoWebService;
import com.bosing.unimed.ws.model.Medico;
import com.bosing.unimed.ws.service.MedicoService;
import jakarta.jws.WebService;


@WebService(endpointInterface = "com.bosing.unimed.ws.interfaces.MedicoWebService")
public class MedicoWebServiceImp implements MedicoWebService{

    @Override
    public Medico findById(int id) throws ValidaException  {
             MedicoService medicoService = new MedicoService();
             return medicoService.findById(id);   
    }

    @Override
    public Medico insert(Medico medico) throws ValidaException{
        MedicoService medicoService = new MedicoService();
        
        return medicoService.insert(medico);
    }

    
    public void update(int id){
        MedicoService medService = new MedicoService();
    }

    @Override
    public void delete(int id) {
        MedicoService medicoService = new MedicoService(); 
     }
    
    public void inativar(int id){
        MedicoService medService = new MedicoService();
    }
    
    public void ativar(int id){
        MedicoService medService = new MedicoService();
    }
    
}

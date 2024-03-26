/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws.service;

import com.bosing.unimed.ws.exceptions.ValidaException;
import com.bosing.unimed.ws.repositories.MedicoRepository;
import com.bosing.unimed.ws.model.Medico;
import java.sql.SQLException;

/**
 *
 * @author Dzkyy
 */
public class MedicoService {
    
    public Medico findById(int id) throws ValidaException{
        
        try{
            MedicoRepository medicoRepository = new MedicoRepository();
            return medicoRepository.findById(id);
        }catch(SQLException ex){
            throw new ValidaException("Erro findById");
        }
    }
    
    
    public Medico insert(Medico medico) throws ValidaException{
        try{
            MedicoRepository medRep = new MedicoRepository();
            return medRep.insert(medico);
        }
        catch(SQLException ex){
            throw new ValidaException("Erro Insert");
        }
    }
    
    public void delete(int id) throws ValidaException{
        
        try{
            MedicoRepository medRep = new MedicoRepository();
            medRep.delete(id);
        }
        catch(SQLException ex){
            throw new ValidaException("Erro delete");
        }
       
    }
    
    public void inativar (Medico medico) throws ValidaException{
        try{
            MedicoRepository medRep = new MedicoRepository();
            medRep.inativar(medico);
        }
        catch(SQLException ex){
            throw new ValidaException("Erro inativar");
        }
    }
    
    public void ativar (Medico medico) throws ValidaException{
        try{
            MedicoRepository medRep = new MedicoRepository();
            medRep.ativar(medico);
        }
        catch(SQLException ex){
            throw new ValidaException("Erro Ativar");
        }
    }
    
}

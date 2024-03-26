/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws.service;

import com.bosing.unimed.ws.exceptions.ValidaException;
import com.bosing.unimed.ws.model.Paciente;
import com.bosing.unimed.ws.repositories.PacienteRepository;
import java.sql.SQLException;

/**
 *
 * @author muril
 */
public class PacienteService {
    
    public Paciente findById(int id) throws ValidaException{
        
        try{
            PacienteRepository pacienteRepository = new PacienteRepository();
            return pacienteRepository.findById(id);
        }catch(SQLException ex){
            throw new ValidaException("Erro findById");
        }
    }
    
    
    public Paciente insert(Paciente paciente) throws ValidaException{
        try{
            PacienteRepository pacienteRep = new PacienteRepository();
            return pacienteRep.insert(paciente);
        }
        catch(SQLException ex){
            throw new ValidaException("Erro Insert");
        }
    }
    
    
        public Paciente update(Paciente paciente) throws ValidaException{
        try{
            PacienteRepository pacienteRep = new PacienteRepository();
            return pacienteRep.update(paciente);
        }
        catch(SQLException ex){
            throw new ValidaException("Erro Insert");
        }
    }
    
    public void delete(int id) throws ValidaException{
        
        try{
           PacienteRepository pacienteRep = new PacienteRepository();
            pacienteRep.delete(id);
        }
        catch(SQLException ex){
            throw new ValidaException("Erro delete");
        }
       
    }
    
    public void ativar (Paciente paciente) throws ValidaException{
        try{
            PacienteRepository pacRep = new PacienteRepository();
            pacRep.ativar(paciente);
        }
        catch(SQLException ex){
            throw new ValidaException("Erro Ativar Paciente");
        }
    }
    
    public void inativar (Paciente paciente) throws ValidaException{
        try{
            PacienteRepository pacRep = new PacienteRepository();
            pacRep.ativar(paciente);
        }
        catch(SQLException ex){
            throw new ValidaException("Erro Inativar Paciente");
        }
    }
    
}

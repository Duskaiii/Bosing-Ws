/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws;

import com.bosing.unimed.ws.exceptions.ValidaException;

import com.bosing.unimed.ws.interfaces.PacienteWebService;

import com.bosing.unimed.ws.model.Paciente;
import com.bosing.unimed.ws.service.PacienteService;
import jakarta.jws.WebService;

import java.util.ArrayList;

/**
 *
 * @author muril
 */
@WebService(endpointInterface = "com.bosing.unimed.ws.interfaces.PacienteWebService")
public class PacienteWebServiceImp implements PacienteWebService{

    @Override
    public Paciente findById(int id) throws ValidaException{
             PacienteService pacienteoService = new PacienteService();
             return pacienteoService.findById(id);   
    }

    @Override
    public Paciente insert(Paciente paciente) throws ValidaException {
        PacienteService pacServ = new PacienteService();
        
        return pacServ.insert(paciente);
    }

    @Override
    public void update(int id) {
        PacienteService pacServ = new PacienteService();
    }

    @Override
    public void delete(int id) {
        PacienteService pacServ = new PacienteService();
    }

    @Override
    public void inativar(int id) {
        PacienteService pacServ = new PacienteService();
    }

    @Override
    public void ativar(int id) {
        PacienteService pacServ = new PacienteService();
    }

    
}

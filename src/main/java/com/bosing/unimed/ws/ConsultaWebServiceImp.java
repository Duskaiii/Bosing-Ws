/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws;

import com.bosing.unimed.ws.interfaces.ConsultaWebService;
import com.bosing.unimed.ws.model.Consulta;
import com.bosing.unimed.ws.repositories.ConsultaRepository;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.List;

/**
 *
 * @author Dzkyy
 */

@WebService ( endpointInterface = "com.bosing.unimed.ws.interfaces.ConsultaWebService")
public class ConsultaWebServiceImp implements ConsultaWebService{
    private ConsultaRepository consultaRepository;

    public ConsultaWebServiceImp(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public void cadastrarConsulta(Consulta consulta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Consulta> listarConsultas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws.model;

import com.bosing.unimed.ws.DTO.PessoaDTO;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Dzkyy
 */
public class Consulta{
 
    private LocalDate data;
    private PessoaDTO medico;
    private PessoaDTO paciente;

    public Consulta() {
    }

    public Consulta(LocalDate data, PessoaDTO medico, PessoaDTO paciente) {
        this.data = data;
        this.medico = medico;
        this.paciente = paciente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public PessoaDTO getMedico() {
        return medico;
    }

    public void setMedico(PessoaDTO medico) {
        this.medico = medico;
    }

    public PessoaDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PessoaDTO paciente) {
        this.paciente = paciente;
    }
    
    
    
    
}
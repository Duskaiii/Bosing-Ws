/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws.DTO;

import com.bosing.unimed.ws.model.Endereco;
import com.bosing.unimed.ws.model.Medico;
import com.bosing.unimed.ws.model.Paciente;
import java.time.LocalDate;


/**
 *
 * @author Dzkyy
 */
public class PessoaDTO {
    
    private int id;

    private LocalDate data;
            
    private int id_medico;
    private int id_paciente;

    public static PessoaDTO medicoDtoConn(Medico medico) {
        if (medico == null) {
            return null;
        }

        PessoaDTO medicoDTO = new PessoaDTO();
        
        if(medico != null){
            medicoDTO.setId_medico(medico.getId());
        }
        
        
        return medicoDTO;
    }
    
    public static PessoaDTO pessoaDtoConn(Paciente paciente){
        if(paciente == null){
            return null;
        }
        PessoaDTO pacienteDTO = new PessoaDTO();
        
        if(paciente != null){
            pacienteDTO.setId_paciente(paciente.getId());
        }
        
        return pacienteDTO;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
    
    
    
    
}

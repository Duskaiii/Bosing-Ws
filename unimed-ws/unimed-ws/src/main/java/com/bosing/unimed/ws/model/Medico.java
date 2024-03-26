/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws.model;

/**
 *
 * @author Dzkyy
 */
public class Medico extends Pessoa{
    
    private String crm;
    private String especialidade;
    private int ativo;
    

    public Medico() {
    }

    public Medico(String crm, String especialidade, int ativo, int id, String nome, String email, String telefone, String cpf) {
        super(id, nome, email, telefone, cpf);
        this.crm = crm;
        this.especialidade = especialidade;
        this.ativo = ativo;
    }

    

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    
}

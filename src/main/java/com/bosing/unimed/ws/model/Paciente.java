/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws.model;

/**
 *
 * @author muril
 */
public class Paciente extends Pessoa{
    
    private Endereco endereco;
    private int ativo;

    public Paciente() {
    }

    public Paciente(Endereco endereco) {
        this.endereco = endereco;
    }

    public Paciente(Endereco endereco, int ativo, int id, String nome, String email, String telefone, String cpf) {
        super(id, nome, email, telefone, cpf);
        this.endereco = endereco;
        this.ativo = ativo;
    }

    

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    
    
    @Override
    public String toString() {
        return "Paciente{" + "endereco=" + endereco + '}';
    }
    
    
}

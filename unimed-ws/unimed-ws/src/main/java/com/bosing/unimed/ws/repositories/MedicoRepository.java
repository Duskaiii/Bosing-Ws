/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws.repositories;

import com.bosing.unimed.ws.infraestructure.ConnectionFactory;
import com.bosing.unimed.ws.model.Medico;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dzkyy
 */
public class MedicoRepository {
    
    //Enjeção de dependencia
    EnderecoRepository endRepo = new EnderecoRepository();
    
    public MedicoRepository(){
        
    }

    public Medico insert (Medico medico) throws SQLException{
        
        medico.setEndereco(endRepo.insert(medico.getEndereco()));
        
        String query = "INSERT INTO MEDICO (NOME, EMAIL, TELEFONE," 
                +"CRM, ESPECIALIDADE)  "
                + "VALUES (?,?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
            
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            
            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getEmail());
            ps.setString(3, medico.getTelefone());
            ps.setString(4, medico.getCrm());
            ps.setString(5, medico.getEspecialidade());
            medico.getEndereco().getId();
            
            
            ps.executeQuery();
            
            rs = ps.getGeneratedKeys();
            
            rs.next();
            medico.setId(rs.getInt(1));
            
        }finally{
            if(rs != null){
                rs.close();
            }
            if(conn != null){
                conn.close();
            }
            if(ps != null){
                ps.close();
            }
        }
        
        return medico;
    }
    
    public void delete(int id) throws SQLException {

        String query = "DELETE FROM MEDICO WHERE = ?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }
    
    public Medico findById(int id) throws SQLException{
        
        String query = "SELECT M.ID, M.NOME, M.EMAIL, M.CRM, M.ESPECIALDIADE FROM MEDICO M WHERE MEDICO.ID = ? ORDER BY M.NOME ASC";
        
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        Medico medico = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                medico = new Medico();
                
                medico.setId(rs.getInt("ID"));
                medico.setNome(rs.getString("NOME"));
                medico.setEmail(rs.getString("EMAIL"));
                medico.setCrm(rs.getString("CRM"));
                medico.setEspecialidade(rs.getString("ËSPECIALIDADE"));
                
            }
        }finally{
            if(conn != null){
                conn.close();
            }
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
        }
        
        return medico;
    }
    
    public void update(Medico medico) throws SQLException{
        
        endRepo.update(medico.getEndereco());
        
        
        String query = "UPDATE MEDICO (NOME, TELEFONE) SET (?,?)";
        
        Connection conn=null;
        PreparedStatement ps = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(query);
            
            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getTelefone());
            
            ps.executeUpdate();
        }
        finally{
            if(conn != null){
                conn.close();
            }
            if(ps != null){
                ps.close();
            }
        }
    }
    
    public void inativar (Medico medico) throws SQLException{
        
        String query = "UPDATE MEDICO (ATIVO) SET (1) WHERE MEDICO.ID = (?)";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(query);
            
//            ps.setInt(1, medico.getAtivo());
            ps.setInt(1, medico.getId());
            ps.executeUpdate();
            
        }
        finally{
            if(conn != null){
                conn.close();
            }
            if(ps != null){
                ps.close();
            }
        }
    
    }
    
    public void ativar (Medico medico) throws SQLException{
        
        String query = "UPDATE MEDICO (ATIVO) SET (0) WHERE MEDICO.ID = (?)";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(query);
            
//            ps.setInt(1, medico.getAtivo());
            ps.setInt(1, medico.getId());
            ps.executeUpdate();
            
        }
        finally{
            if(conn != null){
                conn.close();
            }
            if(ps != null){
                ps.close();
            }
        }
    }
}

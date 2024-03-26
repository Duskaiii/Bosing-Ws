/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws.repositories;

import com.bosing.unimed.ws.infraestructure.ConnectionFactory;

import com.bosing.unimed.ws.model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author muril
 */
public class PacienteRepository {
     public PacienteRepository() {

            }    
    

        

    public Paciente findById(int id) throws SQLException{  
        
          String query =
            "SELECT ID, NOME, EMAIL, CPF, ID_ENDERECO, ORDER BY PACIENTE.NOME ASC" +
            "FROM PACIENTE " +
            "WHERE ID = ?";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Paciente retorno = null;
        
         try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Paciente();
               retorno.setId(rs.getInt("ID"));
               retorno.setNome(rs.getString("NOME"));
               retorno.setEmail(rs.getString("EMAIL"));
               retorno.setCpf(rs.getString("CPF"));
               retorno.setEndereco(new EnderecoRepository().findById(rs.getInt("ID_ENDERECO")));


            }
            
        } finally {
            
            if (rs != null)
                rs.close();
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
            
        }
        
        return retorno;
        
    }

        

    public Paciente insert(Paciente paciente) throws SQLException {
        
        String query = "INSERT INTO PACIENTE(NOME, EMAIL, TELEFONE, CPF, ID_ENDERECO)"
                + "VALUES(?, ?, ?, ?, ?);";
        
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
                    
            
            ps = conn.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
            
             ps.setInt(1, paciente.getId());
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getEmail());
            ps.setString(4, paciente.getCpf());
            ps.setInt(5, paciente.getEndereco().getId());
   
            
            ps.executeQuery();
            
            rs = ps.getGeneratedKeys();
            
            rs.next();
            paciente.setId(rs.getInt(1));
            
        } finally{
            if (rs != null)
                rs.close();
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }        
        
        return paciente;
    }
    
    
    public Paciente update(Paciente paciente) throws SQLException {
        
        
        String query = 
            "UPDATE PACIENTE SET NOME = ?, EMAIL = ?, CPF = ?, CPF = ?, ID_ENDERECO = ?" +
            "WHERE id = ?";
        
    
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
         try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, paciente.getId());
             pstmt.setString(2, paciente.getNome());
            pstmt.setString(3, paciente.getEmail());
            pstmt.setString(4, paciente.getCpf());
            pstmt.setInt(5, paciente.getEndereco().getId());


            
            pstmt.executeUpdate();
            
        } finally {
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        
        
        return paciente;
        
    }
    
    public int delete (int id) throws SQLException{
        
        
           String query = "DELETE FROM PACIENTE WHERE ID = ?";
        
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
         try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        
        
        return id;
        
    }
    }
    
    
    public void inativar (Paciente paciente) throws SQLException{
        
        String query = "UPDATE MEDICO (ATIVO) SET (1) WHERE MEDICO.ID = (?)";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(query);
            
//            ps.setInt(1, medico.getAtivo());
            ps.setInt(1, paciente.getId());
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
    
    public void ativar (Paciente paciente) throws SQLException{
        
        String query = "UPDATE MEDICO (ATIVO) SET (0) WHERE MEDICO.ID = (?)";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(query);
            
//            ps.setInt(1, medico.getAtivo());
            ps.setInt(1, paciente.getId());
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
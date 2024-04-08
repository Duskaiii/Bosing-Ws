/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws.repositories;

import com.bosing.unimed.ws.DTO.PessoaDTO;
import com.bosing.unimed.ws.infraestructure.ConnectionFactory;
import com.bosing.unimed.ws.model.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dzkyy
 */
public class ConsultaRepository {
    
    private List<Consulta> consultas;

    public ConsultaRepository() {
        this.consultas = new ArrayList<>();
    }

    public PessoaDTO insert (PessoaDTO consulta) throws SQLException{
        String query = "INSERT INTO CONSULTA (DATA, ID_MEDICO, ID_PACIENTE) VALUES (?,?,?)";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
            
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, consulta.getId());
            ps.setObject(2, consulta.getData());
            ps.setLong(3, consulta.getId_medico());
            ps.setLong(4, consulta.getId_paciente());
            
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            rs.next();
            
            consulta.setId(rs.getInt(1));
            
        }
        finally{
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
        return consulta;
    }
    
    
    public void delete (int id) throws SQLException{
        
        String query = "DELETE FROM CONSULTA WHERE = ?";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
            ps = conn.prepareStatement(query);
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
        }
        finally{
            if(ps!=null){
                ps.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void update(Consulta consulta) throws SQLException{
        
        String query = "UPDATE CONSULTA (DATA) SET (?)";
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
            
            ps=conn.prepareStatement(query);
            
            ps.setObject(1, consulta.getData());
                       
            ps.executeUpdate();
        }
        finally{
            if(conn!=null){
                conn.close();
            }
            if(ps!=null){
                ps.close();
            }
        }
    }
}

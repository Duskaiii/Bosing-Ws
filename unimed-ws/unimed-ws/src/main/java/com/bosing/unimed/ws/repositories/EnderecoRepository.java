/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws.repositories;

import com.bosing.unimed.ws.infraestructure.ConnectionFactory;
import com.bosing.unimed.ws.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Dzkyy
 */
public class EnderecoRepository {
    
    public Endereco findById(int id) throws SQLException{  
        
          String query =
            "SELECT ID, BAIRRO,COMPLEMENTO, LOGRADOURO, NUMERO, CIDADE, UF, CEP" +
            "FROM ENDERECO " +
            "WHERE ID = ?";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Endereco retorno = null;
        
         try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            

            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Endereco();
               retorno.setId(rs.getInt("ID"));
               retorno.setBairro(rs.getString("BAIRRO"));
               retorno.setComplemento(rs.getString("COMPLEMENTO"));
               retorno.setLogradouro(rs.getString("LOGRADOURO"));
               retorno.setNumero(rs.getString("NUMERO"));
               retorno.setCidade(rs.getString("CIDADE"));
               retorno.setUf(rs.getString("UF"));
               retorno.setCep(rs.getString("CED"));
               


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
    
    public Endereco insert(Endereco endereco) throws SQLException{
        
        
        String query = "INSERT INTO ENDERECO (LOGRADOURO, NUMERO,  "
                + "COMPLEMENTO, BAIRRO, CIDADE, UF, CEP) VALUES (?,?,?,?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
            
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,endereco.getLogradouro());
            ps.setString(2,endereco.getNumero());
            ps.setString(3,endereco.getComplemento());
            ps.setString(4,endereco.getBairro());
            ps.setString(5,endereco.getCidade());
            ps.setString(6,endereco.getUf());
            ps.setString(7,endereco.getCep());
            
            ps.executeQuery();
            
            rs.next();
            endereco.setId(rs.getInt(1));
        }
        
        finally{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        
        return endereco;
        
    }
    
    public void update(Endereco endereco) throws SQLException{
        String query ="UPDATE EMPRESA (LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, UF, CEP) SET (?,?,?,?,?,?,?) ";
        
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
            
            ps = conn.prepareStatement(query);
            
            ps.setString(1, endereco.getLogradouro());
            ps.setString(2, endereco.getNumero());
            ps.setString(3, endereco.getComplemento());
            ps.setString(4, endereco.getBairro());
            ps.setString(5, endereco.getCidade());
            ps.setString(6, endereco.getUf());
            ps.setString(7, endereco.getCep());
            
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

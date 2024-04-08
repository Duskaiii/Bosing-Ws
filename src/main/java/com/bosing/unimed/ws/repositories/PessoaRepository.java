/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bosing.unimed.ws.repositories;

import com.bosing.unimed.ws.infraestructure.ConnectionFactory;
import com.bosing.unimed.ws.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author muril
 */
public class PessoaRepository {
    
     public PessoaRepository() {

            }    
    
     public ArrayList<Pessoa> findPessoa(String nome){
        return null;    
    }  
    public ArrayList<Pessoa> listAll() throws SQLException{
        String query =
        "SELECT ID, NOME, EMAIL, TELEFONE, CPF" + "ID_ENDERECO" +
            "FROM PESSOA";
        
        ArrayList<Pessoa> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
                try {
            
            conn = new ConnectionFactory().getConnection();
            
            pstmt = conn.prepareStatement(query);
            
            rs = pstmt.executeQuery();
                    
            while (rs.next()) {
                
               Pessoa pessoa = new Pessoa() {};
               pessoa.setId(rs.getInt("ID"));
               pessoa.setNome(rs.getString("NOME"));
               pessoa.setEmail(rs.getString("EMAIL"));
               pessoa.equals(rs.getString("CPF"));
               pessoa.setTelefone(rs.getString("TELEFONE"));
               pessoa.setEndereco(new EnderecoRepository().findById(rs.getInt("ID_ENDERECO")));

                
                retorno.add(pessoa);
                
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
        

    public Pessoa findById(int id) throws SQLException{  
        
          String query =
            "SELECT ID, NOME,EMAIL, TELEFONE, CPF" + "ID_ENDERECO" +
            "FROM PESSOA " +
            "WHERE ID = ?";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Pessoa retorno = null;
        
         try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
               retorno = new Pessoa() {};
               retorno.setId(rs.getInt("ID"));
               retorno.setNome(rs.getString("NOME"));
               retorno.setEmail(rs.getString("EMAIL"));
               retorno.setCpf(rs.getString("CPF"));
               retorno.setTelefone(rs.getString("TELEFONE"));
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

        

    public Pessoa insert(Pessoa pessoa) throws SQLException {
        
        String query = "INSERT INTO PESSOA (NOME, EMAIL, TELEFONE, CPF, ID_ENDERECO)"
                + "VALUES(?, ?, ?, ?, ?);";
        
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            conn = new ConnectionFactory().getConnection();
                    
            
            ps = conn.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getEmail());
            ps.setString(3, pessoa.getTelefone());
            ps.setString(4, pessoa.getCpf());
            ps.setInt(5, pessoa.getEndereco().getId());
   
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                pessoa.setId(rs.getInt(1));    
            }
        } finally{
            if (rs != null)
                rs.close();
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }        
        
        return pessoa;
    }
    
    
    public Pessoa update(Pessoa pessoa) throws SQLException {
        
        
        String query = 
            "UPDATE PESSOA SET NOME = ?, EMAIL = ?, TELEFONE = ?, CPF = ?, ID_ENDERECO" +
            "WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
         try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, pessoa.getId());
             pstmt.setString(2, pessoa.getNome());
            pstmt.setString(3, pessoa.getEmail());
            pstmt.setString(4, pessoa.getTelefone());
            pstmt.setString(5, pessoa.getCpf());
            pstmt.setInt(6, pessoa.getEndereco().getId());


            
            pstmt.executeUpdate();
            
        } finally {
            
            if (pstmt != null)
                pstmt.close();
            
            if (conn != null)
                conn.close();
        }
        
        
        return pessoa;
        
    }
    
    public int delete (int id) throws SQLException{
        
        
           String query = "DELETE FROM PESSOA WHERE ID = ?";
        
        
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
        
        
      
        
    }
         return id;
         
}
    
}

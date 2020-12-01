/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.dao;

import br.com.loja.entidade.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hian Linhares
 */
public class FuncionarioDao extends Dao {

    private String insertSQL
            = " insert into funcionario " 
            + " ( nome, cpf,numero, bairro, cidade, uf) "
            + " values (?, ?, ?, ?, ?, ?)";

    public void inserir(Funcionario f) throws SQLException {

        Connection conn = null;
        PreparedStatement ps =null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(insertSQL);
            
            ps.setString(1, f.getNome());
            ps.setString(2, f.getCpf());
            ps.setString(3, f.getNumero());
            ps.setString(4, f.getBairro());
            ps.setString(5, f.getCidade());
            ps.setString(6, f.getUF());

            ps.executeUpdate();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeps(ps);
            closeConnection(conn);
        }

    }
}



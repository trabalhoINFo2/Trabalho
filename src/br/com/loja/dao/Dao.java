/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Hian,Guilherme,Higor
 */
public class Dao {

    protected String url= "jdbc:mysql://kubut.com/kubut_cefet_meninos?";
    protected String user ="kubut_cefet_meninos";
    protected String pwd = "cefet_meninos";
    
    public Connection getConnection() throws SQLException {
        Connection conn = null;

        try {
            conn  = DriverManager.getConnection(url, user ,pwd);
        } catch (SQLException ex) {
            throw ex;
        }

        return conn;

    }

    public void closeConnection(Connection conn){
        if (conn != null) {
        try {
            conn.close();
        } catch (SQLException sqlEx) { } // ignore

        conn = null;
    }
    }
    public void closeps(PreparedStatement ps){
        if (ps != null) {
        try {
            ps.close();
        } catch (SQLException sqlEx) { } // ignore

        ps = null;
    }
    }
    
    
}

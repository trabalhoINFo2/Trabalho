/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.dao;

import br.com.loja.entidade.Funcionario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hian Linhares
 */
public class FuncionarioDao extends Dao {

    private String insertSQL
            = " insert into funcionario "
            + " ( nome, cpf ,numero, bairro, cidade, uf) "
            + " values (?, ?, ?, ?, ?, ?)";

    private String consultarporcodSQL
            = " select * from  funcionario "
            + " where cod = ? ";

    private String consultartodosSQL
            = " select * from Funcionario";

    private String excluirSQL
            = " delete from funcionario "
            + " where cod = ? ";

    private String alterarSQL
            = " update funcionario "
            + " set nome = ?, "
            + "     cpf = ?, "
            + "     numero = ?, "
            + "     bairro = ?, "
            + "     cidade = ?, "
            + "     uf = ? "
            + " where cod = ? ";

    public void inserir(Funcionario f) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
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

    public Funcionario consultarporcod(int cod) throws SQLException {
        Funcionario f = null;
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = getConnection();
            ps = conn.prepareStatement(consultarporcodSQL);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            // perguntar sobre esse next que esta dando errado  
            // eu tentei trocar  ele de lugar em relaçao ao video mas nao deu certo
            if (rs.next()) {
                f = new Funcionario();
                f.setCodigo(cod);
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setNumero(rs.getString("numero"));
                f.setBairro(rs.getString("bairro"));
                f.setCidade(rs.getString("cidade"));
                f.setUF(rs.getString("uf"));

            }

        } catch (SQLException ex) {
            throw ex;
            // pedir pro douglas explicar dnv o pq do throw
        } finally {
            closeps(ps);
            closeConnection(conn);
        }
        return f;
    }

    public List<Funcionario> consultatodos() throws SQLException {
        List<Funcionario> ret = new ArrayList<Funcionario>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = getConnection();
            ps = conn.prepareStatement(consultartodosSQL);

            rs = ps.executeQuery();

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setCodigo(rs.getInt("cod"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setNumero(rs.getString("numero"));
                f.setBairro(rs.getString("bairro"));
                f.setCidade(rs.getString("cidade"));
                f.setUF(rs.getString("uf"));

                ret.add(f);
            }

        } catch (SQLException ex) {
            throw ex;
            // pedir pro douglas explicar dnv o pq do throw
        } finally {
            closeps(ps);
            closeConnection(conn);
        }

        return ret;
    }

    public void excluir(int cod) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = getConnection();
            ps = conn.prepareStatement(excluirSQL);
            ps.setInt(1, cod);
            ps.executeUpdate();

        } catch (SQLException ex) {
            throw ex;

        } finally {
            closeps(ps);
            closeConnection(conn);
        }

    }

    public void alterar(Funcionario f) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = getConnection();

            ps = conn.prepareStatement(alterarSQL);

            ps.setString(1, f.getNome());
            ps.setString(2, f.getCpf());
            ps.setString(3, f.getNumero());
            ps.setString(4, f.getBairro());
            ps.setString(5, f.getCidade());
            ps.setString(6, f.getUF());
            ps.setInt(7, f.getCodigo());
            ps.executeUpdate();

        
        } catch (SQLException ex) {
            throw ex;
            
        } finally {
            closeps(ps);
            closeConnection(conn);
        }


    
}


}


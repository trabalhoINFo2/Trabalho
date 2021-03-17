/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.dao;

import br.com.loja.entidade.Cliente;
import br.com.loja.entidade.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class ClienteDao extends Dao {

    private String insertSQL
            = " insert into cliente "
            + " ( nome, idade, cpf ,numero, bairro, cidade, uf) "
            + " values (?, ?, ?, ?, ?, ?, ?)";

    private String consultarporcodSQL
            = " select * from  cliente "
            + " where cod = ? ";

    private String consultartodosSQL
            = " select * from cliente";
    
    private String consultarPorNomeSQL
            = " select * from  cliente "
            + " where nome like ? ";

    private String excluirSQL
            = " delete from cliente "
            + " where cod = ? ";

    private String alterarSQL
            = " update cliente "
            + " set nome = ?, "
            + "      idade =, "
            + "     cpf = ?, "
            + "     numero = ?, "
            + "     bairro = ?, "
            + "     cidade = ?, "
            + "     uf = ? "
            + " where cod = ? ";

    public void inserir(Cliente c) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(insertSQL);

            ps.setString(1, c.getNome());
            ps.setString(2, c.getNascimento());
            ps.setString(3, c.getCpf());
            ps.setString(4, c.getNumero());
            ps.setString(5, c.getBairro());
            ps.setString(6, c.getCidade());
            ps.setString(7, c.getUF());

            ps.executeUpdate();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeps(ps);
            closeConnection(conn);
        }

    }

    public Cliente consultarporcod(int cod) throws SQLException {
        Cliente c = null;

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
                c = new Cliente();
                c.setCod(cod);
                c.setNome(rs.getString("nome"));
                c.setNascimento("idade");
                c.setCpf(rs.getString("cpf"));
                c.setNumero(rs.getString("numero"));
                c.setBairro(rs.getString("bairro"));
                c.setCidade(rs.getString("cidade"));
                c.setUF(rs.getString("uf"));

            }

        } catch (SQLException ex) {
            throw ex;
            // pedir pro douglas explicar dnv o pq do throw
        } finally {
            closeps(ps);
            closeConnection(conn);
        }
        return c;
    }
    
    public List<Cliente> consultarPorNome(String nome) throws SQLException {
        List<Cliente> ret = new ArrayList<Cliente>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = getConnection();
            ps = conn.prepareStatement(consultarPorNomeSQL);
            ps.setString(1, nome + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                 Cliente c = new Cliente();
                c.setCod(rs.getInt("cod"));
                c.setNome(rs.getString("nome"));
                c.setNascimento("idade");
                c.setCpf(rs.getString("cpf"));
                c.setNumero(rs.getString("numero"));
                c.setBairro(rs.getString("bairro"));
                c.setCidade(rs.getString("cidade"));
                c.setUF(rs.getString("uf"));

                ret.add(c);
            }

        } catch (SQLException ex) {
            throw ex;

        } finally {
            closeps(ps);
            closeConnection(conn);
        }

        return ret;
    }

    public List<Cliente> consultatodos() throws SQLException {
        List<Cliente> ret = new ArrayList<Cliente>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = getConnection();
            ps = conn.prepareStatement(consultartodosSQL);

            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCod(rs.getInt("cod"));
                c.setNome(rs.getString("nome"));
                c.setNascimento("idade");
                c.setCpf(rs.getString("cpf"));
                c.setNumero(rs.getString("numero"));
                c.setBairro(rs.getString("bairro"));
                c.setCidade(rs.getString("cidade"));
                c.setUF(rs.getString("uf"));

                ret.add(c);
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

    public void alterar(Cliente c) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = getConnection();

            ps = conn.prepareStatement(alterarSQL);

            ps.setString(1, c.getNome());
            ps.setString(2, c.getNascimento());
            ps.setString(3, c.getCpf());
            ps.setString(4, c.getNumero());
            ps.setString(5, c.getBairro());
            ps.setString(6, c.getCidade());
            ps.setString(7, c.getUF());
            ps.setInt(8, c.getCod());
            ps.executeUpdate();

        } catch (SQLException ex) {
            throw ex;

        } finally {
            closeps(ps);
            closeConnection(conn);
        }

    }

}

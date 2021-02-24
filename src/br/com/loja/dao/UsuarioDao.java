/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.dao;

import br.com.loja.entidade.Usuario;
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
public class UsuarioDao extends Dao {
    
    private String insertSQL
            = " insert into usuario "
            + " ( nome, idade, cpf ,numero, bairro, cidade, uf, usuario, senha) "
            + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private String consultarporcodSQL
            = " select * from  usuario "
            + " where cod = ? ";

    private String consultartodosSQL
            = " select * from usuario";

    private String excluirSQL
            = " delete from usuario "
            + " where cod = ? ";

    private String alterarSQL
            = " update usuario "
            + " set nome = ?, "
            +"      idade =, "
            + "     cpf = ?, "
            + "     numero = ?, "
            + "     bairro = ?, "
            + "     cidade = ?, "
            + "     uf = ? "
            + " where cod = ? ";
    
    private String loginSQL
            = " select * from  usuario "
            + " where usuario = ? "
            + " and      senha = ?";

    public void inserir(Usuario u) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(insertSQL);

            ps.setString(1, u.getNome());
            ps.setString(2, u.getNascimento());
            ps.setString(3, u.getCpf());
            ps.setString(4, u.getNumero());
            
            ps.setString(5, u.getBairro());
            ps.setString(6, u.getCidade());
            ps.setString(7, u.getUF());
            ps.setString(8, u.getUsuario());
            ps.setString(9, u.getSenha());

            ps.executeUpdate();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeps(ps);
            closeConnection(conn);
        }

    }

    public Usuario consultarporcod(int cod) throws SQLException {
        Usuario u = null;
        
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
                u = new Usuario();
                u.setCod(cod);
                u.setNome(rs.getString("nome"));
                u.setNascimento("idade");
                u.setCpf(rs.getString("cpf"));
                u.setNumero(rs.getString("numero"));
                u.setBairro(rs.getString("bairro"));
                u.setCidade(rs.getString("cidade"));
                u.setUF(rs.getString("uf"));

            }

        } catch (SQLException ex) {
            throw ex;
            // pedir pro douglas explicar dnv o pq do throw
        } finally {
            closeps(ps);
            closeConnection(conn);
        }
        return u;
    }

    public List<Usuario> consultatodos() throws SQLException {
        List<Usuario> ret = new ArrayList<Usuario>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = getConnection();
            ps = conn.prepareStatement(consultartodosSQL);

            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setCod(rs.getInt("cod"));
                u.setNome(rs.getString("nome"));
                u.setNascimento("idade");
                u.setCpf(rs.getString("cpf"));
                u.setNumero(rs.getString("numero"));
                u.setBairro(rs.getString("bairro"));
                u.setCidade(rs.getString("cidade"));
                u.setUF(rs.getString("uf"));

                ret.add(u);
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

    public void alterar(Usuario u) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = getConnection();

            ps = conn.prepareStatement(alterarSQL);

            ps.setString(1, u.getNome());
            ps.setString(2, u.getNascimento());
            ps.setString(3, u.getCpf());
            ps.setString(4, u.getNumero());
            ps.setString(5, u.getBairro());
            ps.setString(6, u.getCidade());
            ps.setString(7, u.getUF());
            ps.setInt(8, u.getCod());
            ps.setString(8, u.getUsuario());
            ps.setString(9, u.getSenha());
            ps.executeUpdate();

        
        } catch (SQLException ex) {
            throw ex;
            
        } finally {
            closeps(ps);
            closeConnection(conn);
        }


    
    }
     public Usuario loginSQL(String usuario, String senha) throws SQLException {
        Usuario u = null;
        
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement pp = null;
        ResultSet rs = null;

        try {

            conn = getConnection();
            ps = conn.prepareStatement(loginSQL);
            ps.setString(1, usuario);
            
            ps.setString(2,senha);
            rs = ps.executeQuery();
            // perguntar sobre esse next que esta dando errado  
            // eu tentei trocar  ele de lugar em relaçao ao video mas nao deu certo
            if (rs.next()) {
                u = new Usuario();
                u.setUsuario(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));

            }

        } catch (SQLException ex) {
            throw ex;
            // pedir pro douglas explicar dnv o pq do throw
        } finally {
            closeps(ps);
            closeConnection(conn);
        }
        return u;
    }
}

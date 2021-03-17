package br.com.loja.dao;

import br.com.loja.entidade.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao extends Dao {

    private String insertSQL
            = " insert into produto "
            + " (tipo, qtd, Cor, DataEntrada, Fornecedor, Valor) "
            + " values (?, ?, ?, ?, ?, ?)";

    private String consultarporcodSQL
            = " select * from  produto "
            + " where cod = ? ";

    private String consultartodosSQL
            = " select * from produto";

    private String consultarPorNomeSQL
            = " select * from  produto "
            + " where tipo like ? ";

    private String excluirSQL
            = " delete from produto "
            + " where cod = ? ";

    private String alteraSQl
            = " update produto "
            + " set tipo = ?, "
            + "      qtd  = ?, "
            + "      Cor  = ?, "
            + "      DataEntrada  = ?, "
            + "      Fornecedor  = ?, "
            + "      Valor  = ? "
            + " where cod = ? ";

    public void inserir(Produto p) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(insertSQL);

            ps.setString(1, p.getTipo());
            ps.setString(2, p.getQtd());
            ps.setString(3, p.getCor());
            ps.setString(4, p.getDataEntrada());
            ps.setString(5, p.getFornecedor());
            ps.setString(6, p.getValor());
            ps.executeUpdate();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeps(ps);
            closeConnection(conn);
        }

    }

    public Produto consultarporcod(int cod) throws SQLException {
        Produto p = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = getConnection();
            ps = conn.prepareStatement(consultarporcodSQL);
            ps.setInt(1, cod);
            rs = ps.executeQuery();

            if (rs.next()) {
                p = new Produto();
                p.setCod(cod);
                p.setTipo(rs.getString("tipo"));

                p.setQtd(rs.getString("qtd"));

            }

        } catch (SQLException ex) {
            throw ex;

        } finally {
            closeps(ps);
            closeConnection(conn);
        }
        return p;
    }

    public List<Produto> consultatodos() throws SQLException {
        List<Produto> ret = new ArrayList<Produto>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = getConnection();
            ps = conn.prepareStatement(consultartodosSQL);

            rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setCod(rs.getInt("cod"));
                p.setTipo(rs.getString("tipo"));
                p.setCor(rs.getString("Cor"));
                p.setDataEntrada(rs.getString("DataEntrada"));
                p.setValor(rs.getString("Valor"));
                p.setFornecedor(rs.getString("Fornecedor"));
                p.setQtd(rs.getString("qtd"));

                ret.add(p);
            }

        } catch (SQLException ex) {
            throw ex;

        } finally {
            closeps(ps);
            closeConnection(conn);
        }

        return ret;
    }

    public List<Produto> consultarPorNome(String tipo) throws SQLException {
        List<Produto> ret = new ArrayList<Produto>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = getConnection();
            ps = conn.prepareStatement(consultarPorNomeSQL);
            ps.setString(1, tipo + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setCod(rs.getInt("cod"));
                p.setTipo(rs.getString("tipo"));
                p.setCor(rs.getString("Cor"));
                p.setDataEntrada(rs.getString("DataEntrada"));
                p.setValor(rs.getString("Valor"));
                p.setFornecedor(rs.getString("Fornecedor"));
                p.setQtd(rs.getString("qtd"));

                ret.add(p);
            }

        } catch (SQLException ex) {
            throw ex;

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

    public void alterar(Produto p) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = getConnection();

            ps = conn.prepareStatement(alteraSQl);

            
            ps.setString(1, p.getTipo());
            ps.setString(2, p.getQtd());
            ps.setString(3, p.getCor());
            ps.setString(4, p.getDataEntrada());
            ps.setString(5, p.getFornecedor());
            ps.setString(6, p.getValor());
            ps.setInt(7, p.getCod());
            ps.executeUpdate();

        
        } catch (SQLException ex) {
            throw ex;

        } finally {
            closeps(ps);
            closeConnection(conn);
        }


    
    }

    


}

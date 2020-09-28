/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.dao;

import br.com.loja.entidade.Produto;
import br.com.loja.view.Produto.ProdutoInserir;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class ProdutoDao {

    private static List<Produto> BDProduto = new ArrayList();
    private static int proccod = 1;

    public void inserir(ProdutoInserir p) {

    }

    public Produto ConsultarProdutoCod(int cod) {
        Produto ret = null;
    }

    public void excluir(int cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Produto> ConsultarProduto() {
        return BDProduto;
    }
}

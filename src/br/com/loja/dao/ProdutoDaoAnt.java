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
public class ProdutoDaoAnt {

    private static List<Produto> BDProduto = new ArrayList<>();
    private static int proccod = 1;

    public void inserir(Produto p) {

        p.setCod(proccod);
        proccod++;
        BDProduto.add(p);

    }

    public Produto ConsultarProdutoCod(int cod) {
        Produto ret = null;

        for (int i = 0; i < BDProduto.size(); i++) {
            Produto p = BDProduto.get(i);

            if (p.getCod() == cod) {
                ret = p;
                break;
            }

        }
        return ret;
    }

    public List<Produto> ConsultarProduto() {
        return BDProduto;
    }

    public void excluir(int cod) {
        for (int i = 0; i < BDProduto.size(); i++) {
            Produto p = BDProduto.get(i);

            if (p.getCod() == cod) {
                BDProduto.remove(i);
                break;
            }

        }
    }

    public void alterar(Produto p) {
 for (int i = 0; i < BDProduto.size(); i++) {
            Produto cAux = BDProduto.get(i);

            if (cAux.getCod() == p.getCod()) {
                BDProduto.add(p);
                break;
            }

        }    }

}

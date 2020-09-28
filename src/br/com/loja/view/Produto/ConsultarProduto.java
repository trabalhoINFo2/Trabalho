/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view.Produto;

import br.com.loja.dao.ProdutoDao;
import br.com.loja.entidade.Produto;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class ConsultarProduto {

    void executar() {
        System.out.println("");
        System.out.println("----------------------");
        System.out.println("  Consultar Produto  ");
        System.out.println("----------------------");
        
        ProdutoDao pDao = new ProdutoDao();
        List<Produto> cList = pDao.ConsultarProduto();
        
        if (cList.size() > 0) {
            for (int i = 0; i < cList.size(); i++) {
                Produto p = pList.get(i);
                System.out.println("Tipo do produto: " + p.getTipo());

                System.out.println("---------------------------------");

            }
        } else {
            System.out.println("Não há Clientes na base de dados! ");
            System.out.println("---------------------------------");

        }
    }
}

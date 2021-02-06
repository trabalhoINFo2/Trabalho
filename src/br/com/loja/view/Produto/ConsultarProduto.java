/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view.Produto;

import br.com.loja.dao.ProdutoDao;
import br.com.loja.entidade.Produto;
import br.com.loja.view.Funcionário.ConsultarFuncionarioTodos;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        List<Produto> pList ;
         try {
            pList = pDao.consultatodos();
        
        if (pList.size() > 0) {
            for (int i = 0; i < pList.size(); i++) {
                Produto p = pList.get(i);
                System.out.println("Codigo do produto: "+ p.getCod());
                System.out.println("Tipo do produto: " + p.getTipo());

                System.out.println("---------------------------------");

            }
        } else {
            System.out.println("Não há Produtos na base de dados! ");
            System.out.println("---------------------------------");

        }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarFuncionarioTodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

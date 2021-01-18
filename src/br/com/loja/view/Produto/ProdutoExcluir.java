/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view.Produto;

import br.com.loja.dao.ProdutoDao;
import br.com.loja.entidade.Produto;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class ProdutoExcluir {

    void executar() {
        
        Scanner sci = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);
        
        System.out.println("");
        System.out.println("----------------------");
        System.out.println("  Excluir Produto   ");
        System.out.println("----------------------");
        System.out.println("Informe por favor o código do produto que deseja excluir.");
        
        int cod = sci.nextInt();
        
        ProdutoDao cDao = new ProdutoDao();
        Produto p = null;
        try {
            p = cDao.consultarporcod(cod);
        } catch (SQLException ex) {
            System.out.println("Nao foi possivel excluir o funcionario :- " + ex.getMessage());
        }
        
         if (p != null) {
            System.out.println("Tipo do produto: " + p.getTipo());


            System.out.println("Deseja realmente excluir este cliente? [S(sim)/N(não)]");
            
            String conf = scs.nextLine();
            

            if (conf.equalsIgnoreCase("S")) {
                try {
                    cDao.excluir(cod);
                    
                } catch (SQLException ex) {
                    System.out.println("Nao foi possivel excluir o funcionario :- " + ex.getMessage());
                }

            } else {
                    System.out.println("Produto com o código " + cod + " não existe!");
            }
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view.Produto;

import br.com.loja.dao.ProdutoDao;
import br.com.loja.entidade.Produto;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class ProdutoAlterar {
    void executar(){
        Scanner sci = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);

        System.out.println("");
        System.out.println("----------------------");
        System.out.println("  Alterar dados do Produto  ");
        System.out.println("----------------------");
        System.out.println("Informe por favor o código do produto que deseja alterar dados.");
        int cod = sci.nextInt();

        ProdutoDao pDao = new ProdutoDao();
        Produto p = pDao.ConsultarProdutoCod(cod);
        
        if (p != null) {
            System.out.println("Tipo do produto: " + p.getTipo());

            System.out.println("");
            System.out.println("Informe um novo tipo.");
            String tipo = scs.nextLine();

            System.out.println("Deseja realmente alterar essas informações? [S(sim)/N(não)]");
            String conf = scs.nextLine();

            if (conf.equalsIgnoreCase("S")) {
                p.getTipo();
                pDao.alterar(p);

            } else {
                System.out.println("Produto com o código " + cod + " não existe!");
            }
        }
    }
}

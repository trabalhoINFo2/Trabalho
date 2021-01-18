/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view.Produto;

import br.com.loja.dao.ProdutoDaoAnt;
import br.com.loja.entidade.Produto;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class ConsultarProdutoCod {
    
    Scanner sci = new Scanner(System.in);
    Scanner scs = new Scanner(System.in);
    
    void executar(){
        
        System.out.println("");
        System.out.println("--------------------------------");
        System.out.println("  Consultar Produto por Código  ");
        System.out.println("--------------------------------");
        System.out.println("Informe por favor o código do produto.");
        
        int cod = sci.nextInt();
        
        ProdutoDaoAnt pDao = new ProdutoDaoAnt();
        Produto p = pDao.ConsultarProdutoCod(cod);
        
        if (p != null) {
            
            System.out.println("Codigo do produto: "+ p.getCod());
            System.out.println("Tipo do produto: " + p.getTipo());

        } else {
            System.out.println("Produto com o código " + cod + " não existe!");
        }
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view.Produto;

import br.com.loja.entidade.Produto;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class ProdutoInserir {
    Scanner sci = new Scanner(System.in);
    
     Scanner scs = new Scanner(System.in);
    void executar() {
        
        System.out.println("=============================");
        System.out.println("==== Inserção de produto ====");
        System.out.println("=============================");
        System.out.println("Favor informar os dados do produto: ");
        
        
        System.out.println("Tipo: ");
        String tipo= scs.nextLine();
        
        System.out.println("Confirma a inserção de dados?");
        System.out.println("[S/N]");
        
        String conf = scs.nextLine();
        
        if(conf.equalsIgnoreCase("S")){
            Produto p = new Produto();
            
            p.setTipo(tipo);
            
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view;

import br.com.loja.view.Cliente.ClienteMenu;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Menuprincipal {

    public void executar() {
        Scanner sci = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);

        String[] menu = new String[]{"Cliente", "Funcionário", "Produto"};
        
        int op = 0;

        while (op != menu.length) {

            System.out.println("========================");
            System.out.println("==== Menu Principal ====");
            System.out.println("========================");
            for (int i = 0; i < menu.length; i++) {
                System.out.println(i + " - " + menu[i]);

            }

            System.out.println(menu.length + " - Sair");
            System.out.println("========================");
            System.out.print("Digite uma opção:");

            op = sci.nextInt();

            System.out.println("========================");
            if (op == 0) {

                ClienteMenu tela = new ClienteMenu();
                tela.executar();

            }else if(op == 1){
            
            }else if(op == 2){
            
            } else if (op < 0 || op > menu.length) {
                System.out.println("X=X=X=X=X=X=X=X=X=X=X=X=");
                System.out.println("X    Opção inválida    X");
                System.out.println("X=X=X=X=X=X=X=X=X=X=X=X=");
            }
        }
    }
}

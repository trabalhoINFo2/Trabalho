/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
class ClienteMenu {

    void executar() {
        Scanner sci = new Scanner(System.in);

        String[] menu = new String[]{"Inserir", "Consultar", "Deletar", "Alterar"};
        int opc = 0;

        while (opc != menu.length) {

            System.out.println("========================");
            System.out.println("  Cadastro de Clientes  ");
            System.out.println("========================");
            for (int i = 0; i < menu.length; i++) {
                System.out.println(i + " - " + menu[i]);
            }

            System.out.println(menu.length + " - Voltar");
            System.out.println("========================");
            System.out.print("Digite uma opção:");

            opc = sci.nextInt();

            System.out.println("========================");

            if (menu.length == 0) {
                ClienteInserir tela = new ClienteInserir();
                tela.executar();
            } else if (menu.length == 1) {
            } else if (menu.length == 2) {
            } else if (menu.length == 3) {
            } else if (menu.length == 4) {
                break;
            }
            if (opc < 0 || opc > menu.length) {
                System.out.println("X=X=X=X=X=X=X=X=X=X=X=X=");
                System.out.println("X    Opção inválida    X");
                System.out.println("X=X=X=X=X=X=X=X=X=X=X=X=");
            }
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view.Cliente;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ClienteMenu {

    public void executar() {
        Scanner sci = new Scanner(System.in);

        String[] menu = new String[]{"Inserir", "ConsultarClientePorCod", "ConsultarTodos",
            "Deletar", "Alterar"};
        int opc = 0;

        while (opc != menu.length) {

            System.out.println("========================");
            System.out.println("    Menu de Clientes    ");
            System.out.println("========================");
            for (int i = 0; i < menu.length; i++) {
                System.out.println(i + " - " + menu[i]);
            }

            System.out.println(menu.length + " - Voltar");
            System.out.println("========================");
            System.out.print("Digite uma opção:");

            opc = sci.nextInt();

            System.out.println("========================");

            if (opc == 0) {

                ClienteInserir tela = new ClienteInserir();
                tela.executar();
            } else if ((opc < 0) || (opc > menu.length)) {
                System.out.println("Opção inválida!");

            } else if (opc == 1) {
                ConsultarClientePorCod tela = new ConsultarClientePorCod();
                tela.executar();
                
            } else if (opc == 2) {
                ConsultarTodos tela = new ConsultarTodos();
                tela.executar();
                
            } else if (opc == 3) {
                ClienteExcluir tela = new ClienteExcluir();
                tela.executar();

            } else if (opc == 4) {
                ClienteAlterar tela = new ClienteAlterar();
                tela.executar();

            }

            if (opc < 0 || opc > menu.length) {
                System.out.println("X=X=X=X=X=X=X=X=X=X=X=X=");
                System.out.println("X    Opção inválida    X");
                System.out.println("X=X=X=X=X=X=X=X=X=X=X=X=");
            }

        }
    }
}

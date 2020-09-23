/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view.Funcionário;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class FuncionarioMenu {

    public void executar() {
        Scanner sci = new Scanner(System.in);

        String[] menu = new String[]{"Inserir", "Excluir", "Alterar", "Consultar", "Consultar p/ Código"};
        int opc = 0;

        while (opc != menu.length) {

            System.out.println("========================");
            System.out.println("    Menu de Produtos    ");
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
                FuncionarioInserir tela = new FuncionarioInserir();
                tela.executar();
            } else if (opc == 1) {
                FuncionarioExcluir tela = new FuncionarioExcluir();
                tela.executar();
            } else if (opc == 2) {
                FuncionarioAlterar tela = new FuncionarioAlterar();
                tela.executar();
            } else if (opc == 3) {
                FuncionarioInserir tela = new FuncionarioInserir();
                tela.executar();
            } else if (opc == 4) {
                FuncionarioInserir tela = new FuncionarioInserir();
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
//coeeeee rapaziadaaaa
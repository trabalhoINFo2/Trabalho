/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view.Produto;

import br.com.loja.view.Cliente.ClienteInserir;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class ProdutoMenu {
    public void executar() {
        Scanner sci = new Scanner(System.in);

        String[] menu = new String[]{"Inserir", "Excluir", "Alterar","Consultar","Consultar p/ Código"};
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

            if (menu.length == 0) {
                ProdutoInserir tela = new ProdutoInserir();
                tela.executar();
            } else if (menu.length == 1) {
                ProdutoExcluir tela = new ProdutoExcluir();
                tela.executar();
            } else if (menu.length == 2) {
                ProdutoAlterar tela = new ProdutoAlterar();
                tela.executar();
            } else if (menu.length == 3) {
                ProdutoInserir tela = new ProdutoInserir();
                tela.executar();
            } else if (menu.length == 4) {
                ProdutoInserir tela = new ProdutoInserir();
                tela.executar();
            }if (opc < 0 || opc > menu.length) {
                System.out.println("X=X=X=X=X=X=X=X=X=X=X=X=");
                System.out.println("X    Opção inválida    X");
                System.out.println("X=X=X=X=X=X=X=X=X=X=X=X=");
            }
        }
    }
}

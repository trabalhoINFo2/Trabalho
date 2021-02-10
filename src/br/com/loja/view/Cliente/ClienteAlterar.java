/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view.Cliente;

import br.com.loja.dao.ClienteDao;
import br.com.loja.entidade.Cliente;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Higor
 */
public class ClienteAlterar {

    void executar() {
        Scanner sci = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);

        System.out.println("");
        System.out.println("----------------------");
        System.out.println("  Alterar dados do Cliente  ");
        System.out.println("----------------------");
        System.out.println("Informe por favor o código do cliente que deseja alterar dados.");
        int cod = sci.nextInt();

        ClienteDao cDao = new ClienteDao();
        
        Cliente c = null;
        try {
            c = cDao.consultarporcod(cod);
        } catch (SQLException ex) {
            System.out.println("Nao foi possivel localizar o cliente :- " + ex.getMessage());
        }

        if (c != null) {
            System.out.println("Nome Completo: " + c.getNome());

            System.out.println("Idade: " + c.getNascimento());

            System.out.println("CPf: " + c.getCpf());

            System.out.println("Telefone: " + c.getTelefone());

            System.out.println("Cidade: " + c.getCidade());

            System.out.println("Estado(UF): " + c.getUF());

            System.out.println("Bairro: " + c.getBairro());

            System.out.println("CEP: " + c.getCEP());

            System.out.println("Número: " + c.getNumero());

            System.out.println("");
            System.out.println("Informe um novo nome.");
            String nome = scs.nextLine();

            System.out.println("Deseja realmente alterar essas informações? [S(sim)/N(não)]");
            String conf = scs.nextLine();

            if (conf.equalsIgnoreCase("S")) {
                c.setNome(nome);
                try{
                    cDao.alterar(c);
                } catch(SQLException ex){
                    System.out.println("Nao foi possivel alterar o cliente :- " + ex.getMessage());

                }

            } else {
                System.out.println("Cliente com o código " + cod + " não existe!");
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view.Funcionário;

import br.com.loja.dao.FuncionarioDao;
import br.com.loja.dao.FuncionarioDaoAnt;
import br.com.loja.entidade.Funcionario;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hian Linhares
 */
public class FuncionarioInserir {

    void executar() {
        Scanner sci = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);

        System.out.println("");
        System.out.println("----------------------");
        System.out.println("  Inserir funcionario  ");
        System.out.println("----------------------");
        System.out.println("Informe por favor os dados do funcionario .");

        System.out.println("nome:");
        String nome = scs.nextLine();

        System.out.println("idade:");
        int idade = sci.nextInt();

        System.out.println("cpf:");
        String cpf = scs.nextLine();

        System.out.println("telefone:");
        String telefone = scs.nextLine();

        System.out.println("cidade:");
        String cidade = scs.nextLine();

        System.out.println("UF:");
        String uf = scs.nextLine();

        System.out.println("bairro:");
        String bairro = scs.nextLine();

        System.out.println("CEP:");
        String cep = scs.nextLine();

        System.out.println("numero");
        String numero = scs.nextLine();

        System.out.println("Confirmar inserção? (sim)/(não)]");
        String conf = scs.nextLine();
        if (conf.equalsIgnoreCase("Sim")) {
            try {
                Funcionario f = new Funcionario();
                f.setNome(nome);
                f.setIdade(idade);
                f.setBairro(bairro);
                f.setCEP(cep);
                f.setCidade(cidade);
                f.setCpf(cpf);
                f.setNumero(numero);
                f.setTelefone(telefone);
                f.setUF(uf);
                
                //FuncionarioDaoAnt cDao= new FuncionarioDaoAnt();
                FuncionarioDao fDao = new FuncionarioDao();
                fDao.inserir(f);
            } catch (SQLException ex) {
                System.out.println("Ërro ao inserir funcionário :- " + ex.getMessage());
            }

        }

    }
}

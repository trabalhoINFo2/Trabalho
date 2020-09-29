/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view.Funcionário;

import br.com.loja.dao.FuncionarioDao;
import br.com.loja.entidade.Funcionario;
import java.util.Scanner;

/**
 *
 * @author Usuario
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
        int cpf = sci.nextInt();

        System.out.println("telefone:");
        int telefone = sci.nextInt();

        System.out.println("cidade:");
        String cidade = scs.nextLine();

        System.out.println("UF:");
        String uf = scs.nextLine();

        System.out.println("bairro:");
        String bairro = scs.nextLine();

        System.out.println("CEP:");
        int cep = sci.nextInt();

        System.out.println("numero");
        int numero = sci.nextInt();

        System.out.println("Confirmar inserção? [S(sim)/N(não)]");
        String conf = scs.nextLine();
        if (conf.equalsIgnoreCase("S"));
        {
            Funcionario f = new Funcionario();
            f.setNome(nome);
            f.setBairro(bairro);
            f.setCEP(conf);
            f.setCidade(cidade);
            f.setCpf(conf);
            f.setNumero(nome);
            f.setTelefone(conf);
            f.setUF(uf);

            FuncionarioDao fDao = new FuncionarioDao();
            fDao.inserir(f);
        }

    }
}

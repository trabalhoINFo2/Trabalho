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
        int numero = sci.nextInt();

        System.out.println("Confirmar inserção? [S(sim)/N(não)]");
        String conf = scs.nextLine();
        if (conf.equalsIgnoreCase("S")){
        Funcionario f = new Funcionario();
        f.setNome(nome);
        f.setIdade(idade);
        f.setBairro(bairro);
        f.setCEP(cep);
        f.setCidade(cidade);
        f.setCpf(cpf);
        f.setNumero(nome);
        f.setTelefone(telefone);
        f.setUF(uf);
        
        
        
        
        FuncionarioDao cDao= new FuncionarioDao();
        cDao.inserir(f);
        
        } 
        
    }
}

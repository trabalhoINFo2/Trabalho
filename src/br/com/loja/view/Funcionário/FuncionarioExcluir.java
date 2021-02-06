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
 * @author Usuario
 */
public class FuncionarioExcluir {

    void executar() {

        Scanner sci = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);

        System.out.println("");
        System.out.println("exclusão de funcionario");
        System.out.println("");
        System.out.println("favor informar o codigo do funcionario");
        int cod = sci.nextInt();

        FuncionarioDao cDao = new FuncionarioDao();

        Funcionario f = null;
        try {
            f = cDao.consultarporcod(cod);
        } catch (SQLException ex) {
            System.out.println("Nao foi possivel excluir o funcionario :- " + ex.getMessage());
        }

        if (f != null) {
            System.out.println("cod:   " + f.getCodigo());
            System.out.println("nome:   " + f.getNome());
            System.out.println("idade:   " + f.getIdade());
            System.out.println("telefone:   " + f.getTelefone());
            System.out.println("uf:   " + f.getUF());
            System.out.println("cidade:   " + f.getCidade());
            System.out.println("bairro:   " + f.getBairro());
            System.out.println("cpf:   " + f.getCpf());

            System.out.println("deseja excluir esse funcionario ? [SIM/NAO]");
            String confirmacao = scs.nextLine();
            if (confirmacao.equalsIgnoreCase("sim")) {
                try {
                    cDao.excluir(cod);
                } catch (SQLException ex) {
                    System.out.println("Nao foi possivel excluir o funcionario :- " + ex.getMessage());
                }
            }

        } else {
            System.out.println("funcionario do " + cod + "nao existe na base de dados");
        }

    }

}

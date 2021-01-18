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
public class FuncionarioAlterar {

    void executar() {
        Scanner sci = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);

        System.out.println("============================");
        System.out.println("alteraçao de funcionário");
        System.out.println("===========================");
        System.out.println("favor informar o codigo do funcionário");
        int cod = sci.nextInt();

        FuncionarioDao fDao = new FuncionarioDao();

        Funcionario f = null;
        try {
            f = fDao.consultarporcod(cod);
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

            System.out.println("informe o novo nome");
            String novonome = scs.nextLine();
            System.out.println("informe a nova idade");
            int novaidade = sci.nextInt();
            System.out.println("informe o novo telefone");
            String novotelefone = scs.nextLine();
            System.out.println("informe o novo uf");
            String novouf = scs.nextLine();
            System.out.println("informe o nova cidade");
            String novacidade = scs.nextLine();
            System.out.println("informe o novo bairro");
            String novobairro = scs.nextLine();
            System.out.println("informe o novo cpf");
            String novocpf = scs.nextLine();
            
            //coloquei os outros parametros que faltava pois so estava pedindo para mudar o nome

            System.out.println("deseja alterar esse cliente ? [SIM/NAO]");
            String confirmacao = scs.nextLine();
            if (confirmacao.equalsIgnoreCase("Sim")) {
                f.setNome(novonome);
                try {
                    fDao.alterar(f);
                } catch (SQLException ex) {
                    System.out.println("Nao foi possivel alterar o funcionario :- " + ex.getMessage());
                }
            }

        } else {
            System.out.println("funcionario do " + cod + " nao existe na base de dados");
        }

    }

}

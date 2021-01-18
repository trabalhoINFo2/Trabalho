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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hian Linhares
 */
public class ConsultarFuncionarioTodos {

    void executar() {
        System.out.println("");
        System.out.println("consulta de todos os funcionários");
        System.out.println("");

        FuncionarioDao cDao = new FuncionarioDao();
        List<Funcionario> cList;
        try {
            cList = cDao.consultatodos();

            if (cList.size() > 0) {
                for (int i = 0; i < cList.size(); i++) {
                    Funcionario f = cList.get(i);
                    System.out.println("cod:   " + f.getCodigo());
                    System.out.println("nome:   " + f.getNome());
                    System.out.println("idade:   " + f.getIdade());
                    System.out.println("telefone:   " + f.getTelefone());
                    System.out.println("uf:   " + f.getUF());
                    System.out.println("cidade:   " + f.getCidade());
                    System.out.println("bairro:   " + f.getBairro());
                    System.out.println("cpf:   " + f.getCpf());
                    System.out.println("---------------------------------");

                }

            } else {
                System.out.println("nao ha clientes no banco de dados ");
                System.out.println("---------------------------------");

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarFuncionarioTodos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

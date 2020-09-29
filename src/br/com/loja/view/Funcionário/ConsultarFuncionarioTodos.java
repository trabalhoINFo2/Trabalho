/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view.Funcionário;

import br.com.loja.dao.FuncionarioDao;
import br.com.loja.entidade.Funcionario;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ConsultarFuncionarioTodos {

    void executar() {
        System.out.println("");
        System.out.println("consulta de todos os funcionários");
        System.out.println("");

        FuncionarioDao cDao = new FuncionarioDao();
        List<Funcionario> cList = cDao.consultartodos();

        if (cList.size() > 0) {
            for (int i = 0; i < cList.size(); i++) {
                Funcionario c = cList.get(i);
                System.out.println("cod:   " + c.getCodigo());
                System.out.println("nome:   " + c.getNome());
                System.out.println("idade:   " + c.getIdade());
                System.out.println("telefone:   " + c.getTelefone());
                System.out.println("uf:   " + c.getUF());
                System.out.println("cidade:   " + c.getCidade());
                System.out.println("bairro:   " + c.getBairro());
                System.out.println("cpf:   " + c.getCpf());

            }

        }else{
            System.out.println("nao ha clientes no banco de dados ");
              System.out.println("---------------------------------");
            
        }

    }

}

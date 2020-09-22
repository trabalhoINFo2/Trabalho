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
public class ConsultarFuncionarioCod {

    Scanner sci = new Scanner(System.in);
    Scanner scs = new Scanner(System.in);

    void executar() {
        System.out.println("");
        System.out.println("consulta de funcionario");
        System.out.println("");
        System.out.println("favor informar o codigo do funcionario");
        int codigo = sci.nextInt();

        FuncionarioDao cDao = new FuncionarioDao();

        Funcionario c = cDao.consultar(codigo);

        if (c != null) {
            System.out.println("cod:   " + c.getCodigo());
            System.out.println("nome:   " + c.getNome());
            System.out.println("idade:   " + c.getIdade());
            System.out.println("telefone:   " + c.getTelefone());
            System.out.println("uf:   " + c.getUF());
            System.out.println("cidade:   " + c.getCidade());
            System.out.println("bairro:   " + c.getBairro());
             System.out.println("cpf:   "+c.getCpf());
             
        }else {
            System.out.println("funcionario do "+codigo+"nao existe na base de dados");
        }

    }
    
    

}

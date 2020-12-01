/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.view.Funcionário;

import br.com.loja.dao.FuncionarioDaoAnt;
import br.com.loja.entidade.Funcionario;
import java.util.Scanner;

/**
 *
 * @author Hian Linhares 
 */
public class ConsultarFuncionarioCod {

    Scanner sci = new Scanner(System.in);
    Scanner scs = new Scanner(System.in);

    void executar() {
        System.out.println("");
        System.out.println("Consulta de funcionário.");
        System.out.println("");
        System.out.println("Favor informar o código do funcionário.");
        int codigo = sci.nextInt();

        FuncionarioDaoAnt cDao = new FuncionarioDaoAnt();

        Funcionario c = cDao.consultar(codigo);

        if (c != null) {
            System.out.println("Código :   " + c.getCodigo());
            System.out.println("Nome Completo :   " + c.getNome());
            System.out.println("Idade :   " + c.getIdade());
            System.out.println("Telefone :   " + c.getTelefone());
            System.out.println("UF :   " + c.getUF());
            System.out.println("Cidade :   " + c.getCidade());
            System.out.println("Bairro :   " + c.getBairro());
             System.out.println("CPF :   "+c.getCpf());
             
        }else {
            System.out.println("Funcionário com o "+codigo+" não existe na base de dados.");
        }

    }
    
    

}

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
public class ConsultarFuncionarioCod {

    Scanner sci = new Scanner(System.in);
    Scanner scs = new Scanner(System.in);

    void executar() {
        System.out.println("");
        System.out.println("Consulta de funcionário.");
        System.out.println("");
        System.out.println("Favor informar o código do funcionário.");
        int codigo = sci.nextInt();

        FuncionarioDao cDao = new FuncionarioDao();

        Funcionario c;
        try {
            c = cDao.consultarporcod(codigo);
            if (c != null) {
                System.out.println("Código :   " + c.getCodigo());
                System.out.println("Nome Completo :   " + c.getNome());
                System.out.println("Idade :   " + c.getIdade());
                System.out.println("Telefone :   " + c.getTelefone());
                System.out.println("UF :   " + c.getUF());
                System.out.println("Cidade :   " + c.getCidade());
                System.out.println("Bairro :   " + c.getBairro());
                System.out.println("CPF :   " + c.getCpf());

            } else {
                System.out.println("Funcionário com o código " + codigo + " não existe na base de dados.");
            }
        } catch (SQLException ex) {
            System.out.println("erro ao consultar funcionário : " + ex.getMessage());
        }

    }

}

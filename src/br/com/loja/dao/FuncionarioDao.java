/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.dao;

import br.com.loja.entidade.Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hian
 */
public class FuncionarioDao {

    private static List<Funcionario> bd = new ArrayList<Funcionario>();
    private static int proximoCod = 1;

    public void inserir(Funcionario c) {
        c.setCodigo(proximoCod);
        proximoCod++;

        bd.add(c);

    }

    public Funcionario consultar(int codigo) {
        Funcionario ret = null;

        for (int i = 0; i < bd.size(); i++) {
            Funcionario c = bd.get(i);

            if (c.getCodigo() == codigo) {
                ret = c;
                break;
            }

        }

        return ret;
    }

    public List<Funcionario> consultartodos() {
        return bd;
    }

    
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

package br.com.loja.dao;

import br.com.loja.entidade.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    private List<Cliente> bd = new ArrayList<Cliente>();
    private int proximoCod = 1;
    public void inserir(Cliente c) {
    c.setCod(proximoCod);
    proximoCod ++;
    bd.add(c);
    }
}

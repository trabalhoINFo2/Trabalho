package br.com.loja.dao;

import br.com.loja.entidade.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

    private final List<Cliente> bd = new ArrayList<>();
    private static int proximoCod = 1;

    public void inserir(Cliente c) {
        c.setCod(proximoCod);
        proximoCod++;
        bd.add(c);

    }

    public Cliente consultarclienteporcod(int cod) {
        Cliente ret = null;

        for (int i = 0; i < bd.size(); i++) {
            Cliente c = bd.get(i);

            if (c.getCod() == cod) {
                ret = c;
                break;
            }

        }
        return ret;

    }

    public List<Cliente> consultartodos() {
        return bd;
    }
}

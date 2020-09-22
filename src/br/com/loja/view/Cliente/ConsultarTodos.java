package br.com.loja.view.Cliente;

import br.com.loja.dao.ClienteDao;
import br.com.loja.entidade.Cliente;
import java.util.List;

class ConsultarTodos {

    void executar() {
        System.out.println("");
        System.out.println("----------------------");
        System.out.println("  Consultar Cliente  ");
        System.out.println("----------------------");

        ClienteDao cDao = new ClienteDao();
        List<Cliente> cList = cDao.consultartodos();

        if (cList.size() > 0) {
            for (int i = 0; i < cList.size(); i++) {
                Cliente c = cList.get(i);
                System.out.print("Nome Completo: " + c.getNome());

                System.out.print("Idade: " + c.getIdade());

                System.out.print("CPf: " + c.getCpf());

                System.out.print("Telefone: " + c.getTelefone());

                System.out.print("Cidade: " + c.getCidade());

                System.out.print("Estado(UF): " + c.getUF());

                System.out.print("Bairro: " + c.getBairro());

                System.out.print("CEP: " + c.getCEP());

                System.out.print("Número: " + c.getNumero());

                System.out.println("---------------------------------");

            }
        } else {
            System.out.println("Não há Clientes na base de dados! ");
            System.out.println("---------------------------------");
        }

    }
}

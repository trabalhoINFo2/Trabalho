package br.com.loja.view.Cliente;

import br.com.loja.dao.ClienteDao;
import br.com.loja.entidade.Cliente;
import br.com.loja.view.Funcionário.ConsultarFuncionarioTodos;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Higor
 */
class ConsultarTodos {

    void executar() {
        System.out.println("");
        System.out.println("----------------------");
        System.out.println("  Consultar Cliente  ");
        System.out.println("----------------------");

        ClienteDao cDao = new ClienteDao();
        List<Cliente> cList;
        try{
           cList = cDao.consultatodos();
        
        if (cList.size() > 0) {
            for (int i = 0; i < cList.size(); i++) {
                Cliente c = cList.get(i);
                System.out.println("Nome Completo: " + c.getNome());

                System.out.println("Idade: " + c.getNascimento());

                System.out.println("CPf: " + c.getCpf());

                System.out.println("Telefone: " + c.getTelefone());

                System.out.println("Cidade: " + c.getCidade());

                System.out.println("Estado(UF): " + c.getUF());

                System.out.println("Bairro: " + c.getBairro());

                System.out.println("CEP: " + c.getCEP());

                System.out.println("Número: " + c.getNumero());

                System.out.println("---------------------------------");

            }
        } else {
            System.out.println("Não há Clientes na base de dados! ");
            System.out.println("---------------------------------");

        }
        }catch(SQLException ex){
                    Logger.getLogger(ConsultarFuncionarioTodos.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}

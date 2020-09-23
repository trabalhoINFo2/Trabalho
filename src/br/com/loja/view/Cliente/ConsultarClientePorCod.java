package br.com.loja.view.Cliente;

import br.com.loja.dao.ClienteDao;
import br.com.loja.entidade.Cliente;
import java.util.Scanner;
/**
 *
 * @author Higor
 */
public class ConsultarClientePorCod {

    Scanner sci = new Scanner(System.in);
    Scanner scs = new Scanner(System.in);

    void executar() {
        System.out.println("");
        System.out.println("----------------------");
        System.out.println("  Consultar Cliente  ");
        System.out.println("----------------------");
        System.out.println("Informe por favor o código do cliente.");
        int cod = sci.nextInt();

        ClienteDao cDao = new ClienteDao();
        Cliente c = cDao.consultarclienteporcod(cod);

        if (c != null) {
            System.out.println("Nome Completo: " + c.getNome());

            System.out.println("Idade: " + c.getIdade());

            System.out.println("CPf: " + c.getCpf());

            System.out.println("Telefone: " + c.getTelefone());

            System.out.println("Cidade: " + c.getCidade());

            System.out.println("Estado(UF): " + c.getUF());

            System.out.println("Bairro: " + c.getBairro());

            System.out.println("CEP: " + c.getCEP());

            System.out.println("Número: " + c.getNumero());

        } else {
            System.out.println("Cliente com o código " + cod + " não existe!");
        }
    }
}

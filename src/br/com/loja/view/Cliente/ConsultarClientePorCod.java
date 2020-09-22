package br.com.loja.view.Cliente;

import br.com.loja.dao.ClienteDao;
import br.com.loja.entidade.Cliente;
import java.util.Scanner;

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
            System.out.print("Nome Completo: " + c.getNome());

            System.out.print("Idade: " + c.getIdade());

            System.out.print("CPf: " + c.getCpf());

            System.out.print("Telefone: " + c.getTelefone());

            System.out.print("Cidade: " + c.getCidade());

            System.out.print("Estado(UF): " + c.getUF());

            System.out.print("Bairro: " + c.getBairro());

            System.out.print("CEP: " + c.getCEP());

            System.out.print("Número: " + c.getNumero());

        } else {
            System.out.println("Cliente com o código " + cod + " não existe!");
        }
    }
}

package br.com.loja.view.Cliente;

import br.com.loja.dao.ClienteDao;
import br.com.loja.entidade.Cliente;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author Higor
 */
public class ClienteInserir {

    Scanner sci = new Scanner(System.in);
    Scanner scs = new Scanner(System.in);

    void executar() {
        System.out.println("");
        System.out.println("----------------------");
        System.out.println("  Inserir Cliente  ");
        System.out.println("----------------------");
        System.out.println("Informe por favor os dados do cliente.");
        System.out.print("Nome Completo: ");
        String nome = scs.nextLine();

        System.out.print("Idade: ");
        String idade = sci.nextLine();

        System.out.print("CPf: ");
        String cpf = sci.nextLine();

        System.out.print("Telefone: ");
        String telefone = sci.nextLine();

        System.out.print("Cidade: ");
        String cidade = sci.nextLine();

        System.out.print("Estado(UF): ");
        String uf = sci.nextLine();

        System.out.print("Bairro: ");
        String bairro = sci.nextLine();

        System.out.print("CEP: ");
        String cep = sci.nextLine();

        System.out.print("Número: ");
        String numero = sci.nextLine();

        System.out.println("Confirmar inserção? [S(sim)/N(não)]");
        String conf = scs.nextLine();
        if (conf.equalsIgnoreCase("S")){
            try{
                Cliente c = new Cliente();
                c.setNome(nome);
                c.setCpf(cpf);
                c.setTelefone(telefone);
                c.setCidade(cidade);
                c.setUF(uf);
                c.setBairro(bairro);
                c.setCEP(cep);

                ClienteDao cDao = new ClienteDao();
                cDao.inserir(c);
            }catch(SQLException ex){
                System.out.println("Erro ao inserir cliente :- " + ex.getMessage());
            }
        }

    }

}

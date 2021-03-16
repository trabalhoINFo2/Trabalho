/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.loja.entidade;

/**
 *
 * @author Guilherme
 */
public class Produto {

    private String DataEntrada;
    private String Valor;
    private String Fornecedor;
    private String Cor;
    private int cod;
    private String tipo;
    private String qtd;

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public String getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(String Fornecedor) {
        this.Fornecedor = Fornecedor;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    public String getDataEntrada() {
        return DataEntrada;
    }

    public void setDataEntrada(String DataEntrada) {
        this.DataEntrada = DataEntrada;
    }

    public String getQtd() {
        return qtd;
    }

    public void setQtd(String qtd) {
        this.qtd = qtd;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}

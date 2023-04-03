package br.gov.cesarschool.poo.fidelidade.cartao.negocio;

import java.util.Date;

public class CartaoFidelidade{

    private long numero;
    private double saldo;
    java.util.Date dataHoraAtualizacao;

    public CartaoFidelidade(){
    }
    public CartaoFidelidade(long numero) {
        this.numero = numero;
    }
    public long getNumero() {
        return numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public java.util.Date getDataHoraAtualizacao() {
        return dataHoraAtualizacao;
    }
    public void creditar(double valor){
        this.saldo = this.saldo + valor;
        this.dataHoraAtualizacao = new Date();
    }
    public void debitar(double valor){
        this.saldo = this.saldo - valor;
        this.dataHoraAtualizacao = new Date();
    }

}

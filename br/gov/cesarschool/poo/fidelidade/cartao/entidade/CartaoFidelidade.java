package br.gov.cesarschool.poo.fidelidade.cartao.entidade;

import java.util.Date;

public class CartaoFidelidade {
    private long numero;
    private double saldo;
    private Date dataHoraAtualizacao;
    
    public long getNumero() {
        return numero;
    }
    public void setNumero(long numero) {
        this.numero = numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public Date getDataHoraAtualizacao() {
        return dataHoraAtualizacao;
    }
    public void setDataHoraAtualizacao(Date dataHoraAtualizacao) {
        this.dataHoraAtualizacao = dataHoraAtualizacao;
    }

    public CartaoFidelidade(long numero){
        this.numero = numero;
    }

    void creditar(double valor){
        this.saldo += valor;
    
    }
    
}

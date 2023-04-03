package br.gov.cesarschool.poo.fidelidade.geral.negocio;

import java.util.Date;
import java.util.Calendar;

public class Cliente extends Endereco{

    private String cpf;
    private String nomeCompleto;
    private java.util.Date dataNascimento;
    private double renda;
    private Endereco endereco;
    private Sexo sexo;
    
    public Sexo getSexo() {
        return sexo;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public String getCpf() {
        return cpf;
    }
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public java.util.Date getDataNascimento() {
        return dataNascimento;
    }
    public double getRenda() {
        return renda;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public void setDataNascimento(java.util.Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setRenda(double renda) {
        this.renda = renda;
    }
    public Cliente(){
        
    }
    public Cliente(String logradouro, int numero, String complemento, String cep, String cidade, String estado,
            String pais, String cpf, String nomeCompleto, Date dataNascimento, double renda, Endereco endereco,
            Sexo sexo) {
        super(logradouro, numero, complemento, cep, cidade, estado, pais);
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.renda = renda;
        this.endereco = endereco;
        this.sexo = sexo;
    }

    public int obterIdade() {
        Calendar dataNasc = Calendar.getInstance();
        dataNasc.setTime(dataNascimento);
        Calendar hoje = Calendar.getInstance();
        int idade = hoje.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);
        if (hoje.get(Calendar.DAY_OF_YEAR) < dataNasc.get(Calendar.DAY_OF_YEAR)) {
            idade--;
        }
        return idade;
    }


 }
package br.gov.cesarschool.poo.fidelidade.cliente.negocio;

import br.gov.cesarschool.poo.fidelidade.util.*;
import br.gov.cesarschool.poo.fidelidade.geral.entidade.Endereco;
import br.gov.cesarschool.poo.fidelidade.cliente.dao.ClienteDAO;
import br.gov.cesarschool.poo.fidelidade.cartao.negocio.CartaoFidelidadeMediator;
import br.gov.cesarschool.poo.fidelidade.cliente.entidade.Cliente;
import br.gov.cesarschool.poo.fidelidade.cartao.dao.LancamentoExtratoDAO;


import br.gov.cesarschool.poo.fidelidade.cartao.dao.CartaoFidelidadeDAO;
import br.gov.cesarschool.poo.fidelidade.util.ResultadoInclusaoCliente;

//Terminar esse mediator
public class ClienteMediator {
    private static final int NUMERO_ERRO = 0;
    private ClienteDAO repositorioCliente;
    private CartaoFidelidadeMediator cartaoMediator;
    private static ClienteMediator instancia = null;
    private CartaoFidelidadeDAO repositorioCartao;
    private LancamentoExtratoDAO repositorioLancamento;

    Cliente cliente = new Cliente(null, null, null, null, 0, null);
    
    public static ClienteMediator getInstance() {
        if (instancia == null) {
            instancia = new ClienteMediator();
        }
        return instancia;
    }


    private ClienteMediator() {
        this.repositorioCliente = new ClienteDAO();
        this.cartaoMediator = CartaoFidelidadeMediator.getInstance(repositorioCartao, repositorioLancamento);
    }

    

    private String validar(Cliente cliente){
        if (!ValidadorCPF.ehCpfValido(cliente.getCpf())){
            return "CPF Inválido";
        }
        if (!StringUtil.ehNuloOuBranco(cliente.getNomeCompleto())){
            return "Nome Inválido";
        }
        if (!StringUtil.ehNuloOuBranco(cliente.getSexo().getDescricao())){
            return "Sexo não selecionado";
        }
        int idadeAtual = cliente.obterIdade();
        if (idadeAtual < 18 && idadeAtual > 0){
            return "Menor de idade";
        }
        if (idadeAtual == 0){
            return "Idade não inserida";
        }
        if (cliente.getRenda() < 0){
            return "Renda nao pode ser negativa";
        }
        Endereco endereco = cliente.getEndereco();
        if(endereco == null){
            return "campo 'Endereco' obrigatorio";
        }else{
            String logradouro = endereco.getLogradouro();
            if(!StringUtil.ehNuloOuBranco(logradouro) || logradouro.length() < 4){
                return "campo 'Logradouro' obrigatorio e deve ter 4 caracteres";
            }
            if(endereco.getNumero() < 0){
                return "Numero nao pode ser negativo";
            }
            if (!StringUtil.ehNuloOuBranco(endereco.getCidade())){
                return "campo 'Cidade' obrigatorio";
            }
            if (!StringUtil.ehNuloOuBranco(endereco.getEstado())){
                return "campo 'Estado' obrigatorio";
            }
            if (!StringUtil.ehNuloOuBranco(endereco.getPais())){
                return "campo 'Pais' obrigatorio";
            }
        }return "Dados validos";

    }

    public ResultadoInclusaoCliente incluir(Cliente cliente){
        String mensagem = validar(cliente);
        if(mensagem != null){
            return new ResultadoInclusaoCliente(NUMERO_ERRO, mensagem);
        }
        boolean resultRepositorioCliente = repositorioCliente.incluir(cliente);
        if(!resultRepositorioCliente){
            return new ResultadoInclusaoCliente(NUMERO_ERRO, "Erro ao incluir cliente no repositorio");
        }
        long numeroCartao = cartaoMediator.gerarCartao(cliente);
        if (numeroCartao < 0){
            return new ResultadoInclusaoCliente(NUMERO_ERRO, "Erro ao criar cartao fidelidade");
        }
        return new ResultadoInclusaoCliente(numeroCartao, null);
    }
    //Fazer método String validar para os outros atributos de cliente - nome, data de nascimento, rua, cidade, numero, etc.
}

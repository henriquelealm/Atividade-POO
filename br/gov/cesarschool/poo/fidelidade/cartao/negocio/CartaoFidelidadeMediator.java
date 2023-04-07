package br.gov.cesarschool.poo.fidelidade.cartao.negocio;

import br.gov.cesarschool.poo.fidelidade.cliente.entidade.Cliente;
import br.gov.cesarschool.poo.fidelidade.cartao.dao.LancamentoExtratoDAO;
import br.gov.cesarschool.poo.fidelidade.cartao.dao.CartaoFidelidadeDAO;
import br.gov.cesarschool.poo.fidelidade.cartao.entidade.CartaoFidelidade;

import java.time.LocalDateTime;
//Terminar esse mediator -> Funções PONTUAR, RESGATAR;
public class CartaoFidelidadeMediator {

    private static CartaoFidelidadeMediator instancia;
    private CartaoFidelidadeDAO repositorioCartao;
    private LancamentoExtratoDAO repositorioLancamento;



    public static CartaoFidelidadeMediator getInstance(){
        if (instancia == null){
            instancia = new CartaoFidelidadeMediator();
        }
        return instancia;
    }
    
    public CartaoFidelidadeMediator() {
        repositorioCartao = new CartaoFidelidadeDAO();
        repositorioLancamento = new LancamentoExtratoDAO();

    }
    //1º metodo  
    public long gerarCartao(Cliente cliente){
        LocalDateTime tempo = LocalDateTime.now();
        
        String ano = String.format("%04d", tempo.getYear());
        String mes = String.format("%02d", tempo.getMonthValue());
        String dia = String.format("%02d", tempo.getDayOfMonth());
        String cpf = cliente.getCpf();
        
        String numeroCartao = cpf + ano + mes + dia;
        
        long numeroGerado = Long.parseLong(numeroCartao);
        
        CartaoFidelidade cartao = new CartaoFidelidade(numeroGerado);
        
        return cartao.getNumero();
    }

}
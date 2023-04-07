package br.gov.cesarschool.poo.fidelidade.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import br.gov.cesarschool.poo.fidelidade.cliente.entidade.*;

import br.gov.cesarschool.poo.fidelidade.geral.entidade.*;

import org.junit.*;


public class TesteValidadorCPF {
    Date data = new Date(System.currentTimeMillis());

    @Test
    public void CPFNuloOuBranco(){
        Endereco endereco = new Endereco("Rua A", 0, "123", "Centro", "Recife", "PE", "Brasil");
        Cliente cliente1 = new Cliente("07521772490", "afdasfsa", Sexo.MASCULINO, data, 55.05, endereco);
        assertFalse(StringUtil.ehNuloOuBranco(cliente1.getCpf()));
        Cliente cliente2 = new Cliente("", "fasdfdsaf", Sexo.MASCULINO, data, 55.05, endereco);
        assertTrue(StringUtil.ehNuloOuBranco(cliente2.getCpf()));
    }
    @Test
    public void CPFTamanhoInvalido(){
        Endereco endereco = new Endereco("Rua A", 0, "123", "Centro", "Recife", "PE", "Brasil");
        Cliente cliente1 = new Cliente("075217724909", "afdasfsa", Sexo.MASCULINO, data, 55.05, endereco);
        assertFalse(ValidadorCPF.ehCpfValido(cliente1.getCpf()));
    }
    @Test
    public void CPFDigitoInvalido(){
        Endereco endereco = new Endereco("Rua A", 0, "123", "Centro", "Recife", "PE", "Brasil");
        Cliente cliente1 = new Cliente("075217AB4909", "afdasfsa", Sexo.MASCULINO, data, 55.05, endereco);
        assertFalse(ValidadorCPF.ehCpfValido(cliente1.getCpf()));
    }
}

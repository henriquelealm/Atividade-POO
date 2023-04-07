package br.gov.cesarschool.poo.fidelidade.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class TesteValidadorCPF {

    @Test
    public void testEhCpfValido_CPFNulo() {
        assertFalse(ValidadorCPF.ehCpfValido(null));
    }
    
    @Test
    public void testEhCpfValido_CPFBranco() {
        assertFalse(ValidadorCPF.ehCpfValido(""));
    }

    @Test
    public void testEhCpfValido_CPFTamanhoDiferenteDe11() {
        assertFalse(ValidadorCPF.ehCpfValido("1234567890"));
        assertFalse(ValidadorCPF.ehCpfValido("123456789012"));
        assertFalse(ValidadorCPF.ehCpfValido("123"));
    }

    @Test
    public void testEhCpfValido_CPFComCaracteresDiferentes() {
        assertFalse(ValidadorCPF.ehCpfValido("J2a45b7890c"));
    }

    @Test
    public void testEhCpfValido_CPFComDVInvalido() {
        assertFalse(ValidadorCPF.ehCpfValido("12345678900"));
        assertFalse(ValidadorCPF.ehCpfValido("52998224726"));
        assertFalse(ValidadorCPF.ehCpfValido("12345678910"));
        assertFalse(ValidadorCPF.ehCpfValido("52998224727"));
    }

    @Test
    public void testEhCpfValido_CPFComDvValido() {
        assertTrue(ValidadorCPF.ehCpfValido("12345678909"));
        assertTrue(ValidadorCPF.ehCpfValido("52998224725"));
        assertTrue(ValidadorCPF.ehCpfValido("13677724007"));
        assertTrue(ValidadorCPF.ehCpfValido("29419241084"));
        assertTrue(ValidadorCPF.ehCpfValido("82925083099"));
        assertTrue(ValidadorCPF.ehCpfValido("82732209074"));
    }
}
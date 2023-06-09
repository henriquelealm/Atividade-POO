package br.gov.cesarschool.poo.fidelidade.util;



public class ValidadorCPF {
    
    public static boolean ehCpfValido(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
        if (cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999") )
            return(false);
            
        // 1º dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int resto = 11 - soma % 11;
        int digitoVerificador1 = resto == 10 || resto == 11 ? 0 : resto;
        
        if (digitoVerificador1 != cpf.charAt(9) - '0') {
            return false;
        }
        
        // 2º dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        resto = 11 - soma % 11;
        int digitoVerificador2 = resto == 10 || resto == 11 ? 0 : resto;
        
        if (digitoVerificador2 != cpf.charAt(10) - '0') {
            return false;
        }
        
        return true;
    }
}


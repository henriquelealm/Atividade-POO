package br.gov.cesarschool.poo.fidelidade.util;



public class ValidadorCPF {
    
    public static boolean ehCpfValido(String cpf){
        if(cpf == null || cpf.length() != 11){
            return false;
        }
        //Digitos iguais e algum digito fora do range 0-9
        boolean digitosVerificador = true;
        for(int i = 1; i < cpf.length(); i++){
            if(cpf.charAt(0) != cpf.charAt(i) || cpf.charAt(i) < 0 || cpf.charAt(i) > 9){
                digitosVerificador = false;
                break;
            }
        }

        if (digitosVerificador){
            return false;
        }
        //1º digito
        int soma = 0;
        for(int i = 0; i < 10; i++){
            int numero = cpf.charAt(i) - '0';
            soma += numero*(10-i);
        }
        int resto = soma % 11;
        int verificadorPrimeiroNumero;
        if(resto < 2){
            verificadorPrimeiroNumero = 0;
        }
        else{
            verificadorPrimeiroNumero = 11 - resto;
        }

        if(verificadorPrimeiroNumero != cpf.charAt(9) - '0' ){
            return false;
        }

        //2º digito
        soma = 0;
        for(int i = 0; i < 10; i++){
            int numero = cpf.charAt(i) - '0';
            soma += numero*(11-i);
        }
        resto = soma % 11;
        int verificadorSegundoNumero;
        if(resto < 2){
            verificadorSegundoNumero = 0;
        }
        else{
            verificadorSegundoNumero = 11 - resto;
        }

        if(verificadorSegundoNumero != cpf.charAt(10) - '0' ){
            return false;
        }

        return true;

    }
}


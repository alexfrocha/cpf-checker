package me.alexfrocha;

import java.util.InputMismatchException;

public class CPF {

    private final String CPF;
    public CPF(String CPF) {
        this.CPF = CPF;
    }

    public boolean validarCPF() {
        if (this.CPF.equals("00000000000") ||
                this.CPF.equals("11111111111") ||
                this.CPF.equals("22222222222") || this.CPF.equals("33333333333") ||
                this.CPF.equals("44444444444") || this.CPF.equals("55555555555") ||
                this.CPF.equals("66666666666") || this.CPF.equals("77777777777") ||
                this.CPF.equals("88888888888") || this.CPF.equals("99999999999") ||
                (this.CPF.length() != 11)) {
            return false;
        }

        char digito10, digito11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = (int) this.CPF.charAt(i) - 48;
                sm = sm + (num * peso);
                peso -= 1;
            }

            r = 11 - (sm % 11);
            if(r > 9) {
                digito10 = '0';
            } else {
                digito10 = (char)(r + 48);
            }

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int) this.CPF.charAt(i) - 48;
                sm += (num * peso);
                peso -= 1;
            }

            r = 11 - (sm % 11);
            if (r > 9) {
                digito11 = '0';
            } else {
                digito11 = (char)(r + 48);
            }

            if (digito10 == this.CPF.charAt(9) && digito11 == this.CPF.charAt(10)) {
                return true;
            } else {
                return false;
            }

        } catch (InputMismatchException e) {
            return false;
        }
    }

    public String imprimirCPF() {
        return (this.CPF.substring(0, 3) + "." + this.CPF.substring(3, 6) + "." + this.CPF.substring(6, 9) + "-" + this.CPF.substring(9, 11));
    }

}

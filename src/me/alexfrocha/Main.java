package me.alexfrocha;

import me.alexfrocha.exceptions.CampoVazioException;

import javax.swing.*;

public class Main {

//    Inicio o arquivo Main.java declarando o método main junto com a declaração de variáveis e o envio do texto para o
//    Terminal e com requisitando uma informação do usuário e após tudo isso é feita as verificações do CPF informado.

    public static void main(String[] args) {

        try {
            String cpf = JOptionPane.showInputDialog(
                    null,
                    "Informe um CPF: ",
                    "Validador de CPF",
                    JOptionPane.INFORMATION_MESSAGE);


            if(cpf != null) {
                if(cpf.isEmpty()) {
                    throw new CampoVazioException("Campo \"CPF\" vazio");
                }

                if(!cpf.matches("[0-9]+")) {
                    throw new NumberFormatException("É necessário que seja apenas números");
                }

                CPF sistema = new CPF(cpf);
                if(sistema.validarCPF()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "CPF Válido!\nFormatado: " + sistema.imprimirCPF(),
                            "CPF Checado",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "CPF Inválido!",
                            "CPF Checado",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }


        } catch (CampoVazioException | NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ocorreu um erro: \n" + e.getMessage() + ".",
                    "Erro!",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }

}

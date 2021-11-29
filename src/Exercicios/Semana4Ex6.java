package Exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Semana4Ex6 {
    public static void main(String[] args) {
        int idade;
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dataSemFormat = LocalDate.now();

        String dataAtual = dataSemFormat.format(dataFormatada);
        int diaAtual = Integer.parseInt(dataAtual.substring(0, 2));
        int mesAtual = Integer.parseInt(dataAtual.substring(3, 5));
        int anoAtual = Integer.parseInt(dataAtual.substring(6, 10));
        String dataDeNascimento = null;
        do {
            System.out.println("digite sua data de nascimento no formato dd/mm/aaaa");


            dataDeNascimento = scanner.nextLine();
            int diaNasc = Integer.parseInt(dataDeNascimento.substring(0, 2));
            int mesNasc = Integer.parseInt(dataDeNascimento.substring(3, 5));
            int anoNasc = Integer.parseInt(dataDeNascimento.substring(6, 10));

            if (mesAtual > mesNasc || mesAtual == mesNasc && diaAtual >= diaNasc) {
                idade = anoAtual - anoNasc;
                System.out.println("Você já fez aniversário esse ano e sua idade é: " + idade);
            } else {
                idade = anoAtual - anoNasc - 1;
                System.out.println("Você ainda não fez aniversário esse ano e sua idade é: " + idade);
            }
            System.out.println(idade >= 18 ? "Você é maior de idade" : "Você é menor de idade");
        }while (dataDeNascimento !="-1");
    }
}

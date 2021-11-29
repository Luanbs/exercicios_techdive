package Exercicios;


import java.util.Scanner;

public class Semana4Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double resultado = 0;

        System.out.println("Digite o primeiro número da operação");
        double primeiroNumero = Double.parseDouble(scanner.nextLine());
        System.out.println("Digite o segundo número da operação");
        double segundoNumero = Double.parseDouble(scanner.nextLine());
        System.out.println("Digite o número da operação desejada:\n1-Adição\n2-Subtração\n3-Multiplicação\n4-Divisão");
        int operacao = Integer.parseInt(scanner.nextLine());

        switch (operacao){
            case 1:
                resultado = primeiroNumero + segundoNumero;
                break;
            case 2:
                resultado = primeiroNumero - segundoNumero;
                break;
            case 3:
                resultado = primeiroNumero * segundoNumero;
                break;
            case 4:
                resultado = primeiroNumero / segundoNumero;
                break;
            default:
                System.out.println("Operação inválida");
        }

        System.out.println("O resultado da operação é: " + resultado);

    }
}

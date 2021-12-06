package Exercicios;

import java.util.Scanner;

public class Semana4Ex4 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        System.out.println("Digite um numero inteiro para verificar se é par ou impar:");
        int numero = Integer.parseInt(scanner.nextLine());

        System.out.printf("O numero digitado é: %s", numero % 2 == 0 ? "par" : "ímpar");
    }
}

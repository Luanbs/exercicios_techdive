package Exercicios;

import java.util.Scanner;

public class Semana4Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resultado = 1;

        System.out.println("Digite um numero inteiro de 0 a 10 para calcular o fatorial");
        int numero = Integer.parseInt(scanner.nextLine());
        for (int i=1; i<=numero; i++) {
            resultado*=i;
        }
        System.out.printf("O resultado de %d! é: %d ", numero, resultado);


    }
}

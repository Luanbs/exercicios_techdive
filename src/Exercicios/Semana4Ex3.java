package Exercicios;

import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Semana4Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("digite sua altura: ");
        double altura = Double.parseDouble(scanner.nextLine());
        System.out.print("digite seu peso: ");
        double peso = Double.parseDouble(scanner.nextLine());
        System.out.println(peso);
        System.out.println(altura);
        double imc = peso/(altura*altura);

        System.out.printf("Seu imc é: %.2f", imc);
    }
}

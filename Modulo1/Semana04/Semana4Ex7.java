package Exercicios;

import java.util.Scanner;

public class Semana4Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a nota 1");
        double nota1 = Double.parseDouble(scanner.nextLine());
        System.out.println("Digite a nota 2");
        double nota2 = Double.parseDouble(scanner.nextLine());
        System.out.println("Digite a nota 3");
        double nota3 = Double.parseDouble(scanner.nextLine());

        double mediaFinal = (nota1+nota2+nota3)/3 ;
        System.out.printf("Sua média final é %.2f", mediaFinal);
    }
}

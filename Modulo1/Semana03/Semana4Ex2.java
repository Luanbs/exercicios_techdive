package Exercicios;

import java.util.Scanner;

public class Semana4Ex2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu sobrenome");
        String  sobrenome = scanner.nextLine();
        System.out.println("Digite seu nome");
        String nome = scanner.nextLine();

        int tamanhoNome = nome.length() + sobrenome.length();

        System.out.println("Seu nome completo é: " + nome + " " + sobrenome);
        System.out.printf("Seu nome tem %d letras", tamanhoNome);

    }

}

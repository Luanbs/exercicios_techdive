package Exercicios;

import java.util.Scanner;

public class Semana4Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número inteiro inicial:");
        int numeroInicial = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite um número inteiro para ser a raiz");
        int numeroRaiz = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite 1 para progressão aritimética\nDigite 2 para progressão geométrica");
        int escolha = Integer.parseInt(scanner.nextLine());
        System.out.print(numeroInicial + " ");
        if (escolha == 1) {
            for (int i = 1; i < 10; i++) {
                numeroInicial += numeroRaiz;
                System.out.print(numeroInicial + " ");
            }
        }else if (escolha == 2) {
                for (int i = 1; i < 10; i++) {
                    numeroInicial *= numeroRaiz;
                    System.out.print(numeroInicial + " ");
                }
            } else {
                System.out.println("Escolha inválida");
            }
        }
        }


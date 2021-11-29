package Exercicios;

import java.util.Scanner;

public class Semana4Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("digite sua data de nascimento no formato dd/mm/aaaa");

        String dataDeNascimento = scanner.nextLine();
        
        System.out.println("a data de nascimento é:" + dataDeNascimento);
    }
}

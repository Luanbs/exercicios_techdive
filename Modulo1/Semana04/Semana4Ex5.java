package Exercicios;

import java.util.Random;
import java.util.Scanner;

public class Semana4Ex5 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adivinhe qual número de 1 a 5 eu estou pensando:");
        int numero = Integer.parseInt(scanner.nextLine());
        int rand = random.nextInt(5) + 1;

        System.out.println(numero == rand ? "Você acertou!" : "Você errou, o número correto era: " + rand);

    }
}

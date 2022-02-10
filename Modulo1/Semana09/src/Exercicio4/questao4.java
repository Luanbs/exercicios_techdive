package Exercicio4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class questao4 {
    public static void main(String[] args) {
        boolean valido=false;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Eu sei dividir.");
        double r=0;

        while (!valido) {
            try {
                System.out.println("Informe o primeiro valor:");
                int x = teclado.nextInt();
                System.out.println("Informe o segundo valor:");
                int y = teclado.nextInt();
                if (y==0){throw new ArithmeticException();}
                r = (double) x / y;
                valido=true;
            }catch (InputMismatchException e){
                System.out.println("Digite apenas números inteiros");

            }catch (ArithmeticException e){
                System.out.println("O segundo valor não pode ser zero");

            }finally {
                teclado.nextLine();
            }
        }
        System.out.printf("Resultado da divisão: %.2f", r);
    }
}

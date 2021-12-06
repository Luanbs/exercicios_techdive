package Exercicio2;

public class Ex2 {
    public Ex2 (Ex2 y){
        System.out.println("Segundo Construtor");
    }
    public Ex2 (String x){
        System.out.println("primeiro Construtor");
    }

    public static void main(String[] args) {
    Ex2 ex2 = new Ex2(new Ex2("primeiro Construtor"));
    }
}

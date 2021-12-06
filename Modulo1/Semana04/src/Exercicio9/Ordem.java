package Exercicio9;

public class Ordem {
    static {
        System.out.println("dentro do bloco static");
    }

    {
        System.out.println("dentro do bloco de instancia");
    }

    Ordem() {
        System.out.println("dentro do construtor");
    }

    public static void main(String[] args) {
        Ordem inicializacao = new Ordem();
    }
}

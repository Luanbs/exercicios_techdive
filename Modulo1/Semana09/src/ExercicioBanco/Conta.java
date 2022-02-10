package ExercicioBanco;

import java.util.ArrayList;

public class Conta {
    private String nome;
    public static ArrayList<Conta> contas=new ArrayList<>();

    public Conta(String nome) {
        this.nome = nome;
    }

    public static void adiciona(Conta c){contas.add(c);}

    public static int getQuantidadeContas(){return contas.size();}

    public String getNome(){return nome;}
}

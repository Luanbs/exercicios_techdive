package projeto.ferias;

public abstract class Funcionarios {

    String nome;
    String cpf;
    boolean trabalhando;


    public Funcionarios(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.trabalhando=true;
    }

    
}

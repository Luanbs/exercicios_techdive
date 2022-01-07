package projeto.ferias;

import java.util.ArrayList;

public class Turmas {

    private int id;
    private String nomeDaTurma;
    private int quantidadeAlunos;
//    private ArrayList<String> assuntos= new ArrayList<>();
    private String inicioAulas;

    public Turmas(String nomeDaTurma, int quantidadeAlunos, int id) {
        this.nomeDaTurma = nomeDaTurma;
        this.quantidadeAlunos = quantidadeAlunos;
        this.id = id;
    }

//    public void adicionarAssunto(String assunto){
//        this.assuntos.add(assunto);
//    }

    public int getId() {
        return id;
    }

    public String getNomeDaTurma() {
        return nomeDaTurma;
    }

    public int getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public String getInicioAulas() {
        return inicioAulas;
    }


}

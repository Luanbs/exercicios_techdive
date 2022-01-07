package projeto.ferias;

public class Aulas {

    private int semana;
    private String nomeDaTurma;
    private String nomeDoAssunto;
    private String nomeDoDocente1="nenhum";
    private String nomeDoDocente2="nenhum";

    public Aulas(String nomeDaTurma, String nomeDoAssunto, int semana) {
        this.nomeDaTurma = nomeDaTurma;
        this.nomeDoAssunto = nomeDoAssunto;
        this.semana = semana;
    }

    public String getNomeDaTurma() {
        return nomeDaTurma;
    }

    public String getNomeDoAssunto() {
        return nomeDoAssunto;
    }

    public int getSemana(){
        return semana;
    }

    public String getNomeDoDocente1() {
        return nomeDoDocente1;
    }

    public String getNomeDoDocente2() {
        return nomeDoDocente2;
    }

    public void setNomeDoDocente1(String nomeDoDocente1) {
        this.nomeDoDocente1 = nomeDoDocente1;
    }

    public void setNomeDoDocente2(String nomeDoDocente2) {
        this.nomeDoDocente2 = nomeDoDocente2;
    }
}


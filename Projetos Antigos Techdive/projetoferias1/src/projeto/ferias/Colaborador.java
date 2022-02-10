package projeto.ferias;

public class Colaborador {

    private String nome;
    private String cpf;
    private boolean trabalhando=true;
    protected String cargo;



    public Colaborador(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo="Colaborador";
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean isTrabalhando() {
        return trabalhando;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTrabalhando(boolean trabalhando) {
        this.trabalhando = trabalhando;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}

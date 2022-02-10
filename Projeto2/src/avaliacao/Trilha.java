package avaliacao;

import java.util.ArrayList;

public class Trilha {

    Empresa empresa;
    String ocupacao;
    String nome;
    String apelido;
    ArrayList<String> modulos;
    int satisfacao;
    String anotacao;

    public Trilha(Empresa empresa, String ocupacao, ArrayList<String> modulos, int satisfacao, String anotacao) {
        this.empresa = empresa;
        this.ocupacao = ocupacao;
        this.modulos = modulos;
        this.satisfacao = satisfacao;
        this.anotacao = anotacao;
    }
}

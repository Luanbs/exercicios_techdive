package avaliacao;

import java.util.ArrayList;

public class Empresa {
    //true é matriz e false é filial
    private boolean matriz;
    private String nome;
    private String cnpj;
    private String nomeFilial;
    private EnumSeg segmento;
    private String cidade;
    private String estado;
    private String regionalSenai;
    private ArrayList<String> trilhas;

    public Empresa(boolean matriz, String nome, String cnpj, String nomeFilial,
                   EnumSeg segmento, String cidade, String estado, String regionalSenai, String trilha) throws IllegalArgumentException {
        this.matriz = matriz;
        this.nome = nome;
        this.nomeFilial = nomeFilial;
        this.segmento = segmento;
        this.cidade = cidade;
        this.estado = estado;
        this.regionalSenai = regionalSenai;
        trilhas.add(trilha);

        String testeCnpj=cnpj.replaceAll("[0-9]", "X");
        if (testeCnpj.equals("XX.XXX.XXX/XXXX-XX")) {
            this.cnpj = cnpj;
        }else{
            throw new IllegalArgumentException("CNPJ esperado no formato 'XX.XXX.XXX/XXXX-XX'");
        }
    }
}

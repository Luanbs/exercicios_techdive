package projeto.ferias;

import static projeto.ferias.Main.colaboradores;

public class LiderTecnico extends  Colaborador{



    public LiderTecnico(String nome, String cpf) {
        super(nome, cpf);
        super.cargo="Lider Tecnico";
    }

    public void getDetalhes(int escolhaDeColaborador){
        System.out.println( "Nome: "+colaboradores.get(escolhaDeColaborador).getNome()+
                "\nCPF: "+colaboradores.get(escolhaDeColaborador).getCpf()+
                "\nCargo: "+colaboradores.get(escolhaDeColaborador).getCargo());
    }

    public void getTodosFuncionarios(){
        System.out.println("Lista de funcionarios:\n");
        for (int i = 0; i < colaboradores.size(); i++) {
            System.out.println(i + " - " + colaboradores.get(i).getNome());
        }

    }

    public void getTrabalhando(){
        System.out.println("Lista de funcionarios trabalhando:\n");
        for (int i = 0; i < colaboradores.size(); i++) {
            if(colaboradores.get(i).isTrabalhando()){
            System.out.println(i + " - " + colaboradores.get(i).getNome());
        }

    }}

    public void getDemitidos(){
        System.out.println("Lista de funcionarios: demitidos\n");
        for (int i = 0; i < colaboradores.size(); i++) {
            if(!colaboradores.get(i).isTrabalhando()){
            System.out.println(i + " - " + colaboradores.get(i).getNome());
        }}

    }
}

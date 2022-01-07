package projeto.ferias;

import java.util.Scanner;

import static projeto.ferias.Main.colaboradores;

public class GerenteDepartamento extends LiderTecnico{


    Scanner scanner = new Scanner(System.in);
    public GerenteDepartamento(String nome, String cpf) {
        super(nome, cpf);
        super.cargo="Gerente de Departamento";
    }

    public void atualizarInformacao(int escolhaDeColaborador, int escolhaDeAlteracao) {
        if(escolhaDeAlteracao==1){
            System.out.println("Digite o novo nome para ser alterado");
            String novoNome = scanner.nextLine();

            colaboradores.get(escolhaDeColaborador).setNome(novoNome);
            System.out.println("Nome alterado com sucesso!\n");


        }else if(escolhaDeAlteracao==2){
            System.out.println("Digite o novo cargo do funcionario");
            String novoCargo = scanner.nextLine();

            colaboradores.get(escolhaDeColaborador).setCargo(novoCargo);
            System.out.println("Cargo alterado com sucesso!\n");

        }
    }
}

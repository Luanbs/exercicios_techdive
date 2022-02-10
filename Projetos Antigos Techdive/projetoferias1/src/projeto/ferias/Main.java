package projeto.ferias;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Colaborador> colaboradores = new <Colaborador>ArrayList();

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int id=0;

        int selecaoUsuario;
        do {
            System.out.println("""
                    Digite o número da operação desejada:
                            
                    1 - Adicionar funcionário
                    2 - Ver detalhes de um funcionário
                    3 - Demitir funcionário (Neste caso o funcionário não deverá ser apagado)
                    4 - Atualizar informações de um funcionário
                    5 - Listar todos os funcionários
                    6 - Listar somente os funcionários trabalhando
                    7 - Listar somente os funcionários demitidos 
                    8 - Sair""");
            selecaoUsuario = scanner.nextInt();


            switch (selecaoUsuario) {
                //adicionar funcionarios
                case 1:
                    boolean cpfValido = false;
                    String cpf = null;

                    System.out.println("Digite o nome do funcionario");
                    scanner.nextLine();
                    String nome = scanner.nextLine();

                    while (!cpfValido) {
                        System.out.println("Digite o cpf do funcionario");
                        cpf = scanner.nextLine();
                        cpf = cpf.replaceAll("[^0-9]", "");

                        for (int i=0; i<colaboradores.size(); i++){
                            if(cpf.equals(colaboradores.get(i).getCpf())){
                                System.out.println("Este cpf já está cadastrado.");
                                cpf="0";
                            }
                        }

                        if (cpf.length() == 11) {
                            cpfValido = true;
                        } else {
                            System.out.println("Cpf informado não é válido. Tente novamente.");
                            Thread.sleep(1500);
                        }
                    }

                    System.out.println("""
                            Digite qual o cargo do funcionario:
                            1 - Colaborador
                            2 - Lider Tecnico
                            3 - Gerente de Departamento
                            4 - Gerente Geral""");

                    int selecaoCargo = scanner.nextInt();

                    switch (selecaoCargo) {
                        case 1:
                            colaboradores.add(new Colaborador(nome, cpf));
                            break;
                        case 2:
                            colaboradores.add(new LiderTecnico(nome, cpf));
                            break;
                        case 3:
                            colaboradores.add(new GerenteDepartamento(nome, cpf));
                            break;
                        case 4:
                            colaboradores.add(new GerenteGeral(nome, cpf));
                            break;
                        default:
                            System.out.println("Escolha inválida.");
                            break;

                    }
                    System.out.println("Funcionário adicionado com sucesso!");
                    Thread.sleep(1500);

                    break;

                //Ver detalhes de um funcionario
                case 2:
                    System.out.println("Digite seu cpf");
                    scanner.nextLine();
                    String cpfColaborador = scanner.nextLine();
                    boolean permissao=false;

                    for (int i=0; i<colaboradores.size(); i++){
                        if(cpfColaborador.equals(colaboradores.get(i).getCpf()) && colaboradores.get(i) instanceof LiderTecnico){
                            permissao=true;
                            id=i;
                        }
                    }

                    if (permissao){
                        System.out.println("Selecione um funcionario da lista abaixo");
                        for (int i=0; i<colaboradores.size(); i++){
                            System.out.println(i+" - "+colaboradores.get(i).getNome());
                        }
                        int escolhaDeColaborador = scanner.nextInt();

                        ((LiderTecnico) colaboradores.get(id)).getDetalhes(escolhaDeColaborador);

                        Thread.sleep(1500);
                    }else{
                        System.out.println("Só lideres tecnicos e gerentes tem permissao a esta operação.");
                        Thread.sleep(1500);
                    }


                    break;

                //Demitir funcionario
                case 3:

                    System.out.println("Digite seu cpf");
                    scanner.nextLine();
                    cpfColaborador = scanner.nextLine();
                    permissao=false;

                    for (int i=0; i<colaboradores.size(); i++) {
                        if (cpfColaborador.equals(colaboradores.get(i).getCpf()) && colaboradores.get(i) instanceof GerenteGeral) {
                            permissao = true;
                            id=i;
                        }
                    }

                    if (permissao) {
                        System.out.println("Selecione um funcionario da lista abaixo");
                        for (int i = 0; i < colaboradores.size(); i++) {
                            System.out.println(i + " - " + colaboradores.get(i).getNome());
                        }
                        int escolhaDeColaborador = scanner.nextInt();

                        ((GerenteGeral) colaboradores.get(id)).demitir(escolhaDeColaborador);

                        Thread.sleep(1500);
                    }else{
                        System.out.println("Apenas Gerente geral tem permissao a essa operação.");
                        Thread.sleep(1500);
                    }

                    break;

                //Atualizar informações de um funcionário
                case 4:

                    System.out.println("Digite seu cpf");
                    scanner.nextLine();
                    cpfColaborador = scanner.nextLine();
                    permissao=false;

                    for (int i=0; i<colaboradores.size(); i++) {
                        if (cpfColaborador.equals(colaboradores.get(i).getCpf()) && colaboradores.get(i) instanceof GerenteDepartamento) {
                            permissao = true;
                            id=i;
                        }
                    }

                    if (permissao) {
                        System.out.println("Selecione um funcionario da lista abaixo");
                        for (int i = 0; i < colaboradores.size(); i++) {
                            System.out.println(i + " - " + colaboradores.get(i).getNome());
                        }
                        int escolhaDeColaborador = scanner.nextInt();

                        System.out.println("Qual operação você deseja?\n1 - Alterar nome do funcionario" +
                                "\n2 - Alterar cargo do funcionario");

                        int escolhaDeAlteracao = scanner.nextInt();

                        ((GerenteDepartamento) colaboradores.get(id)).atualizarInformacao(escolhaDeColaborador, escolhaDeAlteracao);
                        Thread.sleep(1500);
                    }else{
                        System.out.println("Apenas Gerentes tem permissão a essa operação.\n");
                        Thread.sleep(1500);
                    }


                    break;

                //Listar todos os funcionários
                case 5:

                    System.out.println("Digite seu cpf");
                    scanner.nextLine();
                    cpfColaborador = scanner.nextLine();
                    permissao=false;

                    for (int i=0; i<colaboradores.size(); i++) {
                        if (cpfColaborador.equals(colaboradores.get(i).getCpf()) && colaboradores.get(i) instanceof LiderTecnico) {
                            permissao = true;
                            id=i;
                        }
                    }

                    if (permissao) {
                        ((LiderTecnico)colaboradores.get(id)).getTodosFuncionarios();

                        Thread.sleep(1500);
                    } else{
                        System.out.println("Apenas gerentes e lideres tecnicos tem permissao a essa operação.");
                        Thread.sleep(1500);
                    }

                    break;

                //Listar somente os funcionários trabalhando
                case 6:
                    System.out.println("Digite seu cpf");
                    scanner.nextLine();
                    cpfColaborador = scanner.nextLine();
                    permissao=false;

                    for (int i=0; i<colaboradores.size(); i++) {
                        if (cpfColaborador.equals(colaboradores.get(i).getCpf()) && colaboradores.get(i) instanceof LiderTecnico) {
                            permissao = true;
                            id=i;
                        }
                    }

                    if (permissao) {

                        ((LiderTecnico) colaboradores.get(id)).getTrabalhando();
                        Thread.sleep(1500);
                    }else{
                        System.out.println("Apenas gerentes e lideres tecnicos tem permissao a essa operação.");
                        Thread.sleep(1500);
                    }

                    break;

                //Listar somente os funcionários demitidos
                case 7:
                    System.out.println("Digite seu cpf");
                    scanner.nextLine();
                    cpfColaborador = scanner.nextLine();
                    permissao=false;

                    for (int i=0; i<colaboradores.size(); i++) {
                        if (cpfColaborador.equals(colaboradores.get(i).getCpf()) && colaboradores.get(i) instanceof LiderTecnico) {
                            permissao = true;
                            id=i;
                        }
                    }

                    if (permissao) {

                        ((LiderTecnico) colaboradores.get(id)).getDemitidos();
                        Thread.sleep(1500);
                    }else{
                        System.out.println("Apenas gerentes e lideres tecnicos tem permissao a essa operação.");
                        Thread.sleep(1500);
                    }

                    break;

                default:
                    break;
            }
    } while(selecaoUsuario!=8);
}
}

package projeto.ferias;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    public static ArrayList<Turmas> turmas = new ArrayList<>();
    public static ArrayList<Docentes> docentes = new ArrayList<>();
    public static ArrayList<Aulas> aulas = new ArrayList<>();
    public static void main(String[] args) {
        int countTurmas=0;
        int countDocentes=0;
        Scanner scanner = new Scanner(System.in);
        boolean continuarPrograma=true;


        while(continuarPrograma){
        System.out.println("""
                Escolha a opção desejada:
                1- Cadastrar turma
                2- Cadastrar docentes
                3- Definir docentes para uma determinada turma
                4- Listar turmas com seus respectivos assuntos, docentes e semanas
                5- Listar todos os docentes
                6- Listar um docente e suas semanas de aula já definidas
                7- Sair""");

        int escolhaUsuario = scanner.nextInt();
        switch (escolhaUsuario){
            //cadastrar turma
            case 1:
                boolean valido=false;
                int countAssuntos=1;
                int quantidadeAlunos=0;

                System.out.println("Digite o nome da Turma que deseja cadastrar.");
                scanner.nextLine();
                String nomeTurma = scanner.nextLine();

                while(!valido) {
                    System.out.println("Digite a quantidade de alunos");
                    quantidadeAlunos = scanner.nextInt();

                    if (quantidadeAlunos>0 && quantidadeAlunos<=60){
                        valido=true;
                    }else{
                        System.out.println("Digite um número entre 1 e 60");
                    }
                }
                turmas.add(new Turmas(nomeTurma, quantidadeAlunos, countTurmas));
                scanner.nextLine();
                while(countAssuntos<=52) {
                    System.out.println("Digite o nome do assunto da semana " +countAssuntos+" ou digite 'sair'");
                    String nomeAssunto = scanner.nextLine();
                    if(!nomeAssunto.equals("sair")) {
                        aulas.add(new Aulas(nomeTurma, nomeAssunto, countAssuntos));
                    }else{
                        break;
                    }
                    countAssuntos++;
                }

                countTurmas++;
                System.out.println("Turma cadastrada com sucesso.");
                break;

            //cadastrar docentes
            case 2:
                System.out.println("Digite o nome do docente que deseja cadastrar.");
                scanner.nextLine();
                String nomeDocente = scanner.nextLine();

                docentes.add(new Docentes(nomeDocente, countDocentes));

                System.out.println("Docente cadastrado com sucesso.");

                countDocentes++;
                break;

            //definir docentes para uma determinada turma
            case 3:

                valido=false;
                int selecaoTurma=0;
                int selecaoAssunto=0;
                int selecaoDocente1=0;
                int selecaoDocente2=0;
                int selecaoQuantidadeDocentes=0;
                int contagemAssuntos=0;


                System.out.println("Selecione o id da turma que deseja adicionar o(s) docente(s):");

                for (int i=0; i<turmas.size(); i++){
                    System.out.println("id: "+turmas.get(i).getId()+"--Nome: "+
                            turmas.get(i).getNomeDaTurma()+"--Quantidade de alunos: "+
                            turmas.get(i).getQuantidadeAlunos());
                }
                while (!valido) {
                    selecaoTurma = scanner.nextInt();

                    if (selecaoTurma>=0 && selecaoTurma<turmas.size()){
                        valido=true;
                    }else{
                        System.out.println("Seleção inválida. Por favor, escolha uma turma válida.");
                    }
                }

                valido=false;

                System.out.println("(Digite apenas números) Escolha a semana do assunto para cadastrar o docente:");

                for (int i=0; i<aulas.size(); i++){
                    if (aulas.get(i).getNomeDaTurma().equals(turmas.get(selecaoTurma).getNomeDaTurma())){
                        System.out.println("Semana: "+aulas.get(i).getSemana()+
                                " Assunto: "+aulas.get(i).getNomeDoAssunto());
                        contagemAssuntos++;
                    }
                }

                while (!valido) {
                    selecaoAssunto = scanner.nextInt();
                    if (selecaoAssunto>=0 && selecaoAssunto<=contagemAssuntos){
                        valido=true;
                    }else{
                        System.out.println("Seleção inválida. Por favor, escolha uma semana válida.");
                    }
                }

                valido=false;

                while (!valido) {
                    System.out.println("(Digite apenas números) 1 ou 2 professores serão cadastrados essa semana?");
                    selecaoQuantidadeDocentes = scanner.nextInt();

                    if (selecaoQuantidadeDocentes==1 || selecaoQuantidadeDocentes==2){
                        valido=true;
                    }else{
                        System.out.println("Digite apenas o número '1' ou '2'");
                    }
                }

                System.out.println("Lista de docentes:");

                for (int i=0; i<docentes.size(); i++){
                    System.out.println("id: "+docentes.get(i).getId()+" --- "+docentes.get(i).getNomeDocente());
                }

                if (selecaoQuantidadeDocentes==1) {
                    valido=false;
                    while (!valido) {

                        System.out.println("Selecione o docente pelo id");
                        selecaoDocente1 = scanner.nextInt();
                        if (selecaoDocente1>=0 && selecaoDocente1<docentes.size()){
                            valido=true;
                        }else {
                            System.out.println("Escolha inválida.");
                        }
                    }
                    for (int i=0; i<aulas.size(); i++) {
                        if(aulas.get(i).getSemana()==selecaoAssunto && aulas.get(i).getNomeDaTurma().equals(turmas.get(selecaoTurma).getNomeDaTurma())){
                            if (docentes.get(selecaoDocente1).verificarDiasAulas(selecaoAssunto, "completo")) {
                                aulas.get(i).setNomeDoDocente1(docentes.get(selecaoDocente1).getNomeDocente());
                                docentes.get(selecaoDocente1).alterarDiasAulas(selecaoAssunto, "completo");

                                System.out.println("Docente cadastrado com sucesso");
                            }else{
                                System.out.println("Docente não pode ser cadastrado por conflito de horário.");
                            }
                        }
                    }


                }else {
                    valido=false;

                    while (!valido) {

                        System.out.println("Selecione o primeiro docente pelo id");
                        selecaoDocente1 = scanner.nextInt();
                        System.out.println("Selecione o segundo docente pelo id");
                        selecaoDocente2 = scanner.nextInt();
                        if (selecaoDocente1>=0 && selecaoDocente1<docentes.size()&&
                        selecaoDocente2>=0 && selecaoDocente2<docentes.size()){
                            valido=true;
                        }else {
                            System.out.println("Escolha inválida.");
                        }
                    }
                    for (int i = 0; i < aulas.size(); i++) {
                        if (aulas.get(i).getSemana() == selecaoAssunto && aulas.get(i).getNomeDaTurma().equals(turmas.get(selecaoTurma).getNomeDaTurma())) {
                            if (docentes.get(selecaoDocente1).verificarDiasAulas(selecaoAssunto, "SeT") && docentes.get(selecaoDocente2).verificarDiasAulas(selecaoAssunto, "QQeS")) {
                                aulas.get(i).setNomeDoDocente1(docentes.get(selecaoDocente1).getNomeDocente());
                                aulas.get(i).setNomeDoDocente2(docentes.get(selecaoDocente2).getNomeDocente());
                                docentes.get(selecaoDocente1).alterarDiasAulas(selecaoAssunto, "SeT");
                                docentes.get(selecaoDocente2).alterarDiasAulas(selecaoAssunto, "QQeS");
                                System.out.println("Docentes cadastrados com sucesso");
                            }else{
                                System.out.println("Docente não pode ser cadastrado por conflito de horário.");
                            }

                        }
                    }
                }
                break;

            //listar turmas com seus respectivos assuntos, docentes e semanas
            case 4:
                selecaoTurma=0;
                valido=false;

                System.out.println("Escolha qual turma desejas consultar:");
                for (int i=0; i<turmas.size(); i++){
                    System.out.println("id: "+turmas.get(i).getId()+"--Nome: "+
                            turmas.get(i).getNomeDaTurma()+"--Quantidade de alunos: "+
                            turmas.get(i).getQuantidadeAlunos());
                }
                while (!valido){
                selecaoTurma = scanner.nextInt();
                if (selecaoTurma>=0 && selecaoTurma<turmas.size()) {
                    valido=true;
                }}

                for (int i=0; i<aulas.size(); i++){
                if (aulas.get(i).getNomeDaTurma().equals(turmas.get(selecaoTurma).getNomeDaTurma()));
                    System.out.println("Semana: "+aulas.get(i).getSemana()+
                            " Assunto: "+aulas.get(i).getNomeDoAssunto()+
                            " Docente 1: "+aulas.get(i).getNomeDoDocente1()+
                            " Docente 2: "+aulas.get(i).getNomeDoDocente2());
                }

                break;

            //listar todos os docentes
            case 5:
                System.out.println("Lista de docentes cadastrados:");
                for (int i=0; i<docentes.size(); i++){
                    System.out.println("id: "+docentes.get(i).getId()+" --- Nome: "+docentes.get(i).getNomeDocente());
                }
                break;

            //listar um docente e suas semanas de aula já definidas
            case 6:
                valido=false;
                int selecaoDocente=0;

                System.out.println("Selecione um docente da lista:");
                for (int i=0; i<docentes.size(); i++){
                    System.out.println("id: "+docentes.get(i).getId()+" --- "+docentes.get(i).getNomeDocente());
                }
                while (!valido) {
                    selecaoDocente = scanner.nextInt();
                    if (selecaoDocente>=0 && selecaoDocente<docentes.size()){
                        valido=true;
                    }else {
                        System.out.println("Escolha inválida.");
                    }
                }
                System.out.println("Abaixo as aulas do docente: "+docentes.get(selecaoDocente).getNomeDocente()+
                        "\nLegenda:'SeT' - Aulas segunda e terça - 'QQeS' - Aulas quarta, quinta e sexta.");
                for (int i=0; i<aulas.size(); i++) {
                    if (aulas.get(i).getNomeDoDocente1().equals(docentes.get(selecaoDocente).getNomeDocente())
                            ||aulas.get(i).getNomeDoDocente2().equals(docentes.get(selecaoDocente).getNomeDocente())){

                        System.out.println("Semana: "+aulas.get(i).getSemana()+
                                " Assunto: "+aulas.get(i).getNomeDoAssunto()+
                                " Dias da semana: "+docentes.get(selecaoDocente).getDiasAulas(aulas.get(i).getSemana()));
                }}
                break;

            //sair
            case 7:
                continuarPrograma=false;
                break;

            default:
                System.out.println("Escolha incorreta.");
                break;


        }

    }
}}

package HotelInHouse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hotel {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Hospede> hospedes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continuar=true;



        while (continuar){
            int selecaoOpcao=0;
            int selecaoHospede=0;
            boolean valido=false;

            System.out.println("""
                    Digite o número da opção desejada:
                    1-Cadastrar hospede
                    2-Fazer reservas
                    3-Conferir reservas
                    4-Cancelar reservas
                    5-Sair""");

            while(!valido) {
                try {
                    selecaoOpcao = scanner.nextInt();
                    if (selecaoOpcao<1 || selecaoOpcao>5){
                        System.out.println("Opção inválida. Digite novamente.");
                    }else{
                        valido=true;
                    }
                }catch(InputMismatchException e){
                    System.out.println("Escolha inválida.\nDigite apenas números inteiros.");
                    scanner.nextLine();
                }
            }

            scanner.nextLine();
            switch (selecaoOpcao) {

                case 1:
                    int selecaoTipoQuarto = 0;
                    String selecaoNome="";
                    String selecaoCpfOuRg;
                    String selecaoDataNascimento;
                    String tipoQuarto = null;
                    System.out.println("""
                            ------------------------------------------------------------------
                            Nota: Pode-se cadastrar apenas clientes entre 15-110 anos de idade
                            ------------------------------------------------------------------""");
                    System.out.println("Digite o nome:");
                    selecaoNome = scanner.nextLine();


                    System.out.println("Digite o Cpf ou Rg:");
                    selecaoCpfOuRg = scanner.nextLine();

                    System.out.println("Digite a data de nascimento no formato xx/xx/xxxx.");
                    selecaoDataNascimento = scanner.nextLine();

                    valido=false;
                    while (!valido) {
                        System.out.println("Selecione o tipo de quarto:\n" +
                                "1 - Quarto simples (R$90 baixa temporada, R$140 alta temporada)\n" +
                                "2 - Quarto luxo (R$150 baixa temporada, R$400 alta temporada)\n");
                        try {
                            selecaoTipoQuarto = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Digite apenas valores numéricos inteiros.");
                            Thread.sleep(2000);
                            scanner.nextLine();
                            continue;
                        }

                        if (selecaoTipoQuarto == 1) {
                        tipoQuarto="SIMPLES";
                            valido = true;
                        } else if (selecaoTipoQuarto == 2) {
                        tipoQuarto="LUXO";
                            valido = true;
                        }else{
                            System.out.println("Selecione uma opção válida.");
                        }
                    }

                    try {
                        hospedes.add(new Hospede(selecaoNome, selecaoCpfOuRg, selecaoDataNascimento, tipoQuarto));
                    } catch (IllegalArgumentException e) {
                        System.err.println(e);
                        System.out.println("Crie o usuário novamente.");
                    }

                    break;

                case 2:
                    String selecaoDataReserva;
                    LocalDate dataReserva = null;
                    int diasReserva=0;
                    Hospede hospedeReservando;

                    if(hospedes.isEmpty()){
                        System.out.println("Nenhum hóspede cadastrado no sistema ainda.");
                        break;
                    }

                    System.out.println("""
                            -------------------------------------------------------------------
                            Nota:Reservas só serão feitas com no máximo 60 dias de antecedência.
                            -------------------------------------------------------------------
                            Nota:Reservas poderão ser canceladas a qualquer momento sem custo.
                            -------------------------------------------------------------------""");
                    Thread.sleep(1200);

                    System.out.println("Escolha o hospede abaixo pelo id:");

                    //Lista dos hospedes
                    for (int i=0; i<hospedes.size(); i++){
                        System.out.println("id: "+i+" hóspede: "+hospedes.get(i).getNome());
                    }

                    valido=false;
                    while (!valido) {
                        try {
                            selecaoHospede = scanner.nextInt();
                            if (selecaoHospede<hospedes.size() && selecaoHospede>=0){
                                valido=true;
                            }else{
                                System.out.println("Opção inválida. Digite novamente.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Digite apenas valores numéricos inteiros.");
                            scanner.nextLine();
                        }
                    }
                    scanner.nextLine();

                    hospedeReservando=hospedes.get(selecaoHospede);

                    System.out.println("Seu tipo de quarto é: "+hospedeReservando.getTipoQuarto());

                    valido=false;
                    while (!valido) {
                        System.out.println("Digite o dia que deseja fazer sua reserva no formato 'xx/xx/xxxx'.");
                        selecaoDataReserva = scanner.nextLine();
                        try {
                            dataReserva = Quarto.conferirData(selecaoDataReserva);
                            valido=true;
                        } catch (IllegalArgumentException e){
                            System.err.println(e);
                            System.out.println("Digite novamente");
                        }
                    }
                    valido=false;
                    while (!valido){
                        try{
                            System.out.println("Digite o número de dias que deseja fazer a reserva:");
                            diasReserva=scanner.nextInt();
                            if (diasReserva>0 && diasReserva<=30){
                                valido=true;
                            }else{
                                System.out.println("Digite um numero entre 1 e 30");
                            }
                        }catch (InputMismatchException e){
                            System.err.println(e);
                            System.out.println("Digite apenas números inteiros");
                        }
                    }
                    double custo=Quarto.custo(dataReserva, hospedeReservando.getTipoQuarto());
                    System.out.printf("O custo do seu quarto por dia é: %.2f%n", custo);
                    System.out.printf("O custo total contabilizando os dias será de: %.2f%n", custo*diasReserva);
                    System.out.println("Deseja continuar com a reserva?\n1-Sim\n2-Não");

                    valido=false;
                    while (!valido) {
                    try {
                        selecaoOpcao= scanner.nextInt();
                    }catch (InputMismatchException e){
                        System.out.println("Digite apenas valores inteiros.");
                        scanner.nextLine();
                    }
                    if (selecaoOpcao == 1 || selecaoOpcao==2){
                            valido=true;
                        }else{
                            System.out.println("Escolha um valor válido");
                        }
                    }
                    if (selecaoOpcao==2){
                        break;
                    }

                    Quarto.fazerReserva(dataReserva, hospedeReservando.getTipoQuarto(), diasReserva, hospedeReservando.getNome());

                    break;


                case 3:
                    Quarto.mostrarReservas();
                    break;

                case 4:

                    System.out.println("Escolha o hóspede abaixo:");
                    for (int i=0; i<hospedes.size(); i++){
                        System.out.println("Id: "+i+" Nome: "+hospedes.get(i).getNome());
                    }
                    selecaoHospede=scanner.nextInt();

                    System.out.println("Cancelar a reserva não há custos adicionais.\n" +
                            "Você tem certeza que deseja cancelar todas as reservas feitas?\n" +
                            "1-Sim\n" +
                            "2-Sair");

                    valido=false;
                    while (!valido) {
                        try {
                            selecaoOpcao = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Digite apenas valores inteiros.");
                        }

                        if (selecaoOpcao != 2 && selecaoOpcao != 1) {
                            System.out.println("Escolha um valor válido.");
                        }else{
                            valido=true;
                        }
                    }
                    if (selecaoOpcao==2){break;}



                    Quarto.cancelarReserva(hospedes.get(selecaoHospede).getNome(),hospedes.get(selecaoHospede).getTipoQuarto());
                    break;

                case 5:
                    continuar=false;
                    break;
                default:
                    ;
            }

        }
        scanner.close();
        System.out.println("Programa finalizado com sucesso.");
    }
}

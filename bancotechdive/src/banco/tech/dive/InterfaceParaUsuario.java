package banco.tech.dive;

import java.util.ArrayList;
import java.util.Scanner;


//Avisos:
//Todos os scanners "Double.parseDouble" possuem o método replace(",",".") para não dar erro se o usuário usar vírgula.
//a
//a
//a
//a

public class InterfaceParaUsuario {


    public static void main(String[] args) {
        //Declarando variáveis
        Scanner scanner = new Scanner(System.in);
        boolean continuarAplicacao=true;
        int numeroContaUsuario;
        int numeroContaDestino;
        int contaId=0;


        System.out.println("Bem vindo ao banco Tech Dive");

        //Do-while da aplicação
        do{

        System.out.println("Selecione o número correspondente da operação desejada:");
        System.out.println("""
                1-Criar conta
                2-Saldo da conta
                3-Extrato da conta
                4-Transferencias
                5-Saque
                6-Deposito
                404-Fechar a aplicação""");
        int opcaoUsuario = scanner.nextInt();

        switch (opcaoUsuario){

            //cria a conta do usuário:

            case 1:

            //Declarando variáveis para validação de cpf e agência
            boolean cpfValido=false;
            String cpf = null;
            String agencia="000";
            int escolhaDeConta;
            contaId++;

            System.out.println("Digite seu nome");
            scanner.nextLine();
            String nome = scanner.nextLine();

            //validando cpf utilizando metodo replace (usuário pode digitar pontos e traços pois os mesmos serão apagados)
            while (!cpfValido) {
                System.out.println("Digite seu cpf");
                cpf = scanner.nextLine();
                cpf=cpf.replaceAll("[^0-9]", "");

                if (cpf.length()==11){
                    cpfValido=true;
                }else{
                    System.out.println("Cpf informado não é válido. Tente novamente.");
                }
            }

            System.out.println("Digite sua renda mensal");
            double rendaMensal = Double.parseDouble(scanner.nextLine().replace(",","."));

            //validando agencia
            while(!(agencia.equals("001") || agencia.equals("002"))) {
                System.out.println("Digite o número correspondente a sua agência:\n001-Florianópolis\n002-São José");
                agencia = scanner.nextLine();
                if (!(agencia.equals("001") || agencia.equals("002"))){
                    System.out.println("Agência inválida. Tente novamente.");
                }

            }

            do{
            System.out.println("Escolha o tipo de conta:\n1-Conta corrente\n2-Conta poupança\n3-Conta investimento");
            escolhaDeConta = scanner.nextInt();

                switch (escolhaDeConta) {
                    case 1 -> Conta.conta.add(new ContaCorrente(nome, cpf, rendaMensal, agencia, contaId));
                    case 2 -> Conta.conta.add(new ContaPoupanca(nome, cpf, rendaMensal, agencia, contaId));
                    case 3 -> Conta.conta.add(new ContaInvestimento(nome, cpf, rendaMensal, agencia, contaId));
                    default -> System.out.println("Escolha inválida. Tente novamente.");

                }}while(escolhaDeConta>3 || escolhaDeConta<1);

            System.out.println("O número da sua conta é " + contaId);
            break;

            //conferir saldo:

            case 2:
                try {
                    scanner.nextLine();
                    System.out.println("Digite o numero da sua conta");
                    numeroContaUsuario = scanner.nextInt();
                    numeroContaUsuario-=1;
                    System.out.printf("O saldo da sua conta é: %.2f%n", Conta.conta.get(numeroContaUsuario).getSaldo());
                } catch (Exception e){
                    System.out.println("Conta inválida.");
                    break;
                }
                break;

            //conferir extrato:

            case 3:
                try {
                    scanner.nextLine();
                    System.out.println("Digite o numero da sua conta");
                    numeroContaUsuario = scanner.nextInt();
                    numeroContaUsuario-=1;
                } catch (Exception e) {
                    System.out.println("Conta inválida.");
                    break;
                }
                break;

            //fazer transferencias:

            case 4:
                try {
                    scanner.nextLine();
                    System.out.println("Digite o numero da sua conta:");
                    numeroContaUsuario = scanner.nextInt();
                    numeroContaUsuario-=1;

                    scanner.nextLine();
                    System.out.println("Digite o numero da conta destino:");
                    numeroContaDestino = scanner.nextInt();
                    numeroContaDestino-=1;
                } catch (Exception e) {
                    System.out.println("Conta inválida.");
                    break;
                }
                    System.out.println("Digite a quantidade que deseja transferir:");
                    scanner.nextLine();
                    double quantidadeTransferencia = Double.parseDouble(scanner.nextLine().replace(",","."));
                    Conta.conta.get(numeroContaUsuario).transferir(quantidadeTransferencia, numeroContaDestino);


                    break;


            //fazer saque:

            case 5:
                try {
                    System.out.println("Digite o numero da sua conta");
                    numeroContaUsuario = scanner.nextInt();
                    numeroContaUsuario-=1;

                    System.out.println("Digite a quantidade que desejas sacar:");
                    scanner.nextLine();
                    double quantidadeSaque = Double.parseDouble(scanner.nextLine().replace(",","."));
                    Conta.conta.get(numeroContaUsuario).saque(quantidadeSaque);
                } catch (Exception e) {
                    System.out.println("Conta inválida.");
                    break;
                }
                break;


            //fazer deposito:

            case 6:
                try {
                    scanner.nextLine();
                    System.out.println("Digite o numero da sua conta");
                    numeroContaUsuario = scanner.nextInt();
                    numeroContaUsuario-=1;

                    System.out.println("Digite a quantidade que desejas depositar:");
                    scanner.nextLine();
                    double quantidadeDeposito = Double.parseDouble(scanner.nextLine().replace(",","."));
                    Conta.conta.get(numeroContaUsuario).deposito(quantidadeDeposito);

                } catch (Exception e) {
                    System.out.println("Conta inválida.");
                    break;
                }
                break;

            //alterar cadastro:

            case 7 :

                break;

            case 404:
                continuarAplicacao=false;
                break;

            default:
                System.out.println("Operação inválida.\nDigite um número de operação válido.");
    }
        }while (continuarAplicacao);

        System.out.println("Aplicação finalizada com sucesso.");
}
}

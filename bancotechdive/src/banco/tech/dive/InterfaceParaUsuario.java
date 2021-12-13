package banco.tech.dive;

import java.util.ArrayList;
import java.util.Scanner;


//Avisos:
//Todos os scanners "Double.parseDouble" possuem o método replace(",",".") para não dar erro se o usuário usar vírgula.
//É botado "scanner.nextline();" antes das variaveis que recebem o input pois está dando erro e pulando alguns scanners.
//a
//a
//a

public class InterfaceParaUsuario {


    public static void main(String[] args) throws InterruptedException {
        //Declarando variáveis
        Scanner scanner = new Scanner(System.in);
        boolean continuarAplicacao=true;
        int numeroContaUsuario;
        int numeroContaDestino;
        int contaId=0;


        System.out.println("Bem vindo ao banco Tech Dive");

        //Do-while da aplicação
        do{
        Thread.sleep(1500);
        System.out.println("Selecione o número correspondente da operação desejada:");
        System.out.println("""
                1-Criar conta
                2-Saldo da conta
                3-Extrato da conta
                4-Transferencias
                5-Saque
                6-Deposito
                7-Alterar Cadastro
                8-Simulação de rendimento (conta poupança)
                123 - relatorios do banco
                404-Fechar a aplicação""");
            System.out.println("---------------------------------------------------------------");
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

            System.out.printf("Seja bem vindo ao banco techdive, %s!\nO número da sua conta é %d%n", Conta.conta.get(contaId-1).getNome(), contaId);
            System.out.println("---------------------------------------------------------------");
            break;

            //conferir saldo:

            case 2:
                try {
                    scanner.nextLine();
                    System.out.println("Digite o numero da sua conta");
                    numeroContaUsuario = scanner.nextInt();
                    numeroContaUsuario-=1;
                    System.out.printf("O saldo da sua conta é: %.2f%n", Conta.conta.get(numeroContaUsuario).getSaldo());
                    System.out.println("---------------------------------------------------------------");
                } catch (Exception e){
                    System.out.println("Conta inválida.");
                    System.out.println("---------------------------------------------------------------");
                    break;
                }
                break;

            //conferir extrato:

            case 3:
                try {
                    scanner.nextLine();
                    System.out.println("Digite o numero da sua conta");
                    numeroContaUsuario = scanner.nextInt();

                    for (int i = 0; i < Transacoes.transacoes.size(); i++) {

                        if (Transacoes.transacoes.get(i).contaId1==(numeroContaUsuario)) {
                            Transacoes.transacoes.get(i).getExtrato();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Conta inválida.");
                    System.out.println("---------------------------------------------------------------");
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
                    if (Conta.conta.get(numeroContaDestino).getContaId()>contaId ||
                            Conta.conta.get(numeroContaDestino).getContaId()<0 || numeroContaDestino==numeroContaUsuario){
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Conta inválida.");
                    System.out.println("---------------------------------------------------------------");
                    break;
                }
                    System.out.println("Digite a quantidade que deseja transferir:");
                    scanner.nextLine();
                    double quantidadeTransferencia = Double.parseDouble(scanner.nextLine().replace(",","."));
                    Conta.conta.get(numeroContaUsuario).transferir(quantidadeTransferencia, numeroContaDestino);

                    Transacoes.transacoes.add(new Transacoes(Conta.conta.get(numeroContaUsuario).getContaId(),
                                    Conta.conta.get(numeroContaDestino).getContaId(),
                                    Conta.conta.get(numeroContaUsuario).getNome(),
                                    Conta.conta.get(numeroContaDestino).getNome(),
                                    Conta.conta.get(numeroContaUsuario).getAgencia(),
                                    Conta.conta.get(numeroContaDestino).getAgencia(),
                                    Conta.conta.get(numeroContaUsuario).getCpf(),
                                    Conta.conta.get(numeroContaDestino).getCpf(),
                                    quantidadeTransferencia,
                                    "Transferência"));
                    System.out.println("Transferencia feita com sucesso.");
                    System.out.println("---------------------------------------------------------------");
                    break;


            //fazer saque:

            case 5:
                try {
                    System.out.println("Digite o numero da sua conta");
                    numeroContaUsuario = scanner.nextInt();
                    numeroContaUsuario-=1;

                    if (Conta.conta.get(numeroContaUsuario).getContaId()>contaId ||
                            Conta.conta.get(numeroContaUsuario).getContaId()<0){
                        break;
                    }

                } catch (Exception e) {
                    System.out.println("Conta inválida.");
                    System.out.println("---------------------------------------------------------------");
                    break;
                }

                System.out.println("Digite a quantidade que desejas sacar:");
                scanner.nextLine();
                double quantidadeSaque = Double.parseDouble(scanner.nextLine().replace(",","."));
                Conta.conta.get(numeroContaUsuario).saque(quantidadeSaque);

                Transacoes.transacoes.add(new Transacoes(Conta.conta.get(numeroContaUsuario).getContaId(),
                        -1,
                        Conta.conta.get(numeroContaUsuario).getNome(),
                        "",
                        Conta.conta.get(numeroContaUsuario).getAgencia(),
                        "",
                        Conta.conta.get(numeroContaUsuario).getCpf(),
                        "",
                        quantidadeSaque,
                        "Saque"));
                System.out.println("---------------------------------------------------------------");
                break;


            //fazer deposito:

            case 6:
                try {
                    scanner.nextLine();
                    System.out.println("Digite o numero da sua conta");
                    numeroContaUsuario = scanner.nextInt();
                    numeroContaUsuario-=1;

                    if (Conta.conta.get(numeroContaUsuario).getContaId()>contaId ||
                            Conta.conta.get(numeroContaUsuario).getContaId()<0){
                        break;
                    }

                } catch (Exception e) {
                    System.out.println("Conta inválida.");
                    System.out.println("---------------------------------------------------------------");
                    break;
                }

                System.out.println("Digite a quantidade que desejas depositar:");
                scanner.nextLine();
                double quantidadeDeposito = Double.parseDouble(scanner.nextLine().replace(",","."));
                Conta.conta.get(numeroContaUsuario).deposito(quantidadeDeposito);

                Transacoes.transacoes.add(new Transacoes(Conta.conta.get(numeroContaUsuario).getContaId(),
                        -1,
                        Conta.conta.get(numeroContaUsuario).getNome(),
                        "",
                        Conta.conta.get(numeroContaUsuario).getAgencia(),
                        "",
                        Conta.conta.get(numeroContaUsuario).getCpf(),
                        "",
                        quantidadeDeposito,
                        "Deposito"));

                System.out.println("Deposito feito com sucesso.");
                System.out.println("---------------------------------------------------------------");
                break;

            //alterar cadastro:

            case 7 :

                try {
                    scanner.nextLine();
                    System.out.println("Digite o numero da sua conta:");
                    numeroContaUsuario = scanner.nextInt();
                    numeroContaUsuario-=1;

                    if (Conta.conta.get(numeroContaUsuario).getContaId()>contaId ||
                            Conta.conta.get(numeroContaUsuario).getContaId()<0){
                        break;
                    }

                } catch (Exception e) {
                    System.out.println("Conta inválida.");
                    System.out.println("---------------------------------------------------------------");
                    break;
                }
                    System.out.println("Escolha o numero da opção que deseja alterar:\n1-Nome\n2-Renda Mensal");
                    scanner.nextLine();
                    int opcaoAlterar = scanner.nextInt();
                    switch (opcaoAlterar) {
                        case 1:
                            System.out.println("Digite o novo nome:");
                            scanner.nextLine();
                            String novoNome = scanner.nextLine();
                            Conta.conta.get(numeroContaUsuario).setNome(novoNome);
                            System.out.println("Nome alterado com sucesso.");
                            System.out.println("---------------------------------------------------------------");
                        break;
                        case 2:
                            System.out.println("Digite a nova renda mensal:");
                            scanner.nextLine();
                            double novaRenda = Double.parseDouble(scanner.nextLine().replace(",","."));
                            Conta.conta.get(numeroContaUsuario).setRendaMensal(novaRenda);
                            System.out.println("Renda alterada com sucesso");
                            System.out.println("---------------------------------------------------------------");
                        break;
                        default:
                            System.out.println("Operação inválida.");
                            System.out.println("---------------------------------------------------------------");

                    }
                    break;

            case 8:
                try {
                    scanner.nextLine();
                    System.out.println("Digite o numero da sua conta");
                    numeroContaUsuario = scanner.nextInt();
                    numeroContaUsuario-=1;

                    if (Conta.conta.get(numeroContaUsuario).getContaId()>contaId ||
                            Conta.conta.get(numeroContaUsuario).getContaId()<0){
                        break;
                    }

                } catch (Exception e) {
                    System.out.println("Conta inválida.");
                    System.out.println("---------------------------------------------------------------");
                    break;
                }



                if (Conta.conta.get(numeroContaUsuario) instanceof ContaPoupanca){
                    System.out.println("informe o número de meses para calcular o rendimento na poupança");
                    scanner.nextLine();
                    int mesesRendimento = scanner.nextInt();
                    ((ContaPoupanca) Conta.conta.get(numeroContaUsuario)).getRendimento(mesesRendimento);
                }else{
                    System.out.println("Sua conta não possui esse benefício, apenas contas poupança.");
                }


                break;
            case 123:

                System.out.println("""
                Selecione o relatório desejado:
                1-listar contas correntes
                2-listar contas poupanças
                3-listar contas investimento
                4-listar todas as contas
                5-listar contas com saldo negativo
                6-todas as transações de um determinado cliente
                """);


                int opcaoRelatorioBanco = scanner.nextInt();
                switch (opcaoRelatorioBanco){
                    case 1:
                        System.out.println("lista de contas correntes:");
                        for (int i=0; i<Conta.conta.size(); i++){
                            if (Conta.conta.get(i) instanceof ContaCorrente){

                                System.out.println("Numero da conta - "+Conta.conta.get(i).getContaId()+
                                        "\n   nome do proprietário - "+Conta.conta.get(i).getNome());
                            }
                    }
                        break;
                    case 2:
                        System.out.println("lista de contas poupanças:");
                        for (int i=0; i<Conta.conta.size(); i++) {
                            if (Conta.conta.get(i) instanceof ContaPoupanca) {

                                System.out.println("Numero da conta - " + Conta.conta.get(i).getContaId() +
                                        "\n   nome do proprietário - " + Conta.conta.get(i).getNome());
                            }
                        }
                        break;

                    case 3:
                        System.out.println("lista de contas investimento:");
                        for (int i=0; i<Conta.conta.size(); i++) {
                            if (Conta.conta.get(i) instanceof ContaInvestimento) {

                                System.out.println("Numero da conta - " + Conta.conta.get(i).getContaId() +
                                        "\n   nome do proprietário - " + Conta.conta.get(i).getNome());
                            }
                        }
                        break;

                    case 4:
                        System.out.println("lista de todas as contas:");
                        for (int i=0; i<Conta.conta.size(); i++) {
                                System.out.println("Numero da conta - " + Conta.conta.get(i).getContaId() +
                                        "\n   nome do proprietário - " + Conta.conta.get(i).getNome());
                            }

                        break;

                    case 5:
                        System.out.println("lista de todas as contas com saldo negativo:");
                        for (int i=0; i<Conta.conta.size(); i++) {
                            if (Conta.conta.get(i).getSaldo()<0) {
                                System.out.println("Numero da conta - " + Conta.conta.get(i).getContaId() +
                                        "\n   nome do proprietário - " + Conta.conta.get(i).getNome() +
                                        "saldo negativo - " + Conta.conta.get(i).getSaldo());
                            }
                        }


                        break;
//
                    case 6:
                        try {
                            scanner.nextLine();
                            System.out.println("Digite o numero da sua conta");
                            numeroContaUsuario = scanner.nextInt();

                            for (int i = 0; i < Transacoes.transacoes.size(); i++) {

                                if (Transacoes.transacoes.get(i).contaId1==(numeroContaUsuario)) {
                                    Transacoes.transacoes.get(i).getExtrato();
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Conta inválida.");
                            System.out.println("---------------------------------------------------------------");
                            break;
                        }
                        break;

//
//

            default:
                System.out.println("escolha inválida");
                break;

                }
                break;


            case 404:
                        continuarAplicacao = false;
                        break;

                    default:
                        System.out.println("Operação inválida.\nDigite um número de operação válido.");
                        System.out.println("---------------------------------------------------------------");
                }
        }while (continuarAplicacao);

        System.out.println("Aplicação finalizada com sucesso.");

}}

package battlepckg;

import java.util.InputMismatchException;
import java.util.Scanner;



public class BatalhaFinal {


    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean valido = false;
        boolean repetir = true;
        Jogador mainCharacter = null;
        int escolhasJogador = 0;

        System.out.println("Seja bem vindo(a) à BATALHA FINAL!");

        while (repetir) {

            // TODO: solicitar ao jogador um nome para o personagem.
            System.out.println("Digite um nome para o seu personagem");
            String nomePersonagem = scanner.nextLine();


            // TODO: solicitar ao jogador um sexo para o personagem.
            //       M ou F.
            System.out.println("Digite 'M' para criar um personagem masculino ou 'F' para criar um personagem feminino");
            String sexoPersonagem = scanner.nextLine();


            // TODO: solicitar ao jogador qual a classe do personagem.
            //       Guerreiro, Paladino, Arqueiro, Mago.
            valido = false;
            int escolhaClasse = 0;
            while (!valido) {
                System.out.println("Escolha a classe do seu personagem:\n1-Guerreiro\n2-Mago\n3-Paladino\n4-Arqueiro");
                try {
                    escolhaClasse = scanner.nextInt();
                    if (escolhaClasse >= 1 && escolhaClasse <= 4) {
                        valido = true;
                    } else {
                        System.out.println("Escolha uma opção válida.");
                    }
                } catch (InputMismatchException e) {
                    escolhaClasse = 0;
                    System.out.println("Digite apenas números inteiros");

                } finally {
                    scanner.nextLine();
                }
            }

            // TODO: solicitar ao jogador qual arma o personagem vai usar,
            //       dentre as opções disponíveis para a classe selecionada.


            for (ArmasEnum arma : ArmasEnum.values()) {
                System.out.println(arma.idArma + " - Equipada por:" + arma.quemUsa);
            }
            valido = false;
            String escolhaArma = "";
            ArmasEnum escolhaArmaEnum = null;
            while (!valido) {
                System.out.println("Digite o nome de qual arma de classe da lista você deseja usar:");
                escolhaArma = scanner.nextLine();

                for (ArmasEnum arma : ArmasEnum.values()) {
                    if (escolhaArma.toUpperCase().equals(arma.idArma.toUpperCase())) {
                        valido = true;
                        escolhaArmaEnum = arma;
                    }
                }
                if (!valido) {
                    System.out.println("Digite o nome da arma corretamente como apresentado na lista.");
                }

            }


            //         TODO: instanciar um novo objeto da classe selecionada pelo jogador,
            //               passando como argumentos os valores coletados.


            switch (escolhaClasse) {
                //Guerreiro
                case 1:
                    try {
                        mainCharacter = new Guerreiro(nomePersonagem, sexoPersonagem, escolhaArmaEnum);
                        repetir = false;
                    } catch (InvalidCharacterException e) {
                        System.err.println(e);
                        System.out.println("Nome ou Sexo é inválido.");
                        System.out.println("Crie seu personagem novamente");
                        Thread.sleep(3000);
                        System.out.println("\n\n");
                    } catch (InvalidWeaponException e) {
                        System.err.println(e);
                        System.out.println("Arma escolhida não é válida");
                        System.out.println("Crie seu personagem novamente");
                        Thread.sleep(3000);
                        System.out.println("\n\n");
                    }
                    break;

                //Mago
                case 2:
                    try {
                        mainCharacter = new Mago(nomePersonagem, sexoPersonagem, escolhaArmaEnum);
                        repetir = false;
                    } catch (InvalidCharacterException e) {
                        System.err.println(e);
                        System.out.println("Nome ou Sexo é inválido.");
                        System.out.println("Crie seu personagem novamente");
                        Thread.sleep(3000);
                        System.out.println("\n\n");
                    } catch (InvalidWeaponException e) {
                        System.err.println(e);
                        System.out.println("Arma escolhida não é válida");
                        System.out.println("Crie seu personagem novamente");
                        Thread.sleep(3000);
                        System.out.println("\n\n");
                    }
                    break;

                //Paladino
                case 3:
                    try {
                        mainCharacter = new Paladino(nomePersonagem, sexoPersonagem, escolhaArmaEnum);
                        repetir = false;
                    } catch (InvalidCharacterException e) {
                        System.err.println(e);
                        System.out.println("Nome ou Sexo é inválido.");
                        System.out.println("Crie seu personagem novamente");
                        Thread.sleep(3000);
                        System.out.println("\n\n");
                    } catch (InvalidWeaponException e) {
                        System.err.println(e);
                        System.out.println("Arma escolhida não é válida");
                        System.out.println("Crie seu personagem novamente");
                        Thread.sleep(3000);
                        System.out.println("\n\n");
                    }
                    break;

                //Arqueiro
                case 4:
                    try {
                        mainCharacter = new Arqueiro(nomePersonagem, sexoPersonagem, escolhaArmaEnum);
                        repetir = false;
                    } catch (InvalidCharacterException e) {
                        System.err.println(e);
                        System.out.println("Nome ou Sexo é inválido.");
                        System.out.println("Crie seu personagem novamente");
                        Thread.sleep(3000);
                        System.out.println("\n\n");
                    } catch (InvalidWeaponException e) {
                        System.err.println(e);
                        System.out.println("Arma escolhida não é válida");
                        System.out.println("Crie seu personagem novamente");
                        Thread.sleep(3000);
                        System.out.println("\n\n");

                    }
                    break;

            }
        }

        System.out.println("Personagem criado com sucesso.");
        Thread.sleep(1500);

        System.out.println("A noite se aproxima, a lua já surge no céu, estrelas vão se acendendo,\n"
                + "e sob a luz do crepúsculo você está prestes a entrar na fase final da sua missão.\n"
                + "Você olha para o portal à sua frente, e sabe que a partir desse ponto, sua vida mudará para sempre.");

        System.out.println("Memórias do caminho percorrido para chegar até aqui invadem sua mente.\n"
                + "Você se lembra de todos os inimigos já derrotados para alcançar o covil do líder maligno.\n"
                + "Olha para seu equipamento de combate, já danificado e desgastado depois de tantas lutas.\n"
                + "Você está a um passo de encerrar para sempre esse mal.");

        System.out.println("Buscando uma injeção de ânimo, você se força a lembrar o que te trouxe até aqui.");

        // TODO: pedir ao jogador para escolher a motivação do seu personagem.
        //       por que o personagem está nessa missão de destruir os inimigos?
        //       Vingança ou Glória?
        Thread.sleep(3000);
        System.out.println("Selecione sua MOTIVAÇÃO:\n1-VINGANÇA\n2-GLORIA");
        valido = false;
        while (!valido) {
            try {
                int escolhaMotivacao = scanner.nextInt();
                if (escolhaMotivacao == 1) {
                    mainCharacter.setMotivacao(MotivacaoEnum.VINGANCA);
                    valido = true;
                } else if (escolhaMotivacao == 2) {
                    mainCharacter.setMotivacao(MotivacaoEnum.GLORIA);
                    valido = true;
                } else {
                    System.out.println("Escolha uma opção válida de Motivação.");
                }
            } catch (InputMismatchException e) {
                System.err.println(e);
                System.out.println("Digite apenas números inteiros.");
            }
        }

        // TODO: if (motivação do jogador == VINGANÇA)

        if (mainCharacter.getMotivacao().equals(MotivacaoEnum.VINGANCA)) {
            System.out.println("Imagens daquela noite trágica invadem sua mente.\n"
                    + "Você nem precisa se esforçar para lembrar, pois essas memórias estão sempre presentes,\n"
                    + "mesmo que de pano de fundo, quando você tem outros pensamentos em foco, elas nunca o deixaram.\n"
                    + "Elas são o combustível que te fizeram chegar até aqui.\n"
                    + "E você sabe que não irá desistir até ter vingado a morte\n"
                    + "daqueles que foram - e pra sempre serão - sua fonte de amor e desejo de continuar vivo.\n"
                    + "O maldito líder finalmente pagará por tanto mal causado na vida de tantos\n"
                    + "(e principalmente na sua).");
        } else {
            // TODO else
            System.out.println("Você já consegue visualizar na sua mente o povo da cidade te recebendo de braços abertos,\n"
                    + "bardos criando canções sobre seus feitos heróicos, nobres te presenteando com jóias e diversas riquezas,\n"
                    + "taberneiros se recusando a cobrar por suas bebedeiras e comilanças.\n"
                    + "Desde já, você sente o amor do público, te louvando a cada passo que dá pelas ruas,\n"
                    + "depois de destruir o vilão que tanto assombrou a paz de todos.\n"
                    + "Porém, você sabe que ainda falta o último ato dessa história.\n"
                    + "Você se concentra na missão.\n"
                    + "A glória o aguarda, mas não antes da última batalha.");
        }

        System.out.println("Inspirado pelo motivo que te trouxe até aqui, você sente seu coração ardendo em chamas,\n"
                + "suas mãos formigarem em volta da sua arma. Você a segura com firmeza. Seu foco está renovado.\n"
                + "Você avança pelo portal.");

        System.out.println("A escuridão te envolve. Uma iluminação muito fraca entra pelo portal às suas costas.\n"
                + "À sua frente, só é possível perceber que você se encontra em um corredor extenso.\n"
                + "Você só pode ir à frente, ou desistir.");
        Thread.sleep(3000);

        // TODO: perguntar ao jogador se o personagem segue em frente ou desiste
        valido = false;
        while (!valido) {
            System.out.println("Você deseja seguir em frente ou desistir?\n1-Seguir em frente\n2-Desistir");
            try {
                int escolhaDesistencia = scanner.nextInt();
                // TODO: if (desiste)
                if (escolhaDesistencia == 2) {
                    System.out.println("O medo invade o seu coração e você sente que ainda não está à altura do desafio.\n"
                            + "Você se volta para a noite lá fora, e corre em direção à segurança.");
                    // TODO: encerrar a execução do programa: System.exit(0);
                    System.exit(0);
                } else if (escolhaDesistencia == 1) {
                    valido = true;
                } else {
                    System.out.println("Escolha uma opção válida.");
                }
            } catch (InputMismatchException e) {
                System.err.println(e);
                System.out.println("Informe apenas números inteiros.");
            }
        }

        System.out.println("Você caminha, atento a todos os seus sentidos, por vários metros,\n"
                + "até visualizar a frente uma fonte de luz, que você imagina ser a chama de uma tocha,\n"
                + "vindo de dentro de uma porta aberta.");

        System.out.println("Você se pergunta se dentro dessa sala pode haver inimigos, ou alguma armadilha,\n"
                + "e pondera sobre como passar pela porta.");
        // TODO: perguntar ao jogador se deseja passar pela porta ANDANDO CUIDADOSAMENTE, CORRENDO ou SALTANDO.

        System.out.println("Escolha a opção desejada:\n" +
                "1-Passar pela porta saltando\n" +
                "2-Passar pela porta correndo\n" +
                "3-Passar pela porta andando cuidadosamente");
        valido = false;
        while (!valido) {
            try {
                escolhasJogador = scanner.nextInt();

                valido = true;

                // TODO: if SALTANDO
                if (escolhasJogador == 1) {
                    System.out.println("Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.");

                    // TODO: else if CORRENDO
                } else if (escolhasJogador == 2) {

                    System.out.println("Você respira fundo e desata a correr em direção à sala.\n"
                            + "Quando passa pela porta, sente que pisou em uma pedra solta,\n"
                            + "mas não dá muita importância e segue para dentro da sala, olhando ao redor à procura de inimigos.\n"
                            + "Não tem ninguém, mas você ouve sons de flechas batendo na pedra atrás de você,\n"
                            + "e quando se vira, vê várias flechas no chão.\n"
                            + "Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no teto,\n"
                            + "mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.");
                    // TODO: else
                } else if (escolhasJogador == 3) {

                    System.out.println("Você toma cuidado e vai caminhando vagarosamente em direção à luz.\n"
                            + "Quando você pisa exatamente embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta.\n"
                            + "Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrás de você, no corredor.\n"
                            + "Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma delas te acerta na perna.");
                    //TODO: instanciar objeto Armadilha e invocar método de causar dano.
                    Armadilha armadilha = new Armadilha();
                    armadilha.atacar(mainCharacter);

                } else {
                    System.out.println("Escolha uma opção válida");
                    valido = false;
                }

            } catch (InputMismatchException e) {
                System.err.println(e);
                System.out.println("Digite apenas números inteiros.");
            }
        }


        System.out.println("Você se encontra sozinho em uma sala quadrada, contendo uma porta em cada parede.\n"
                + "Uma delas foi aquela pela qual você entrou, que estava aberta, e as outras três estão fechadas.\n"
                + "A porta à sua frente é a maior das quatro, com inscrições em seu entorno em uma língua que você não sabe ler,\n"
                + "mas reconhece como sendo a língua antiga utilizada pelo inimigo.\n"
                + "Você se aproxima da porta e percebe que ela está trancada por duas fechaduras douradas,\n"
                + "e você entende que precisará primeiro derrotar o que estiver nas outras duas portas laterais,\n"
                + "antes de conseguir enfrentar o líder.");

        System.out.println("Você se dirige para a porta à direita.");

        System.out.println("Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.\n"
                + "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.\n"
                + "Ao entrar, você se depara com uma sala espaçosa,\n"
                + "com vários equipamentos de batalha pendurados nas paredes e dispostos em armários e mesas.\n"
                + "Você imagina que este seja o arsenal do inimigo, onde estão guardados os equipamentos que seus soldados\n"
                + "utilizam quando saem para espalhar o terror nas cidades e vilas da região.\n"
                + "Enquanto seu olhar percorre a sala, você ouve a porta se fechando e gira rapidamente para olhar para trás.\n"
                + "Ali, de pé entre você e a porta fechada, bloqueando o caminho do seu destino, está um dos capitães do inimigo.\n"
                + "Um orque horrendo, de armadura, capacete e espada em punho, em posição de combate.\n"
                + "Ele avança em sua direção.");
        // TODO: instanciar objeto Armeiro
        Armeiro armeiro = new Armeiro();
        // TODO: iniciar loop de combate, inimigo ataca primeiro
        BatalhaFinal.combate(mainCharacter, armeiro);
        System.out.println("Após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados.\n"
                + "Olha em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.");

        // TODO: perguntar ao jogador se ele quer ou não pegar as armaduras novas.
        System.out.println("Você deseja pegar as armaduras novas?\n" +
                "1-Sim\n" +
                "2-Não");
        valido = false;
        while (!valido) {
            try {
                escolhasJogador = scanner.nextInt();

                // TODO: Se escolher pegar
                if (escolhasJogador == 1) {
                    valido = true;
                    System.out.println("Você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas,\n"
                            + "que estavam danificadas, pelas peças de armaduras existentes na sala.\n"
                            + "De armadura nova, você se sente mais protegido para os desafios à sua frente.");
                    // TODO: deve ser acrescentado +5 pontos de defesa para o jogador.
                    mainCharacter.setPontosDefesa(mainCharacter.getPontosDefesa() + 5);
                    // TODO: se não
                } else if (escolhasJogador == 2) {
                    valido = true;
                    System.out.println("Você decide que não precisa utilizar nada que venha das mãos do inimigo.");
                } else {
                    System.out.println("Escolha uma opção válida.");
                }
            } catch (InputMismatchException e) {
                System.err.println(e);
                System.out.println("Digite apenas números inteiros.");
            }
        }

        System.out.println("Em uma mesa, você encontra uma chave dourada, e sabe que aquela chave abre uma das fechaduras da porta do líder inimigo.\n"
                + "Você pega a chave e guarda numa pequena bolsa que leva presa ao cinto.");

        System.out.println("Você retorna à sala anterior e se dirige à porta da esquerda.\n"
                + "Você se aproxima, tentando ouvir o que acontece porta adentro, mas não escuta nada.\n"
                + "Segura com mais força sua arma com uma mão, enquanto empurra a porta com a outra.\n"
                + "Ao entrar, você se depara com uma sala parecida com a do arsenal, mas em vez de armaduras,\n"
                + "existem vários potes e garrafas de vidro com conteúdos misteriosos e de cores diversas,\n"
                + "e você entende que o capitão que vive ali, realiza experimentos com diversos ingredientes,\n"
                + "criando poções utilizadas pelos soldados para aterrorizar a região.");
        System.out.println("No fundo da sala, olhando em sua direção, está outro dos capitães do inimigo.\n"
                + "Um orque horrendo, de armadura, cajado em punho, em posição de combate. Ele avança em sua direção.");
        // TODO: instanciar objeto Alquimista
        Alquimista alquimista = new Alquimista();
        // TODO: iniciar loop de combate, inimigo ataca primeiro
        BatalhaFinal.combate(mainCharacter, alquimista);

        System.out.println("Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque do inimigo.\n"
                + "Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente rosado,\n"
                + "pega a garrafa e pondera se deve beber um gole.");
        // TODO: perguntar ao jogador se ele quer ou não beber.
        System.out.println("Escolha uma opção abaixo:\n" +
                "1-Beber o líquido\n" +
                "2-Não beber o líquido");
        valido = false;
        while (!valido) {
            try {
                escolhasJogador = scanner.nextInt();


                if (escolhasJogador == 1) {
                    // TODO: Se escolher beber
                    System.out.println("Você se sente revigorado para seguir adiante!");
                    valido = true;

                    // TODO: pontos de saúde do jogador devem ser restaurados 100%
                    mainCharacter.setSaude(Jogador.SAUDE_MAXIMA);
                } else if (escolhasJogador == 2) {
                    // TODO: se não
                    System.out.println("Você fica receoso de beber algo produzido pelo inimigo.");
                    valido = true;
                } else {
                    System.out.println("Escolha uma opção válida");
                }
            } catch (InputMismatchException e) {
                System.err.println(e);
                System.out.println("Digite apenas números inteiros.");
            }
        }

        System.out.println("Ao lado da porta, você vê uma chave dourada em cima de uma mesa,\n"
                + "e sabe que aquela chave abre a outra fechadura da porta do líder inimigo.\n"
                + "Você pega a chave e guarda na pequena bolsa que leva presa ao cinto.");

        System.out.println("De volta à sala das portas, você se dirige à porta final.\n"
                + "Coloca as chaves nas fechaduras, e a porta se abre.\n"
                + "Seu coração acelera, memórias de toda a sua vida passam pela sua mente,\n"
                + "e você percebe que está muito próximo do seu objetivo final.\n"
                + "Segura sua arma com mais firmeza, foca no combate que você sabe que irá se seguir, e adentra a porta.");

        System.out.println("Lá dentro, você vê o líder sentado em uma poltrona dourada, com duas fogueiras de cada lado, e prisioneiros acorrentados às paredes.");

        System.out.println("Ele percebe sua chegada e se levanta com um salto, apanhando seu machado de guerra de lâmina dupla.");
        Lider lider = new Lider();
        // TODO: jogador deve decidir se ataca ou espera
        System.out.println("Escolha uma opção abaixo\n" +
                "1-Atacar" +
                "2-Não atacar");
        escolhasJogador=scanner.nextInt();
        valido = false;
        while (!valido) {
            try {
                escolhasJogador = scanner.nextInt();
                if (escolhasJogador == 1 || escolhasJogador == 2) {
                    valido = true;
                } else {
                    System.out.println("Escolha uma opção válida.");
                }
            } catch (InputMismatchException e) {
                System.err.println(e);
                System.out.println("Digite apenas números inteiros.");
            }
        }
        // TODO: iniciar loop de combate, dependendo da resposta do jogador, ele ataca primeiro
        if (escolhasJogador==2){
            lider.atacar(mainCharacter);
        }
        BatalhaFinal.combate(mainCharacter, lider);

        System.out.println("Você conseguiu!");
        // TODO: exibir mensagem de vitória de acordo com a motivação do jogador:
        // se vingança: Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.
        // se glória: O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.
        if (mainCharacter.getMotivacao().equals(MotivacaoEnum.VINGANCA)) {
            System.out.println("Você obteve sua vingança. Você se ajoelha e cai no choro, invadido por uma sensação de alívio e felicidade. Você se vingou, tudo que sempre quis, está feito. Agora você pode seguir sua vida.");
        } else {
            System.out.println("O êxtase em que você se encontra não cabe dentro de si. Você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.");
        }
        System.out.println("Você se levanta, olha para os prisioneiros, vai de um em um e os liberta,\n"
                + "e todos vocês saem em direção à noite, retornando à cidade.\n"
                + "Seu dever está cumprido.");

    }

        private static void combate(Jogador jogador, Inimigo inimigo) throws InputMismatchException, InterruptedException {
        Scanner input = new Scanner(System.in);

        while (!(jogador.getSaude()<=0 || inimigo.getSaude()<=0)){
            System.out.println("Seu turno.");
            System.out.println("Escolha uma opção abaixo:\n" +
                    "1-Atacar\n" +
                    "2-Fugir");

            int escolhaJogador=input.nextInt();
            if (escolhaJogador==2){
                System.out.println("Você não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez.");
                System.exit(0);
            }

            jogador.atacar(inimigo);
            if (inimigo.getSaude()<=0){
                System.out.println("Você derrotou o inimigo.");
                break;
            }else {
                System.out.println("Turno do inimigo");
                inimigo.atacar(jogador);
            }

        }

        if (jogador.getSaude()<=0){
            System.out.println("Você não estava preparado para a força do inimigo.");
            if (jogador.getMotivacao().equals(MotivacaoEnum.VINGANCA)){
                System.out.println("Não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.");
                System.exit(0);
            }else{
                System.out.println("A glória que buscavas não será sua, e a cidade aguarda por seu(sua) próximo(a) herói(na).");
                System.exit(0);
            }
        }

        }


    }
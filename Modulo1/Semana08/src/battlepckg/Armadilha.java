package battlepckg;

public class Armadilha implements Atacante{

    ArmasEnum arma;
    int pontosDeAtaque;

    public Armadilha() {
        this.arma=ArmasEnum.ARMADILHA;
        this.pontosDeAtaque=5;
    }

    @Override
    public void atacar(Personagem personagemAtacado) throws InterruptedException {
        int dado=(int)(Math.random()*9+1);

        System.out.println("Jogando o dado...\n");
        Thread.sleep(3000);
        System.out.println("Valor do dado: "+dado+"\n");
        Thread.sleep(1500);

        int dano=this.arma.danoArma+this.pontosDeAtaque+dado-personagemAtacado.getPontosDefesa();

        if(dano<0){
            dano=0;
        }

        if(dado==1){
            System.out.println("O ataque da armadilha pegou de raspão e você não recebeu dano.\n");
        }else{
            personagemAtacado.setSaude(personagemAtacado.getSaude()-dano);
            System.out.printf("Você sofreu %d de dano e agora possui %d pontos de vida.%n%n", dano, personagemAtacado.getSaude());

        }

        Thread.sleep(4500);
    }
}

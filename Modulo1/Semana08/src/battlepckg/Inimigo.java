package battlepckg;

public abstract class Inimigo extends Personagem implements Atacante{

    ArmasEnum arma;

    public Inimigo(int saude, int pontosAtaque, int pontosDefesa) {
        super(saude, pontosAtaque, pontosDefesa);
    }

    @Override
    public void atacar(Personagem personagemAtacado) throws InterruptedException {
        int dado=(int)(Math.random()*19+1);

        System.out.println("Jogando o dado...\n");
        Thread.sleep(3000);
        System.out.println("Valor do dado: "+dado+"\n");
        Thread.sleep(1500);

        if(dado==1){
            System.out.println("O ataque falhou. O inimigo não conseguiu golpear.\n");
        }else if(dado==20) {
            int dano=this.arma.danoArma+this.getPontosAtaque()+dado;

            System.out.println("Seu inimigo desferiu um golpe crítico!");
            personagemAtacado.setSaude(personagemAtacado.getSaude()-dano);
            System.out.printf("Você sofreu %d de dano e agora possui %d pontos de vida.%n%n", dano, personagemAtacado.getSaude());

        }else{
            int dano=this.arma.danoArma+this.getPontosAtaque()+dado-personagemAtacado.getPontosDefesa();
            if(dano<0){
                dano=0;
            }
            personagemAtacado.setSaude(personagemAtacado.getSaude()-dano);
            System.out.printf("Você sofreu %d de dano e agora possui %d pontos de vida.%n%n", dano, personagemAtacado.getSaude());
        }

        Thread.sleep(3000);
    }
}

package battlepckg;

public abstract class Jogador extends Personagem implements Atacante{

    private String nome;
    private String sexo;
    private MotivacaoEnum motivacao;
    private ArmasEnum arma;
    public final static int SAUDE_MAXIMA=200;


    public Jogador(int saude, int pontosAtaque, int pontosDefesa, String nome, String sexo, ArmasEnum arma) throws InvalidCharacterException {
        super(saude, pontosAtaque, pontosDefesa);
        if (nome.isBlank()||nome.isEmpty()){
            throw new InvalidCharacterException("Nome não pode ser em branco.");
        }else {
            this.nome = nome;
        }

        if (!(sexo.toUpperCase().equals("M")||sexo.toUpperCase().equals("F"))){
            throw new InvalidCharacterException("Apenas 'M' ou 'F' são aceitos");
        }else {
            this.sexo = sexo;
        }

        this.arma=arma;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public MotivacaoEnum getMotivacao() {
        return motivacao;
    }

    public ArmasEnum getArma() {
        return arma;
    }

    public void setArma(ArmasEnum arma) {
        this.arma = arma;
    }

    @Override
    public void atacar(Personagem personagemAtacado) throws InterruptedException {
        int dado=(int)(Math.random()*19+1);

        System.out.println("Jogando o dado...\n");
        Thread.sleep(3000);
        System.out.println("Valor do dado: "+dado+"\n");
        Thread.sleep(1500);

        if(dado==1){
            System.out.println("O ataque falhou. Você não conseguiu atacar!\n");
        }else if(dado==20) {
            int dano=this.arma.danoArma+this.getPontosAtaque()+dado;

            System.out.println("Você desferiu um golpe crítico!");
            personagemAtacado.setSaude(personagemAtacado.getSaude()-dano);
            System.out.printf("Você causou %d de dano no inimigo e agora ele possui %d pontos de vida.%n%n", dano, personagemAtacado.getSaude());

        }else{
            int dano=this.arma.danoArma+this.getPontosAtaque()+dado-personagemAtacado.getPontosDefesa();
            if(dano<0){
                dano=0;
            }
            personagemAtacado.setSaude(personagemAtacado.getSaude()-dano);
            System.out.printf("O inimigo sofreu %d de dano e agora possui %d pontos de vida.%n%n", dano, personagemAtacado.getSaude());
        }

        Thread.sleep(3000);
    }



    public void setMotivacao(MotivacaoEnum motivacao) {
        this.motivacao = motivacao;
    }
}

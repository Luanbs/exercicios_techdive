package battlepckg;

public abstract class Personagem {

    private int saude;
    private int pontosAtaque;
    private int pontosDefesa;

    public Personagem(int saude, int pontosAtaque, int pontosDefesa) {
        this.saude = saude;
        this.pontosAtaque = pontosAtaque;
        this.pontosDefesa = pontosDefesa;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public int getPontosAtaque() {
        return pontosAtaque;
    }

    public void setPontosAtaque(int pontosAtaque) {
        this.pontosAtaque = pontosAtaque;
    }

    public int getPontosDefesa() {
        return pontosDefesa;
    }

    public void setPontosDefesa(int pontosDefesa) {
        this.pontosDefesa = pontosDefesa;
    }
}

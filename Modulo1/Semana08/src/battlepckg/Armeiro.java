package battlepckg;

public class Armeiro extends Inimigo{

    public static final int ARMEIRO_SAUDE_MAXIMA=100;
    public Armeiro() {
        super(ARMEIRO_SAUDE_MAXIMA, 10, 15);
        super.arma=ArmasEnum.ESPADA;
    }
}

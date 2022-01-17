package battlepckg;

public class Lider extends Inimigo{

    public static final int LIDER_SAUDE_MAXIMA=200;
    public Lider() {
        super(LIDER_SAUDE_MAXIMA, 15, 15);
        super.arma=ArmasEnum.MACHADODUPLO;
    }
}

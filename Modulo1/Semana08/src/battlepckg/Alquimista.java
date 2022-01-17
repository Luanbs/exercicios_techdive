package battlepckg;

public class Alquimista extends Inimigo{

    public static final int ALQUIMISTA_SAUDE_MAXIMA=100;
    public Alquimista() {
        super(ALQUIMISTA_SAUDE_MAXIMA, 15, 10);
        super.arma=ArmasEnum.CAJADO;
    }
}

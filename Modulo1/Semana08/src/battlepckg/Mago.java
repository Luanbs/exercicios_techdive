package battlepckg;

public class Mago extends Jogador{
    public Mago(String nome, String sexo, ArmasEnum arma) throws InvalidCharacterException, InvalidWeaponException {
        super(SAUDE_MAXIMA, 19, 11, nome, sexo, arma);
        if (!arma.quemUsa.equals("Mago")){
            throw new InvalidWeaponException("Arma escolhida incompatível com a classe.");
        }
    }
}

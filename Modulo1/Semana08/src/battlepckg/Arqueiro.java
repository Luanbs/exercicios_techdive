package battlepckg;

public class Arqueiro extends Jogador{
    public Arqueiro(String nome, String sexo, ArmasEnum arma) throws InvalidCharacterException, InvalidWeaponException {
        super(SAUDE_MAXIMA, 18, 13, nome, sexo,  arma);
        if (!arma.quemUsa.equals("Arqueiro")){
            throw new InvalidWeaponException("Arma escolhida incompatível com a classe.");
        }
    }
}

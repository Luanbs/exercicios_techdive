package battlepckg;

public class Paladino extends Jogador{
    public Paladino(String nome, String sexo, ArmasEnum arma) throws InvalidWeaponException, InvalidWeaponException{
        super(SAUDE_MAXIMA, 13, 18, nome, sexo, arma);
        if (!arma.quemUsa.equals("Paladino")){
            throw new InvalidWeaponException("Arma escolhida incompatível com a classe.");
        }

    }

}

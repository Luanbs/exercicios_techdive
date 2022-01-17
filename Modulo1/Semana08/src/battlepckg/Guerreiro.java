package battlepckg;

public class Guerreiro extends Jogador{

    public Guerreiro(String nome, String sexo, ArmasEnum arma) throws InvalidCharacterException, InvalidWeaponException {
        super(SAUDE_MAXIMA, 15, 15, nome, sexo, arma);
        if (!arma.quemUsa.equals("Guerreiro")){
            throw new InvalidWeaponException("Arma escolhida incompatível com a classe.");
        }
    }
}

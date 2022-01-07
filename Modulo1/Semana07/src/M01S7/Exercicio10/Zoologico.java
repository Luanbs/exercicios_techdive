package M01S7.Exercicio10;

import M01S7.Exercicio7e8.Animal;
import M01S7.Exercicio7e8.Cachorro;
import M01S7.Exercicio7e8.Cavalo;
import M01S7.Exercicio7e8.Preguica;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Zoologico {

    static ArrayList<Animal> animais = new ArrayList();


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            double randomNumber = Math.random() * 3;
            if (randomNumber < 1) {
                animais.add(new Cachorro());

            }else if(randomNumber<2){
                animais.add(new Cavalo());
            }else{
                animais.add(new Preguica());
            }
        }

        for (int i=0; i<animais.size(); i++){
            System.out.println("Jaula "+(i+1)+":");
            animais.get(i).emitirSom();
            animais.get(i).correr();

        }

    }


}
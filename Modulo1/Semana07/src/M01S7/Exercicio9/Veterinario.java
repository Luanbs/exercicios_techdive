package M01S7.Exercicio9;


import M01S7.Exercicio7e8.Animal;
import M01S7.Exercicio7e8.Cachorro;
import M01S7.Exercicio7e8.Cavalo;
import M01S7.Exercicio7e8.Preguica;

public class Veterinario {

    public void examinar(Animal animal){
        animal.emitirSom();
    }

    public static void main(String[] args) {
        Veterinario veterinario = new Veterinario();
        Cachorro cachorro = new Cachorro();
        Cavalo cavalo = new Cavalo();
        Preguica preguica = new Preguica();

        veterinario.examinar(cachorro);
        veterinario.examinar(preguica);
        veterinario.examinar(cavalo);
    }
}

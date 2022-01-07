package M01S7.Exercicio7e8;

public class Cachorro extends Animal{

    public void correr(){
        System.out.println("Cachorro correndo");
    }

    @Override
    public void emitirSom() {
        System.out.println("Cachorro emitindo som");
    }
}

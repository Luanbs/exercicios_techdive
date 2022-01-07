package M01S7.Exercicio7e8;

public class Cavalo extends Animal{

    public void correr(){
        System.out.println("Cavalo correndo");
    }
    @Override
    public void emitirSom() {
        System.out.println("Cavalo emitindo som");
    }
}

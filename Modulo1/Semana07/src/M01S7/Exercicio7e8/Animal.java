package M01S7.Exercicio7e8;

public class Animal {
   private String nome;
   private int idade;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void emitirSom(){
        System.out.println("Emitindo som");
    }

    public void correr(){
        System.out.println("Correndo");
    }
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro();
        Cavalo cavalo = new Cavalo();
        Preguica preguica = new Preguica();

        cachorro.emitirSom();
        cavalo.emitirSom();
        preguica.emitirSom();
    }

}

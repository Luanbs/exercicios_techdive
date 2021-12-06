package Exercicio8;

public class Classe1 {
    private int atributoPrivado = 0;

    public void modificar(int x){
        this.atributoPrivado=x;
    }
    public void getAtributo (){
        System.out.println(this.atributoPrivado);
    }
}

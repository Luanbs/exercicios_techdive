package Exercicio6;

public abstract class ClasseAbstrata {
        public ClasseAbstrata (){}

    public void teste(){
            System.out.println("Abstrata");
        };
        public static void main(String[] args) {
            ClasseAbstrata abstractOne = new ClasseAbstrata() {};
            abstractOne.teste();
        }
    }


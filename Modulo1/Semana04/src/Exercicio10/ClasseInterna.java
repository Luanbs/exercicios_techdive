package Exercicio10;


public class ClasseInterna {
    public class NotStatic {
       public NotStatic(){
           System.out.println("NotStatic instanciada");
        }
    }

    public static class ClasseStatic{
        public ClasseStatic(){
            System.out.println("Static instanciada");
        }
    }

    public static void main(String[] args) {
        ClasseStatic statiClass = new ClasseStatic();
        NotStatic in = new ClasseInterna().new NotStatic();

    }
}



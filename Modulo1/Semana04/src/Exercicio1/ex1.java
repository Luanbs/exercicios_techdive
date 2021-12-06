package Exercicio1;




public class ex1 {

    public static void main(String[] args) {


        double memoriaTotal = (double)((Runtime.getRuntime().maxMemory()));
        memoriaTotal = (((memoriaTotal/1024)/1024)/1024);
        double memoriaLivre = (double)((Runtime.getRuntime().freeMemory()));
        memoriaLivre = (((memoriaLivre/1024)/1024)/1024);
        double memoriaAlocada = memoriaTotal - memoriaLivre;

        System.out.println("o sistema operacional é: "+System.getProperty("os.name"));
        System.out.printf("Memória total: %.2f Gb", memoriaTotal);
        System.out.println("");
        System.out.printf("Memória alocada: %.2f Gb", memoriaAlocada);
        System.out.println("");
        System.out.printf("Memória livre: %.2f Gb", memoriaLivre);
    }
}
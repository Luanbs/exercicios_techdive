package Exercicio1;


import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {
        LocalDate dataAtual= LocalDate.now();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar){
        System.out.println("Digite sua data de nascimento no formato dd/mm/aaaa");
        String dataNascimentoStr=scanner.nextLine();

        if(dataNascimentoStr.length()==10){
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            long idade=ChronoUnit.YEARS.between(dataNascimento, dataAtual);

            if (idade>=18){
                System.out.println("Maior que 18");
                System.out.println("Sua idade é: "+idade);
            }else{
                System.out.println("Não possui 18 anos ainda");
                System.out.println("Sua idade é: "+idade);
            }

        }else {
            System.out.println("Data de nascimento não é válida.\nTente novamente.");
        }
    }
    }
}

package Exercicio5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String selecaoData="";
        System.out.println("Digite uma data no formato dd/mm/aaaa (dia/mes/ano):");

        while(selecaoData.length()!=10) {
            selecaoData = scanner.nextLine();
            if (selecaoData.length()!=10){
                System.out.println("Digite a data corretamente.");
            }
        }

        LocalDate dataUsuario = LocalDate.parse(selecaoData, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        dataUsuario=LocalDate.of(dataUsuario.getYear(), dataUsuario.getMonth(), 1);
        for (int i=0; i<dataUsuario.getMonth().length(dataUsuario.isLeapYear()); i++){
            if (dataUsuario.plusDays(i).getDayOfWeek().equals(DayOfWeek.MONDAY)){
                System.out.println(dataUsuario.plusDays(i));
            }
        }

    }
}

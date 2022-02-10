package Exercicio4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String selecaoData="";

        System.out.println("Digite uma data no formato dd/mm/aaaa (dia/mes/ano):");
        while(selecaoData.length()!=10) {
            selecaoData = scanner.nextLine();
            if (selecaoData.length()!=10){
                System.out.println("Digite a data corretamente.");
            }
        }

        LocalDate dataUsuario = LocalDate.parse(selecaoData, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (dataUsuario.getDayOfWeek().equals(DayOfWeek.FRIDAY) && dataUsuario.getDayOfMonth()==13){
            System.out.println("A data inserida é uma sexta feira 13");
        }else{
            System.out.println("A data inserida não é uma sexta feira 13");
        }

    }
}

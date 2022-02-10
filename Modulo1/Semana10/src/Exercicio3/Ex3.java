package Exercicio3;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Ex3 {

    public static void main(String[] args) {


        LocalDate inicioAno=LocalDate.of(LocalDate.now().getYear(), 1,1);

        System.out.println("Todos os primeiros sábados de cada mês neste ano de "+LocalDate.now().getYear()+":");
        for (int i=0; i<12; i++){
            for(int k=0; k< Month.of(i+1).length(LocalDate.now().isLeapYear()); k++){
                if (inicioAno.plusDays(k).plusMonths(i).getDayOfWeek()==DayOfWeek.SATURDAY){
                    System.out.println(inicioAno.plusDays(k).plusMonths(i).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    break;
                }
            }
        }
    }
}

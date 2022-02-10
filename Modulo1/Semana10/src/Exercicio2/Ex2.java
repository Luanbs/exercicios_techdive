package Exercicio2;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Ex2 {

    public static void main(String[] args) {
        LocalDateTime x= LocalDateTime.of(2022, Month.FEBRUARY, 4, 12, 0, 0);
        LocalDateTime y= LocalDateTime.of(2022, Month.FEBRUARY, 5, 14, 32, 24);

        long segVoo = ChronoUnit.SECONDS.between(x, y);
        long minVoo = ChronoUnit.MINUTES.between(x, y);
        long horaVoo = ChronoUnit.HOURS.between(x, y);

        int segDiff = y.getSecond()-x.getSecond();
        int minDiff = y.getMinute()-x.getMinute();

        System.out.println("Tempo de voo em:\n"+
                "Horas: "+horaVoo+"\nMinutos: "+minVoo+"\nSegundos: "+segVoo+"\n" +
                "\nTempo de voo total:\n" +
                "Horas:"+horaVoo+" Minutos:"+minDiff+" Segundos:"+segDiff);


    }
}

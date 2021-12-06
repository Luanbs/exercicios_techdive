package Exercicios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Semana4Ex1 {

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Boa tarde, no momento são " + dtf.format(LocalDateTime.now()));

    }

}

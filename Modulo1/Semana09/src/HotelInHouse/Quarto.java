package HotelInHouse;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public abstract class Quarto {

    //Custo dos quartos na alta temporada
    private static final double CUSTO_ALTATEMPORADA_LUXO=400;
    private static final double CUSTO_ALTATEMPORADA_SIMPLES=140;
    //Custo dos quartos na baixa temporada
    private static final double CUSTO_BAIXATEMPORADA_LUXO=150;
    private static final double CUSTO_BAIXATEMPORADA_SIMPLES=90;
    //Reserva dos quartos
    private static HashMap<LocalDate, String> reservasLuxo = new HashMap();
    private static HashMap<LocalDate, String> reservasSimples = new HashMap();

    public static double custo(LocalDate dataReserva, String tipoQuarto){
        if (dataReserva.isAfter(LocalDate.of(LocalDate.now().getYear(),10,31))
                && dataReserva.isBefore(LocalDate.of(LocalDate.now().getYear()+1, 4, 1))){
            if (tipoQuarto.equals("SIMPLES")){
                return CUSTO_ALTATEMPORADA_SIMPLES;
            }else{
                return CUSTO_ALTATEMPORADA_LUXO;
            }
        }else{
            if (tipoQuarto.equals("SIMPLES")){
                return CUSTO_BAIXATEMPORADA_SIMPLES;
            }else{
                return CUSTO_BAIXATEMPORADA_LUXO;
            }
        }
    }

    public static LocalDate conferirData(String data) throws IllegalArgumentException{

        data=data.replaceAll("[^0-9]", "");

        //LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if (data.length()==8){
            int ano=Integer.parseInt(data.substring(4,8));
            int mes=Integer.parseInt(data.substring(2,4));
            int dia=Integer.parseInt(data.substring(0,2));

            if (mes<=12 && mes>=1 && dia<=31 && dia>=1){
                LocalDate novaData=LocalDate.of(ano,mes,dia);


                if (ChronoUnit.DAYS.between(LocalDate.now(), novaData)<=60 &&
                        ChronoUnit.DAYS.between(LocalDate.now(), novaData)>0){
                    return novaData;
                }else {
                    throw new IllegalArgumentException("Reserva maior que 60 dias de antecedência ou inválida.");
                }
            }else{
                throw new InvalidParameterException("Dia e/ou mes inválido.");
            }
    }else{
            throw new InvalidParameterException("Data inválida.");
        }
    }

    public static void fazerReserva(LocalDate data, String quarto, int dias, String nome){
        if (quarto.equals("LUXO")){
            conferirReserva(data, dias, reservasLuxo, nome);
        }else{
            conferirReserva(data, dias, reservasSimples, nome);

        }

    }

    private static void conferirReserva(LocalDate data, int dias, HashMap<LocalDate, String> reserva, String nome) {
        boolean podeReservar=true;

        for (int i = 0; i<dias; i++) {
            try{
                if (!reserva.get(data.plusDays(i)).isBlank()){
                    System.out.println("Quarto alugado dia: "+data.plusDays(i)+" Por: "+nome);
                    podeReservar=false;
                }
            }catch (NullPointerException ignored){

            }
        }
        if (podeReservar){
            for (int i=0; i<dias; i++){
                reserva.put(data.plusDays(i), nome);
            }
            System.out.println("Quarto reservado com sucesso.");
        }else{
            System.out.println("Quarto indisponível na data citada.");
        }

    }

    public static void mostrarReservas() {
        String[] luxo = reservasLuxo.toString().split(",");
        String[] simples = reservasSimples.toString().split(",");

        luxo[0] = luxo[0].replace("{", " ");
        simples[0] = simples[0].replace("{", " ");
        luxo[luxo.length - 1] = luxo[luxo.length - 1].replace("}", "");
        simples[simples.length - 1] = simples[simples.length - 1].replace("}", "");


        System.out.println("Reservas do quarto de luxo:");
        for (int i = 0; i < luxo.length; i++) {
            if (luxo[i].length()!=12) {
                luxo[i] = luxo[i].replace("=", " Nome do hóspede: ");
                System.out.println("Data da reserva:" + luxo[i]);
            }
        }

        System.out.println("Reservas do quarto simples:");
        for (int i = 0; i < simples.length; i++) {
            if (simples[i].length()!=12) {
                simples[i] = simples[i].replace("=", " Nome do hóspede:");
                System.out.println("Data da reserva: " + simples[i]);
            }
        }
    }

    public static void cancelarReserva(String nome, String tipoQuarto){

        if (tipoQuarto.equals("LUXO")) {
            for (int i = 0; i<=60; i++){
                try{
                    if (reservasLuxo.get(LocalDate.now().plusDays(i)).equals(nome)){
                    reservasLuxo.put(LocalDate.now().plusDays(i), "");
                    }
                }catch (NullPointerException ignored){}
            }
        }else{
            for (int i = 0; i<=60; i++){
                try {
                    if (reservasSimples.get(LocalDate.now().plusDays(i)).equals(nome)){
                        reservasSimples.put(LocalDate.now().plusDays(i), "");
                    }
                }catch (NullPointerException ignored){}

            }

        }
    }
}

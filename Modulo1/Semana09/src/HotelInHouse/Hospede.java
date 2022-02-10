package HotelInHouse;

import java.time.LocalDate;

public class Hospede {
    private final String nome;
    private final String cpfOuRg;
    private final LocalDate dataNascimento;
    private final String tipoQuarto;

    public Hospede(String nome, String cpfOuRg, String dataNascimento, String tipoQuarto)throws IllegalArgumentException{
        this.nome=nome;
        this.tipoQuarto=tipoQuarto;
        cpfOuRg=cpfOuRg.replaceAll("[^0-9]", "");
        if (cpfOuRg.length()<6 || cpfOuRg.length()>12){
            throw new IllegalArgumentException("Cpf/Rg inválidos.");
        }else{
            this.cpfOuRg=cpfOuRg;
        }
        dataNascimento=dataNascimento.replaceAll("[^0-9]", "");


        if (dataNascimento.length()==8){
            int ano=Integer.parseInt(dataNascimento.substring(4,8));
            int mes=Integer.parseInt(dataNascimento.substring(2,4));
            int dia=Integer.parseInt(dataNascimento.substring(0,2));

            if((LocalDate.now().getYear()-ano)>=16 &&
                LocalDate.now().getYear()-ano<=110 &&
                mes<=12 && mes>=1 &&
                dia<=31 && dia>=1) {

                this.dataNascimento=LocalDate.of(ano, mes, dia);
                System.out.printf("Hospede %s cadastrado com sucesso.%n", this.nome);
            }else{
                throw new IllegalArgumentException("Idade fora do limite.");
            }
        }else{
            throw new IllegalArgumentException("Data de nascimento inválida.");
        }
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Hospede{" +
                "nome='" + nome + '\'' +
                ", cpfOuRg='" + cpfOuRg + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}

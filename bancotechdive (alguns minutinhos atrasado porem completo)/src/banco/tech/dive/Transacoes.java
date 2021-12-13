package banco.tech.dive;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Transacoes {
    int contaId1;
    int contaId2;
    String nome1;
    String nome2;
    String cpf1;
    String cpf2;
    String agencia1;
    String agencia2;
    double valor;
    DateTimeFormatter data;
    String tipo;
    public static ArrayList<Transacoes> transacoes = new <Transacoes>ArrayList();

    public Transacoes(int contaId1, int contaId2, String nome1, String nome2, String agencia1,
                         String agencia2, String cpf1, String cpf2,
                                double valor, String tipo){

        this.contaId1=contaId1;
        this.contaId2=contaId2;
        this.nome1=nome1;
        this.nome2=nome2;
        this.cpf1=cpf1;
        this.cpf2=cpf2;
        this.agencia1=agencia1;
        this.agencia2=agencia2;
        this.valor=valor;
        this.tipo=tipo;
        this.data = DateTimeFormatter.ofPattern("dd MM uuuu HH:mm");

    }

    //Onde tem if é para
    public void getExtrato(){
        System.out.println("---------------------------------------------------------------");
        System.out.println("O tipo da operação foi: "+this.tipo);
        System.out.println("O número da conta origem é: "+this.contaId1);
        if(this.contaId2>0) {
            System.out.println("O número da conta destino é: "+this.contaId2);
        }
        System.out.println("O nome do proprietário da conta origem é: "+this.nome1);
        if(!this.nome2.isEmpty()){
            System.out.println("O nome do proprietário da conta destino é: "+this.nome2);
        }
        System.out.println("O cpf do proprietário da conta origem é: "+this.cpf1);
        if(!this.cpf2.isEmpty()){
            System.out.println("O cpf do proprietário da conta destino é: "+this.cpf2);
        }

        System.out.printf("O valor da operação foi: %.2f%n", this.valor);
        System.out.println("A data da operacao foi: "+this.data.format(LocalDateTime.now()));
        System.out.println("---------------------------------------------------------------");



    }

}

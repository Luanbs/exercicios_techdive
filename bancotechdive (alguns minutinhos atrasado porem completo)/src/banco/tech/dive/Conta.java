package banco.tech.dive;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//Abstract class pois as outras contas farão extends a partir dessa.
public abstract class Conta {
    //Atributos gerais
    private String nome;
    private String cpf ;
    private double rendaMensal;
    private int contaId;
    private String agencia;
    //todas as contas iniciam com saldo R$1000.00 para facilitar os testes.
    private double saldo=1000.00;
    public static ArrayList<Conta> conta = new <Conta>ArrayList();


    //getters


    public double getRendaMensal() {
        return rendaMensal;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getContaId() {
        return contaId;
    }

    public String getAgencia() {
        return agencia;
    }

    //setters
    protected void setNome(String nome) {
        this.nome = nome;
    }
    protected void setCpf(String cpf) {this.cpf = cpf;}
    protected void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }
    protected void setConta(int conta) {this.contaId = conta;}
    protected void setAgencia(String agencia) {this.agencia = agencia;}
    protected void setSaldo(double saldo) {this.saldo = saldo;}
//Metodos gerais:


    //Sacar apenas se o valor está disponível
    public void saque(double valorSaque){
        if(valorSaque<=this.saldo && valorSaque>0){
            this.saldo -=valorSaque;
            System.out.printf("Saque de %.2f realizado com sucesso.%n", valorSaque);

        }else if(valorSaque>this.saldo){
            System.out.println("Valor indisponível para saque");

        }else{
            System.out.println("Digite apenas números positivos");

        }

    }

    public void deposito(double valorDeposito) {
        if (valorDeposito > 0) {
            this.saldo += valorDeposito;
            System.out.printf("Deposito de %.2f realizado com sucesso.%n", valorDeposito);
        }else{
            System.out.println("Digite apenas números positivos diferentes de 0");
        }
    }

    public double getSaldo(){return this.saldo;}

    public void extrato(){

    }

    public void transferir(double valorTransferencia, int contaDestino){
        if(valorTransferencia<=this.saldo && valorTransferencia>0){
            this.saldo -=valorTransferencia;
            conta.get(contaDestino).saldo += valorTransferencia;
            System.out.printf("Transferencia de %.2f realizada com sucesso.%n", valorTransferencia);
        }else if(valorTransferencia>this.saldo){
            System.out.println("Valor indisponível para transferencia");

        }else {
            System.out.println("Digite apenas números positivos");
        }

    }

    public void alterarCadastro(){

    }

//    public static void main(String[] args) {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM uuuu HH:mm");
//        System.out.println("Boa tarde, no momento são " + dtf.format(LocalDateTime.now()));
//
//    }

}

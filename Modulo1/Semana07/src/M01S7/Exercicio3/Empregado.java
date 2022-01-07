package M01S7.Exercicio3;

import M01S7.Exercicio1.Pessoa;

public class Empregado extends Pessoa {
    private int codigoSetor;
    private double salarioBase;
    private double impostos;

    public int getCodigoSetor() {
        return codigoSetor;
    }

    public void setCodigoSetor(int codigoSetor) {
        this.codigoSetor = codigoSetor;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getImpostos() {
        return impostos;
    }

    public void setImpostos(double impostos) {
        this.impostos = impostos;
    }

    public Empregado(String nome, String endereco, String telefone, int codigoSetor, double salarioBase, double impostos) {
        super(nome, endereco, telefone);
        this.codigoSetor = codigoSetor;
        this.salarioBase = salarioBase;
        this.impostos = impostos;
    }

    public Empregado(String nome, String endereco, int codigoSetor, double salarioBase, double impostos) {
        super(nome, endereco);
        this.codigoSetor = codigoSetor;
        this.salarioBase = salarioBase;
        this.impostos = impostos;
    }

    public Empregado(int codigoSetor, double salarioBase, double impostos) {
        this.codigoSetor = codigoSetor;
        this.salarioBase = salarioBase;
        this.impostos = impostos;
    }

    public double calcularSalario(){
        double salario =getSalarioBase()-(getImpostos()*getSalarioBase())/100;
        return salario;
    }

    public static void main(String[] args) {
        Empregado empregado = new Empregado(1, 1000, 9.7);
        System.out.println(empregado.calcularSalario());

    }
}

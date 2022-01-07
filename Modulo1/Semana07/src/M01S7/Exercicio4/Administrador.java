package M01S7.Exercicio4;

import M01S7.Exercicio3.Empregado;

public class Administrador extends Empregado {
    private double ajudaDeCusto;

    public double getAjudaDeCusto() {
        return ajudaDeCusto;
    }

    public void setAjudaDeCusto(double ajudaDeCusto) {
        this.ajudaDeCusto = ajudaDeCusto;
    }

    public Administrador(String nome, String endereco, String telefone, int codigoSetor, double salarioBase, double impostos, double ajudaDeCusto) {
        super(nome, endereco, telefone, codigoSetor, salarioBase, impostos);
        this.ajudaDeCusto = ajudaDeCusto;
    }

    public Administrador(String nome, String endereco, int codigoSetor, double salarioBase, double impostos, double ajudaDeCusto) {
        super(nome, endereco, codigoSetor, salarioBase, impostos);
        this.ajudaDeCusto = ajudaDeCusto;
    }

    public Administrador(int codigoSetor, double salarioBase, double impostos, double ajudaDeCusto) {
        super(codigoSetor, salarioBase, impostos);
        this.ajudaDeCusto = ajudaDeCusto;
    }

    @Override
    public double calcularSalario(){
        double salario =getSalarioBase()-(getImpostos()*getSalarioBase())/100;
        return salario+getAjudaDeCusto();
    }

    public static void main(String[] args) {
        Administrador administrador = new Administrador(1, 1000, 7.12,252.78);
        System.out.println(administrador.calcularSalario());
    }
}

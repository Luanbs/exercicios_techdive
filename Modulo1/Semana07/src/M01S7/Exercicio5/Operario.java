package M01S7.Exercicio5;

import M01S7.Exercicio3.Empregado;

public class Operario extends Empregado {
    
    private double valorProducao;
    private double comissao;

    public Operario(String nome, String endereco, String telefone, int codigoSetor, double salarioBase, double impostos, double valorProducao) {
        super(nome, endereco, telefone, codigoSetor, salarioBase, impostos);
        this.valorProducao = valorProducao;
        this.comissao = valorProducao*0.35;
    }

    public Operario(String nome, String endereco, int codigoSetor, double salarioBase, double impostos, double valorProducao) {
        super(nome, endereco, codigoSetor, salarioBase, impostos);
        this.valorProducao = valorProducao;
        this.comissao = valorProducao*0.35;
    }

    public Operario(int codigoSetor, double salarioBase, double impostos, double valorProducao) {
        super(codigoSetor, salarioBase, impostos);
        this.valorProducao = valorProducao;
        this.comissao = valorProducao*0.35;
    }

    public double getValorProducao() {
        return valorProducao;
    }

    public void setValorProducao(double valorProducao) {
        this.valorProducao = valorProducao;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public double calcularSalario() {
        return getComissao()+getSalarioBase();
    }

    public static void main(String[] args) {
        Operario operario = new Operario(1, 1000, 7.7, 335);

        System.out.println(operario.calcularSalario());
        System.out.println(operario.getCodigoSetor());
        System.out.println(operario.getNome());
    }

}

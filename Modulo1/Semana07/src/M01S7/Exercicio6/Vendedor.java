package M01S7.Exercicio6;

import M01S7.Exercicio3.Empregado;

public class Vendedor extends Empregado {

        private double valorVendas;
        private double comissao;

        public Vendedor(String nome, String endereco, String telefone, int codigoSetor, double salarioBase, double impostos, double valorVendas) {
            super(nome, endereco, telefone, codigoSetor, salarioBase, impostos);
            this.valorVendas = valorVendas;
            this.comissao = valorVendas*0.35;
        }

        public Vendedor(String nome, String endereco, int codigoSetor, double salarioBase, double impostos, double valorVendas) {
            super(nome, endereco, codigoSetor, salarioBase, impostos);
            this.valorVendas = valorVendas;
            this.comissao = valorVendas*0.35;
        }

        public Vendedor(int codigoSetor, double salarioBase, double impostos, double valorVendas) {
            super(codigoSetor, salarioBase, impostos);
            this.valorVendas = valorVendas;
            this.comissao = valorVendas*0.35;
        }

        public double getValorVendas() {
            return valorVendas;
        }

        public void setValorVendas(double valorVendas) {
            this.valorVendas = valorVendas;
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
            Vendedor vendedor = new Vendedor(1, 1000, 7.95, 547);
            System.out.println(vendedor.calcularSalario());
            System.out.println(vendedor.getCodigoSetor());
            System.out.println(vendedor.getNome());
        }

    }

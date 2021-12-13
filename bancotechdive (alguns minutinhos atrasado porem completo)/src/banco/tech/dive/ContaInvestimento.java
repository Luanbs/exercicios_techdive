package banco.tech.dive;

public class ContaInvestimento extends Conta{
//    1 - Tesouro direto 10,34% de rendimento anual
//    2 - Fundos Multimercado 7,45% de rendimento anual
//    3 - Fundos Imobiliario 11,78% de rendimento anual
    int tipoInvestimento;
    double valorInvestido;

    public double getValorInvestido() {
        return valorInvestido;
    }

    public ContaInvestimento(String nome, String cpf, double rendaMensal, String agencia, int conta, int tipoInvestimento) {
        setNome(nome);
        setCpf(cpf);
        setRendaMensal(rendaMensal);
        setAgencia(agencia);
        setConta(conta);
        this.tipoInvestimento=tipoInvestimento;
    }

    public void simulacaoInvestimento(double valorInvestimento) {
        switch (this.tipoInvestimento) {
            case 1 -> System.out.printf("Valor de rentabilidade do tesouro direto anual com %.2f investido: %.2f%n",
                    valorInvestimento, (valorInvestimento * Math.pow(1.1034, 12)));
            case 2 -> System.out.printf("Valor de rentabilidade do Fundos Multimercado anual com %.2f investido: %.2f%n",
                    valorInvestimento, (valorInvestimento * Math.pow(1.0745, 12)));
            case 3 -> System.out.printf("Valor de rentabilidade do Fundos Imobiliarios anual com %.2f investido: %.2f%n",
                    valorInvestimento, (valorInvestimento * Math.pow(1.1178, 12)));
        }
    }
    public void investir (double valorInvestido){
        switch (this.tipoInvestimento) {
            case 1 -> {
                System.out.printf("Você investiu %.2f no Tesouro direto com um rendimento de %.2f anual%n",
                        valorInvestido, (valorInvestido *Math.pow(1.1034, 12)));
                this.valorInvestido=valorInvestido;
            }
            case 2 -> {
                System.out.printf("Você investiu %.2f nos Fundos Multimercado com um rendimento de %.2f anual%n",
                        valorInvestido, (valorInvestido *Math.pow(1.0745, 12)));
                this.valorInvestido=valorInvestido;
            }
            case 3 -> {
                System.out.printf("Você investiu %.2f nos Fundos Imobiliarios com um rendimento de %.2f anual%n",
                        valorInvestido, (valorInvestido *Math.pow(1.1178, 12)));
                this.valorInvestido=valorInvestido;
            }
        }

    }


}

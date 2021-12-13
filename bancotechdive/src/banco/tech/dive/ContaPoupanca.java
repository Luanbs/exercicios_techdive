package banco.tech.dive;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(String nome, String cpf, double rendaMensal, String agencia, int conta) {
        setNome(nome);
        setCpf(cpf);
        setRendaMensal(rendaMensal);
        setAgencia(agencia);
        setConta(conta);
    }

    public void getRendimento(int mesesRendimento){
        System.out.printf("O rendimento em %d meses do seu saldo %.2f é:%n", mesesRendimento, this.getSaldo());
        double rendimentoPoupanca = (Math.pow(1.05, mesesRendimento))*this.getSaldo();
        System.out.printf("%.2f%n", rendimentoPoupanca);

    }
}

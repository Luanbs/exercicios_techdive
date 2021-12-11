package banco.tech.dive;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(String nome, String cpf, double rendaMensal, String agencia, int conta) {
        setNome(nome);
        setCpf(cpf);
        setRendaMensal(rendaMensal);
        setAgencia(agencia);
        setConta(conta);
    }
}

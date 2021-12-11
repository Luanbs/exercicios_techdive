package banco.tech.dive;

public class ContaCorrente extends Conta{

    public ContaCorrente(String nome, String cpf, double rendaMensal, String agencia, int conta) {
        setNome(nome);
        setCpf(cpf);
        setRendaMensal(rendaMensal);
        setAgencia(agencia);
        setConta(conta);
    }
}

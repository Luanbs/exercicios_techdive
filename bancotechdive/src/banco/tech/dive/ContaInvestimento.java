package banco.tech.dive;

public class ContaInvestimento extends Conta{

    public ContaInvestimento(String nome, String cpf, double rendaMensal, String agencia, int conta) {
        setNome(nome);
        setCpf(cpf);
        setRendaMensal(rendaMensal);
        setAgencia(agencia);
        setConta(conta);
    }
}

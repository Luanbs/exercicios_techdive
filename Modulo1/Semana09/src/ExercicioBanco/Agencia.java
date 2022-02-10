package ExercicioBanco;

public class Agencia {

    public static Conta  buscaPorTitular(String nomeDoTitular) {
        for (Conta conta : Conta.contas) {
            if (conta.getNome().equalsIgnoreCase(nomeDoTitular)) {return conta;}
        }
        return null;
    }

    public static void main(String[] args) {
        for(int i=0; i<50; i++) {
            Conta.adiciona(new ContaCorrente("Conta "+i));
            Conta.adiciona(new ContaPoupanca("Conta "+"00"+i));
        }

        System.out.println("Quantidade de contas é: "+Conta.getQuantidadeContas());

        System.out.println(buscaPorTitular("CoNtA 5").getNome());
        System.out.println(buscaPorTitular("conta 004").getNome());
    }


}

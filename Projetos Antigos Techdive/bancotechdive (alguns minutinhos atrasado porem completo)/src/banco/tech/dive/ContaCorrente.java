package banco.tech.dive;

public class ContaCorrente extends Conta{
    //possivel ficar negativado 30% o salário
    public double taxaCheque = 0.3;

    public ContaCorrente(String nome, String cpf, double rendaMensal, String agencia, int conta) {
        setNome(nome);
        setCpf(cpf);
        setRendaMensal(rendaMensal);
        setAgencia(agencia);
        setConta(conta);
    }

    //Sacar apenas se o valor está disponível ou de acordo com o cheque especial
    @Override
    public void saque(double valorSaque){
        double valorCheque=taxaCheque*getRendaMensal();

        if(valorSaque<=this.getSaldo() && valorSaque>0){
            this.setSaldo(getSaldo()-valorSaque);
            System.out.printf("Saque de %.2f realizado com sucesso.%n", valorSaque);

        }else if(valorSaque>this.getSaldo() && valorSaque<=(this.getSaldo()+ valorCheque)){
            System.out.printf("Saldo insuficiente para saque normal, realizado saque com cheque especial." +
                    " Saque de %.2f realizado com sucesso.%n" +
                    " Você está com %.2f negativado %n", valorSaque, (valorSaque-this.getSaldo()));
            this.setSaldo(getSaldo()-valorSaque);

        }else if (valorSaque>(this.getSaldo()+ valorCheque)) {
            System.out.println("O valor excede o limite do cheque especial");

        }else{
            System.out.println("Digite apenas números positivos");


        }

    }
    @Override
    public void transferir(double valorTransferencia, int contaDestino){
        double valorCheque=taxaCheque*getRendaMensal();
        if(valorTransferencia<=this.getSaldo() && valorTransferencia>0){
            this.setSaldo(getSaldo()-valorTransferencia);
            conta.get(contaDestino).setSaldo(conta.get(contaDestino).getSaldo() + valorTransferencia);
            System.out.printf("Transferência de %.2f realizada com sucesso.%n", valorTransferencia);

        }else if(valorTransferencia>this.getSaldo() && valorTransferencia<=(this.getSaldo()+ valorCheque)){
            System.out.printf("Saldo insuficiente para saque normal, realizado saque com cheque especial." +
                    " Saque de %.2f realizado com sucesso." +
                    " Você está com %.2f negativado %n", valorTransferencia, (valorTransferencia-this.getSaldo()));
            this.setSaldo(getSaldo()-valorTransferencia);
            conta.get(contaDestino).setSaldo(conta.get(contaDestino).getSaldo() + valorTransferencia);

        }else if (valorTransferencia>(this.getSaldo()+ valorCheque)) {
            System.out.println("O valor excede o limite do cheque especial");

        }else{
            System.out.println("Digite apenas números positivos");


        }

    }
}

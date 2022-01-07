package projeto.ferias;

import static projeto.ferias.Main.colaboradores;

public class GerenteGeral extends GerenteDepartamento{



    public GerenteGeral(String nome, String cpf) {
        super(nome, cpf);
        super.cargo="Gerente Geral";
    }

    public void demitir(int nomeDemissao){
        colaboradores.get(nomeDemissao).setTrabalhando(false);

        System.out.println("Colaborador demitido com sucesso.");
    }
}

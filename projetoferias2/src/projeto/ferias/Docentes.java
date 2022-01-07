package projeto.ferias;

import java.util.ArrayList;

public class Docentes {

    private int id;
    private String nomeDocente;
    private String turmasAtendidas;
    private ArrayList<String> diasAulas = new ArrayList<String>(52);

    public Docentes(String nomeDocente, int id) {
        this.nomeDocente = nomeDocente;
        this.id = id;

        for (int i=0; i<=52; i++){
            diasAulas.add("");
        }
    }

    public int getId() {
        return id;
    }

    public String getNomeDocente() {
        return nomeDocente;
    }

    public String getTurmasAtendidas() {
        return turmasAtendidas;
    }

    public boolean verificarDiasAulas(int semana, String aula){
        try {
            if (diasAulas.get(semana).isBlank() || diasAulas.get(semana).isEmpty()) {
                return true;
            } else if (diasAulas.get(semana).equals("SeT") && aula.equals("QQeS")) {
                return true;
            } else if (diasAulas.get(semana).equals("QQeS") && aula.equals("SeT")) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            return true;
        }
    }

    public void alterarDiasAulas(int semana, String aula){
        try{
            if (diasAulas.get(semana).isBlank() || diasAulas.get(semana).isEmpty()) {
                diasAulas.add(semana, aula);
            } else if (diasAulas.get(semana).equals("SeT") && aula.equals("QQeS")) {
                diasAulas.add(semana, aula);
            } else if (diasAulas.get(semana).equals("QQeS") && aula.equals("SeT")) {
                diasAulas.add(semana, aula);
            }
        }catch (Exception e){
            diasAulas.add(semana,aula);
        };
    }

   public String getDiasAulas(int i){
        return diasAulas.get(i);
   }

}

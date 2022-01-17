package battlepckg;

public enum ArmasEnum {
    ESPADA("Espada", "Guerreiro",5),
    MACHADO("Machado", "Guerreiro",5),
    MARTELO("Martelo", "Paladino",5),
    CLAVA("Clava","Paladino",5),
    ARCO("Arco", "Arqueiro",5),
    BESTA("Besta", "Arqueiro",5),
    CAJADO("Cajado", "Mago",5),
    LIVRODEMAGIAS("Livro de magias", "Mago",5),
    ARMADILHA("Armadilha", "Armadilha",2),
    MACHADODUPLO("Machado duplo", "Líder", 7);

    String idArma;
    String quemUsa;
    int danoArma;

     ArmasEnum(String idArma, String quemUsa, int danoArma){
         this.idArma=idArma;
         this.quemUsa=quemUsa;
         this.danoArma=danoArma;

    }

    public String getIdArma(){return idArma;}
    public String getQuemUsa(){return quemUsa;}

}


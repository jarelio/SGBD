package indexselection;

public class Tupla {
    int qtd_cols;
    String[] cols;
    
    public Tupla(String[] tupla){
        qtd_cols = tupla.length;
        cols = tupla;
    }

}

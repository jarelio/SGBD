package indexselection;

public class Pagina {
    Tupla[] tuplas;
    int qtd_tuplas_ocup;
    
    public Pagina(){
        qtd_tuplas_ocup = 0;
        tuplas = new Tupla[12];
    }
    //Adiciona uma tupla ao vetor tuplas passando seus valores 
    public void addTupla(String [] tup){
        if(this.qtd_tuplas_ocup<12){
            qtd_tuplas_ocup++;
            Tupla t = new Tupla(tup);
            tuplas[qtd_tuplas_ocup-1] = t;
        }
    }
    //Verifica se na pagina a quantidade de tuplas excede ou eh igual a 12
    public boolean tem_espaço(){
        return qtd_tuplas_ocup < tuplas.length;
    }
}

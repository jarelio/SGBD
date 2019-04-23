package indexselection;

import java.util.LinkedList;

public class Tabela {
    LinkedList<Pagina> pags;
    Pagina pag;
    int qtd_pags;
    Esquema esquema;
    Tupla t;
    
    public Tabela(String[] cols){
        pags = new LinkedList<>();
        qtd_pags = 0;
        t = new Tupla(cols);
        esquema = new Esquema(cols);
    }
    
    //Construtor utilizado para criar a tabela_resultado que possui o mesmo esquema da tabela original
    public Tabela() {
        pags = new LinkedList<>();
        qtd_pags = 0;
    }
    
    public void inserirTupla(String[] tupla){
        //Se o vetor de paginas de uma tabela estiver vazio, insere uma pagina vazia
        if(pags.isEmpty()){
            pag = new Pagina();
            pags.add(pag);
            qtd_pags++;
        }
        
        //Pega a ultima pagina inserida no vetor de paginas de uma tabela
        pag = pags.getLast();
        
        //Se a pagina tiver espaço insere a tupla, senao cria uma nova pagina e insere a tupla nela
        if(pag.tem_espaço()){
            pag.addTupla(tupla);
        }else{
            pag = new Pagina();
            pags.add(pag);
            qtd_pags++;
            pag.addTupla(tupla);
        }
    }
  
}

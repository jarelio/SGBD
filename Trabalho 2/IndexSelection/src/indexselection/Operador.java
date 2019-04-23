package indexselection;

import java.util.ArrayList;

class Operador {
    //Tabela resultado que ira conter as tuplas que satisfazem a condicao de selecao
    Tabela tabela_result;
    //Tabela original
    Tabela tabela;
    //Coluna a qual será aplicada a condicao
    String col;
    //Condicao a ser aplicada
    String condicao;
    int num_tuplas;
    int num_pags;
    ArrayList<String[]> tuplas_geradas;
    
    public Operador(Tabela tabela, String nome_col, String cond){
        this.tabela = tabela;
        this.col = nome_col;
        this.condicao = cond;
        this.num_tuplas = 0;
        this.num_pags = 0;
        this.tabela_result = new Tabela();
        //Tabela resultado possui o mesmo esquema da tabela original na selecao, pois a alteracao eh na quantidade de tuplas
        this.tabela_result.esquema = tabela.esquema;
        this.tuplas_geradas = new ArrayList<>();
    }
    
    public int numTuplasGeradas() {
        return this.num_tuplas;
    }

    public int numPagsGeradas() {
        return this.num_pags;
    }
    
    public ArrayList<String[]> tuplasGeradas(){
        return this.tuplas_geradas;
    }
    
    public void executar(){
        //Coluna recebe o valor inteiro contido no hash referente a coluna usada na selecao
        Object coluna = this.tabela.esquema.hash.get(this.col);
        
        if(coluna == null){
            System.out.println("A tabela não possui essa coluna");
        }else{
            int coluna_2 = (int) coluna;
            //Para cada pagina na tabela escolhida
            for(Pagina p : tabela.pags){
                //Para cada tupla na pagina da tabela escolhida
                for(int i = 0; i<p.qtd_tuplas_ocup; i++){
                    Tupla t = p.tuplas[i];
                    //Verifica se o valor da tupla referente a coluna que sera aplicada a condicao eh igual a condicao
                    if((t.cols[coluna_2]).equals(this.condicao)){
                        //Insere a tupla na tabela resultado
                        this.tabela_result.inserirTupla(t.cols);
                        this.num_tuplas++;
                        this.tuplas_geradas.add(t.cols);
                    }
                }
            }
        }
        this.num_pags = this.tabela_result.qtd_pags;
    }
        
}

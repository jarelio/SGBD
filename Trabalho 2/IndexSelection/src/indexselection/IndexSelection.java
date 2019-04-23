package indexselection;

import java.util.ArrayList;

public class IndexSelection {

    public static void main(String[] args) {
        String[] vinho_cols = {"vinho_id", "rotulo", "ano_colheita", "pais_producao_id", "uva_id"};
        String[] uva_cols   = {"uva_id", "nome", "tipo", "pais_origem_id"};
        String[] pais_cols  = {"pais_id", "nome"};

        Tabela vinho = new Tabela(vinho_cols);
        Tabela uva   = new Tabela (uva_cols);
        Tabela pais  = new Tabela (pais_cols);

        pais.inserirTupla(new String[] {"0", "Brasil"});
        pais.inserirTupla(new String[] {"1", "Franca"});
        pais.inserirTupla(new String[] {"2", "Italia"});

        uva.inserirTupla(new String[] {"0", "uva0", "tinto",  "0"});
        uva.inserirTupla(new String[] {"1", "uva1", "branco", "1"});
        uva.inserirTupla(new String[] {"2", "uva2", "tinto",  "2"});

        vinho.inserirTupla(new String[] {"0", "vinho0", "1990", "0", "0"});      
        vinho.inserirTupla(new String[] {"1", "vinho1", "1991", "1", "0"});
        vinho.inserirTupla(new String[] {"2", "vinho2", "1992", "2", "2"});
       
        // SELECAO:
        
        Operador op = new Operador(vinho, "rotulo", "vinho0"); // representa SELECT * FROM Vinho WHERE rotulo=vinho0

        op.executar(); // Realiza a operacao desejada.

        int num_tuplas  = op.numTuplasGeradas(); // Retorna a quantidade de tuplas geradas pela operacao.
        int num_pags    = op.numPagsGeradas();  // Retorna a quantidade de paginas geradas pela operacao.

        ArrayList<String[]> tuplas = op.tuplasGeradas(); // Retorna as tuplas geradas pela operacao.
        
        System.out.println("Número de Tuplas geradas: "+ num_tuplas);
        System.out.println("Número de Páginas geradas: "+ num_pags);
        System.out.println("Tuplas geradas: ");
   
        
        //Para cada tupla (String[]) no ArrayList tuplas (ArrayList de String[]), printa os valores das colunas da tupla (String[])
        for(String[] tuplas_s : tuplas){
            for(String valor_coluna_tupla : tuplas_s){
                System.out.print(valor_coluna_tupla+ " ");
            }
            System.out.println("");
        }
    }

}

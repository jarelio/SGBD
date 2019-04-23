package indexselection;

import java.util.HashMap;

public class Esquema {
    int qtd_cols;
    HashMap hash;
    
    public Esquema(String[] cols){
        qtd_cols = cols.length;
        hash = new HashMap<String, Integer>();
        
        for(int i = 0; i < qtd_cols; i++){  
            hash.put(cols[i], i);
        }
    }
}

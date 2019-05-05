package buffermanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedList;

class Entry {
	String value;
	int key;
}

public class LRU implements Functions{
    
    HashMap<Integer,Entry> cachelist;
    int cachemiss, cachehit;
    LinkedList list;
    Object removed;
    LinkedList lista_insercao;
    
    public LRU(){ 
        this.cachemiss = 0;
        this.cachehit = 0;
        this.cachelist = new HashMap<>();
        this.list = new LinkedList();
        this.lista_insercao = new LinkedList();
    }
            
    @Override
    public String fetch(int key) {
        if(cachelist.containsKey(key)){
            System.out.println("Entrada encontrada. Key: "+ cachelist.get(key).value);
        }
        /*Função hashmap*/
        int count = 0;
        try{
            FileReader arq = new FileReader("arquivo.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine(); 
            
            do{ //lê todo o arquivo de texto
                count++;
                if(count == key && !cacheCheio() && !cachelist.containsKey(key)){
                 
                    Entry newnode = new Entry();
                    newnode.value = linha;
                    newnode.key = key;
                    cachelist.put(key, newnode);
                    cachemiss++;
                    list.addLast(newnode);
                }else if(count == key && !cacheCheio() && cachelist.containsKey(key)){
                    
                    cachehit++;
                    Entry node = cachelist.get(key);
                    list.remove(node);
                    list.addLast(node);
                    //não insere o valor e atualiza o cache_hit, pois a chave já está no cache
                }else if(count == key && cacheCheio() && !cachelist.containsKey(key)){
                    
                    //política LRU
                    cachemiss++;
                    Entry newnode = new Entry();
                    newnode.value = linha;
                    newnode.key = key;
                    Entry removed = (Entry) list.poll();
                    cachelist.remove(removed.key);
                    cachelist.put(key, newnode);
                    list.addLast(newnode);
                }else if(count == key && cacheCheio() && cachelist.containsKey(key)){
                    cachehit++;
                    Entry node = cachelist.get(key);
                    list.remove(node);
                    list.addLast(node);
                    //não insere o valor e atualiza o cache_hit, pois a chave já está no cache
                }
                linha = lerArq.readLine();
                
            }while(linha != null);
            printa_lista();
        } catch (IOException ex) {
            Logger.getLogger(MRU.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    @Override
    public void evict() {
        //a depender da política
        if(!(cachelist.isEmpty())){
            Entry removed = (Entry) list.removeFirst();
            cachelist.remove(removed.key);
            System.out.println("Página removida: "+ removed.key);
        }else{
            System.out.println("Cache Vazio");
        }
    }

    @Override
    public void display_cache() {
        Collection<Entry> entradas = getCache().values();
        System.out.print("{ ");
        for(Entry entrada : entradas){
            System.out.print(entrada.key + "- "+entrada.value + " ");
        }
        System.out.println(" }");
    }

    @Override
    public void display_stats() {
        System.out.println("Cache Hit: " + this.getCacheHit());
        System.out.println("Cache Miss: " + this.getCacheMiss());
    }

    public boolean cacheCheio() {
        return cachelist.size() == 5;
    }
    
    public int getCacheHit(){
        return this.cachehit;
    }
    
    public int getCacheMiss(){
        return this.cachemiss;
    }
    
    public HashMap<Integer, Entry> getCache(){
        return this.cachelist;
    }

    private void printa_lista() {
        System.out.print("{ ");
        for (Iterator it = list.iterator(); it.hasNext();) {
            Entry s = (Entry) it.next();
            System.out.print(s.key + ", ");
        }
        System.out.println(" }");
    }
 
}

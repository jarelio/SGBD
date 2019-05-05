package buffermanagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedList;

public class FIFO implements Functions{
    private HashMap<Integer,String> cache_list;
    private int cache_hit, cache_miss;
    private LinkedList list;
    private Object removed;
    
    public FIFO(){
        this.cache_hit = 0;
        this.cache_miss = 0;
        this.cache_list = new HashMap();
        this.list = new LinkedList();
    }

    @Override
    public String fetch(int key) {
        if(listaCheia()){
            list.removeLast();
        }
        int count = 0;
        if(cache_list.containsKey(key))
            System.out.println("Entrada encontrada. Valor da entrada: "+cache_list.get(key));
        try {
            FileReader arq = new FileReader("arquivo.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
          
            do{ //lê todo o arquivo de texto
                count++;
                if(count == key && !cacheCheio() && !cache_list.containsKey(key)){
                    cache_miss++;
                    cache_list.put(key, linha);
                    list.addLast(key);
                }else if(count == key && !cacheCheio() && cache_list.containsKey(key)){
                    cache_hit++;
                    //não insere o valor e atualiza o cache_hit, pois a chave já está no cache
                }else if(count == key && cacheCheio() && !cache_list.containsKey(key)){
                    cache_miss++;
                    evict();
                    list.addLast(key);
                    cache_list.put(key, linha);
                }else if(count == key && cacheCheio() && cache_list.containsKey(key)){
                    cache_hit++;
                    list.addLast(key);
                    //não insere o valor e atualiza o cache_hit, pois a chave já está no cache
                }
                linha = lerArq.readLine();
                
            }while(linha != null);
        System.out.println(list);
        }catch (IOException ex) {
            Logger.getLogger(FIFO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public void evict() {
        if(!(cache_list.isEmpty())){
            removed = list.poll();
            if(cache_list.containsKey(removed)){
                cache_list.remove(removed);
                System.out.println("Página removida: "+ removed);
            }else{
                evict();
            }
        }else{
            System.out.println("Cache Vazio");
        }
    }

    @Override
    public void display_cache() {
        System.out.println(getCache());
    }

    @Override
    public void display_stats() {
        System.out.println("Cache Miss: "+getCacheMiss()+"\n"+"Cache Hit: "+getCacheHit());
    }

    @Override
    public boolean cacheCheio() {
        return cache_list.size() == 5;
    }

    @Override
    public int getCacheHit() {
        return this.cache_hit;
    }

    @Override
    public int getCacheMiss() {
        return this.cache_miss;
    }
    
    public HashMap<Integer, String> getCache() {
        return this.cache_list;
    }
    
    private boolean listaCheia(){
        return list.size() == 6;
    }
    
}

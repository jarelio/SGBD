/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package policys;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author jarelio
 */
public class MRU {
    
    private HashMap<Integer,String> cache_list;
    private int cache_miss, cache_hit;
    private LinkedList list;
    private Object removed;
    
    public MRU(){ 
        this.cache_miss = 0;
        this.cache_hit = 0;
        this.cache_list = new HashMap<>();
        this.list = new LinkedList();
    }
    
    
}

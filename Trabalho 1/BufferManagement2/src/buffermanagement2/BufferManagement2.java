/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffermanagement2;

import policys.*;

/**
 *
 * @author jarelio
 */
public class BufferManagement2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LRU lru_cache = new LRU();
        FIFO fifo_cache = new FIFO();
        MRU mru_cache = new MRU();
        CLOCK clock_cache = new CLOCK();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buffermanagement;

/**
 *
 * @author jarelio
 */
public interface Functions {
    String fetch(int key);
    void evict();
    void display_cache();
    void display_stats();
    boolean cacheCheio();
    int getCacheHit();
    int getCacheMiss();
}

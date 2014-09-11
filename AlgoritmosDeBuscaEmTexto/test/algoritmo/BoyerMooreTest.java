/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

/**
 *
 * @author Jomar
 */
public class BoyerMooreTest {
    
    public static void main (String[] args){
        BoyerMoore b = new BoyerMoore();
        String padrao = "ab";
        String texto ="abcdab";
      
       b.buscar(padrao, texto).toString();
       System.out.println(b.buscar(padrao, texto));
       System.out.println(b.getQtdComparacoes());
       
    }
    
}

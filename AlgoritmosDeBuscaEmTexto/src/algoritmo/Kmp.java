/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Kmp extends AlgoritmoDeBusca {

    @Override
    public List<Integer> buscar(String padrao, String texto) {
        resetQtdComparacoes();
        return new ArrayList<>();
    }
    
    public int[] preProcessamento(String padrao) {
        int[] next = new int[padrao.length()];
        next[0] = 0;
        int m = padrao.length();
        int j = 0;
        int i = 1;
        while (i < m) {
            if (padrao.charAt(j) == padrao.charAt(i)) {
                next[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1];
            } else { 
                next[i] = 0;
                i++;
            }
        }
        return next;
    }
}


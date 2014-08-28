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
        int m = padrao.length();
        int[] next = new int[m];
        next[0] = -1;
        next[1] = 0;
        for (int i = 2; i <= m - 1 ; i++) {
            int j = next[i - 1] + 1;
            while (padrao.charAt(i - 1) != padrao.charAt(j) && j > 0) {                
                j = next[j] + 1;
            }            
            next[i] = j;
        }
        return next;
    }

//    public int[] preProcessamento(String padrao) {
//        int m = padrao.length();
//        int[] pkmp = new int[m];
//        pkmp[0] = 0;
//        for (int k = 0; k < m - 1; k++) {
//            char c = padrao.charAt(k + 1);
//            int v = pkmp[k];
//            while (padrao.charAt(v + 1) != c && v != 0) {
//                v = pkmp[v];
//            }
//            if (padrao.charAt(v + 1) == c) {
//                pkmp[k + 1] = v + 1;
//            } else {
//                pkmp[k + 1] = 0;
//            }
//        }
//        return pkmp;
//    }
}

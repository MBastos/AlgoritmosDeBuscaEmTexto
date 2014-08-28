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

    public Integer[] preProcessamento(String padrao) {
        int m = padrao.length();
        Integer[] pkmp = new Integer[m];
        for (int i = 0; i < m; i++) {
            pkmp[i] = 0;
        }
        pkmp[0] = 0;
        for (int k = 1; k < m - 2; k++) {
            char c = padrao.charAt(k + 1);
            int v = pkmp[k];
            while (padrao.charAt(v + 1) != c && v != 0) {
                v = pkmp[v];
            }
            if (padrao.charAt(v + 1) == c) {
                    pkmp[k + 1] = v + 1;
                } else {
                    pkmp[k + 1] = 0;
                }

            //pkmp[k] = v;
        }
        return pkmp;
    }

}

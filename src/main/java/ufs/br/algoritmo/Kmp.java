/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufs.br.algoritmo;

import java.util.ArrayList;
import java.util.List;

public class Kmp extends AlgoritmoDeBusca {

    private int[] preProcessamento(String padrao) {
        int m = padrao.length();
        int[] next = new int[m];
        if (m > 0) {
            next[0] = 0;
        }
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


    @Override
    public List<Integer> buscar(String padrao, String texto) {
        padrao = padrao.toLowerCase();
        texto = texto.toLowerCase();
        resetQtdComparacoes();
        int n = texto.length();
        int m = padrao.length();
        int[] fail = preProcessamento(padrao);
        int i = 0;
        int j = 0;
        List<Integer> listaPosicoes = new ArrayList<>();
        while (i < n) {
            incQtdComparacoes();
            if (padrao.charAt(j) == texto.charAt(i)) {
                if (j == m - 1) {
                    listaPosicoes.add(i - m + 1);
                }
                i++;
                j = ++j % m;
            } else if (j > 0) {
                j = fail[j - 1];
            } else {
                i++;
            }
        }
        return listaPosicoes;
    }
}

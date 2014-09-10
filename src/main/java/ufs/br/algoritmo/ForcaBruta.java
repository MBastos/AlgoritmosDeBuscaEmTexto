/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ufs.br.algoritmo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForcaBruta extends AlgoritmoDeBusca{

    @Override
    public List<Integer> buscar(String padrao, String texto) {
        resetQtdComparacoes();
        if (texto.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        int n = texto.length();
        int m = padrao.length();
        List<Integer> posicoes = new ArrayList<>();
        for (int i = 0; i <= n-m; i++){
            int j = 0;
            while (j < m){
                incQtdComparacoes();
                if (texto.charAt(i + j) != padrao.charAt(j)){
                    break;
                }
                j++;
            }
            if (j == m){
                posicoes.add(i);
            }
        }
        return posicoes;
    }
    
}

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
     public int[] preProcessamentoLeila(String padrao) {
        int[] next = new int[padrao.length()];        
        int m = padrao.length();
        int j = 0;                
        next[0] = 0;                                            // Primeira letra não possui prefixo nem sufixo                         
        for(int i = 1; i < m; i++){                             // O Algoritmo começa o pre-processamento a partir da segunda letra          
            
            if( padrao.charAt(j) == padrao.charAt(i)){          
                next[i] = j+1;
                j++;
            }else{
                while(padrao.charAt(j) != padrao.charAt(i) && j > 0){
                    j = next[j-1];
                } 
            }
        }             
        return next;
    }

    public int KMPmatch(String texto, String padrao) {
        int n = texto.length();
        int m = padrao.length();
        int[] fail = preProcessamento(padrao);
        int i = 0;
        int j = 0;
        while (i < n) {
            if (padrao.charAt(j) == texto.charAt(i)) {
                if (j == m - 1) {                    
                    return i - m + 1; 
                }
                i++;
                j++;
            } else if (j > 0) {
                j = fail[j - 1];
            } else {
                i++;
            }
        }
        return -1;
    }
    
   
    
//    Algoritmo ComputaNext(P,m, next);
//    {entrada: um padrão P de tamanho m
//    saída: vetor next}
//        inicio 
//        next[1] := -1; next[2]:=0;
//        para i:= 3 até m faça
//        inicio
//        j := next[i-1]+1;
//        enquanto p[i-1] <> p[j] e j>0 faça 
//        j = next[j]+1;;
//        next[i] := j; 
//        fim
//        fim
    
    
    
}

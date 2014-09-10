/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufs.br.algoritmo;

import java.util.ArrayList;
import java.util.List;

public class BoyerMooreCopia extends AlgoritmoDeBusca {

    @Override
    public List<Integer> buscar(String padrao, String texto) {
        resetQtdComparacoes();
        return new ArrayList<>();
    }

    /**
     * Funcao buscaPadrao
     *
     * @param t
     * @param p *
     */
    public int buscaPadrao(String t, String p) {
        char[] texto = t.toCharArray();
        char[] padrao = p.toCharArray();
        return indexador(texto, padrao);
    }

    /**
     * Funcao para calcular o indice do padrao do sufixo *
     */
    public int indexador(char[] texto, char[] padrao) {
        if (padrao.length == 0) {
            return 0;
        }
        int tabelaDeCaracteres[] = fazTabelaDeCaracteres(padrao);
        int tabelaDeDeslocamento[] = fazTabelaDeDeslocamento(padrao);
        for (int i = padrao.length - 1, j; i < texto.length;) {
            for (j = padrao.length - 1; padrao[j] == texto[i]; --i, --j) {
                if (j == 0) {
                    return i;
                }
            }

            /**
             * i += padrao.length - j; // For naive method *
             */
            i += Math.max(tabelaDeDeslocamento[padrao.length - 1 - j], tabelaDeCaracteres[texto[i]]);
        }
        return -1;
    }

    /**
     * Faz a tabela de deslocamento com base nos caracteres incompativeis *
     */
    private int[] fazTabelaDeCaracteres(char[] padrao) {
        final int TAM_ALFABETO = 256;
        int[] tabela = new int[TAM_ALFABETO];
        for (int i = 0; i < tabela.length; ++i) {
            tabela[i] = padrao.length;
        }
        for (int i = 0; i < padrao.length - 1; ++i) {
            tabela[padrao[i]] = padrao.length - 1 - i;
        }
        return tabela;
    }

    /**
     * Faz a tabela do deslocamento com base no deslocamento em que ocorre
     * incompatibilidade. *
     */
    private static int[] fazTabelaDeDeslocamento(char[] padrao) {
        int[] tabela = new int[padrao.length];
        int ultimaPosPrefixo = padrao.length;
        for (int i = padrao.length - 1; i >= 0; --i) {
            if (ehPrefixo(padrao, i + 1)) {
                ultimaPosPrefixo = i + 1;
            }
            tabela[padrao.length - 1 - i] = ultimaPosPrefixo - i + padrao.length - 1;
        }
        for (int i = 0; i < padrao.length - 1; ++i) {
            int stam = tamanhoSufixo(padrao, i);
            tabela[stam] = padrao.length - 1 - i + stam;
        }
        return tabela;
    }

    /**
     * Funcao para checar se eh um prefixo do padrao *
     */
    private static boolean ehPrefixo(char[] padrao, int p) {
        for (int i = p, j = 0; i < padrao.length; ++i, ++j) {
            if (padrao[i] != padrao[j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Funcao que retorna o tamanho maximo do sufixo em p que tambem eh prefixo *
     */
    private static int tamanhoSufixo(char[] padrao, int p) {
        int tam = 0;
        for (int i = p, j = padrao.length - 1; i >= 0 && padrao[i] == padrao[j]; --i, --j) {
            tam += 1;
        }
        return tam;
    }

}
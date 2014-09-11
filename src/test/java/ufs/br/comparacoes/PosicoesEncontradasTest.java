/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufs.br.comparacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Test;
import ufs.br.algoritmo.AlgoritmoDeBusca;
import ufs.br.algoritmo.BoyerMoore;
import ufs.br.algoritmo.ForcaBruta;
import ufs.br.algoritmo.Kmp;
import ufs.br.util.EscolhedorDePadroes;
import ufs.br.util.FileIterator;

/**
 *
 * @author thiago
 */
public class PosicoesEncontradasTest {

    private final AlgoritmoDeBusca forcaBruta = new ForcaBruta();
    private final AlgoritmoDeBusca kmp = new Kmp();
    private final AlgoritmoDeBusca boyerMoore = new BoyerMoore();

    public PosicoesEncontradasTest() {
    }

    private void compareResultados(List<Integer> esperado, List<Integer> res1, List<Integer> res2, List<Integer> res3) {
        Assert.assertArrayEquals(esperado.toArray(), res1.toArray());
        Assert.assertArrayEquals(esperado.toArray(), res2.toArray());
        Assert.assertArrayEquals(esperado.toArray(), res3.toArray());
    }

    private void testarCom(String texto, String padrao, List<Integer> posicoesEsperadas) {
        List<Integer> posicoesForcaBruta = forcaBruta.buscar(padrao, texto);
        List<Integer> posicoesKMP = kmp.buscar(padrao, texto);
        List<Integer> posicoesBoyerMoore = boyerMoore.buscar(padrao, texto);
        compareResultados(posicoesEsperadas, posicoesForcaBruta, posicoesKMP, posicoesBoyerMoore);
    }

    private List<Integer> getPosicoes(String texto, String padrao) {
        Matcher m = Pattern.compile(padrao.toLowerCase(), Pattern.DOTALL).matcher(texto.toLowerCase());
        List<Integer> lista = new ArrayList<>();
        if (padrao.isEmpty()){
            return lista;
        }
        int i = 0;
        while (m.find(i)) {
            lista.add(m.start());
            i = m.start() + padrao.length();
        }
        return lista;
    }

    //@Test
    public void testarMetodoGetPosicoes() {
        System.out.println(getPosicoes("ababaca", "b"));
        System.out.println(getPosicoes("casa", "ca"));
        System.out.println(getPosicoes("", "c"));
        System.out.println(getPosicoes("c", ""));
    }

    @Test
    public void testarBuscasComBaseReal() {
        for (int i = 0; i < 20; i++) {
            FileIterator fi = new FileIterator("entrada.txt");
            List<String> padroes = EscolhedorDePadroes.escolher(fi);
            fi = new FileIterator("entrada.txt");
            String linha;
            while ((linha = fi.next()) != null) {
                for (String padrao : padroes) {
                    System.out.println(linha + "-" + padrao);
                    testarCom(linha, padrao, getPosicoes(linha, padrao));
                }
            }
        }
    }

}

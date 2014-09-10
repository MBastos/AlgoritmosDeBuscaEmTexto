/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufs.br.algoritmo;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author thiago.bispo
 */
public class BoyerMooreTest {

    private BoyerMoore algoritmo = new BoyerMoore();

    public BoyerMooreTest() {
    }

    @Test
    public void testarBuscaComPadraoETextoVazios() {
        System.out.println("BoyerMooreTest.testarBuscaComPadraoETextoVazios");
        String texto = "";
        String padrao = "";
        List<Integer> posicoes = algoritmo.buscar(padrao, texto);
        Assert.assertEquals(0, posicoes.size());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }

    @Test
    public void testarBuscaComPadraoMaiorQueTexto() {
        System.out.println("BoyerMooreTest.testarBuscaComPadraoMaiorQueTexto");
        String texto = "";
        String padrao = "c";
        List<Integer> posicoes = algoritmo.buscar(padrao, texto);
        Assert.assertTrue(posicoes.isEmpty());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }

    @Test
    public void testarBuscaComPadraoInexistenteEmTexto() {
        System.out.println("BoyerMooreTest.testarBuscaComPadraoInexistenteEmTexto");
        String texto = "ababababa";
        String padrao = "c";
        List<Integer> posicoes = algoritmo.buscar(padrao, texto);
        Assert.assertTrue(posicoes.isEmpty());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }

    @Test
    public void testarBuscaComPadraoDeTamanho1ExistenteEmTexto() {
        System.out.println("BoyerMooreTest.testarBuscaComPadraoDeTamanho1ExistenteEmTexto");
        String texto = "ababababa";
        String padrao = "a";
        List<Integer> posicoesEncontradas = algoritmo.buscar(padrao, texto);
        List<Integer> posicoesEsperadas = Arrays.asList(0, 2, 4, 6, 8);
        Assert.assertArrayEquals(posicoesEsperadas.toArray(), posicoesEncontradas.toArray());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }

    @Test
    public void testarBuscaComPadraoDeTamanho2ExistenteEmTexto() {
        System.out.println("BoyerMooreTest.testarBuscaComPadraoDeTamanho2ExistenteEmTexto");
        String texto = "ababababa";
        String padrao = "ab";
        List<Integer> posicoesEncontradas = algoritmo.buscar(padrao, texto);
        List<Integer> posicoesEsperadas = Arrays.asList(0, 2, 4, 6);
        Assert.assertArrayEquals(posicoesEsperadas.toArray(), posicoesEncontradas.toArray());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }
    
    @Test
    public void testarBuscaComPadraoExistenteDeMesmoTamanhoQueTexto(){
        System.out.println("BoyerMooreTest.testarBuscaComPadraoExistenteDeMesmoTamanhoQueTexto");
        String texto  = "ababababa";
        String padrao = "ababababa";
        List<Integer> posicoesEncontradas = algoritmo.buscar(padrao, texto);
        List<Integer> posicoesEsperadas = Arrays.asList(0);
        Assert.assertArrayEquals(posicoesEsperadas.toArray(), posicoesEncontradas.toArray());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }
}

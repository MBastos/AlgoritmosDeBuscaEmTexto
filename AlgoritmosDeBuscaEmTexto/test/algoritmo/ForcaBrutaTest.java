/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmo;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ForcaBrutaTest {
    
    AlgoritmoDeBusca algoritmo = new ForcaBruta();
    
    public ForcaBrutaTest() {
    }
    //Teste unitário com valores de fronteira
    @Test
    public void testarBuscaComPadraoETextoVazios(){
        System.out.println("FocaBrutaTest.testarBuscaComPadraoETextoVazios");
        String texto  = "";
        String padrao = "";
        List<Integer> posicoes = algoritmo.buscar(padrao, texto);
        Assert.assertEquals(1, posicoes.size());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }
    //Teste unitário com valores de fronteira
    @Test
    public void testarBuscaComPadraoMaiorQueTexto(){
        System.out.println("FocaBrutaTest.testarBuscaComPadraoMaiorQueTexto");
        String texto  = "";
        String padrao = "c";
        List<Integer> posicoes = algoritmo.buscar(padrao, texto);
        Assert.assertTrue(posicoes.isEmpty());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }
    
    @Test
    public void testarBuscaComPadraoInexistenteEmTexto(){
        System.out.println("FocaBrutaTest.testarBuscaComPadraoInexistenteEmTexto");
        String texto  = "ababababa";
        String padrao = "c";
        List<Integer> posicoes = algoritmo.buscar(padrao, texto);
        Assert.assertTrue(posicoes.isEmpty());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }
    
    @Test
    public void testarBuscaComPadraoDeTamanho1ExistenteEmTexto(){
        System.out.println("FocaBrutaTest.testarBuscaComPadraoDeTamanho1ExistenteEmTexto");
        String texto  = "ababababa";
        String padrao = "a";
        List<Integer> posicoesEncontradas = algoritmo.buscar(padrao, texto);
        List<Integer> posicoesEsperadas = Arrays.asList(0,2,4,6,8);
        Assert.assertArrayEquals(posicoesEsperadas.toArray(), posicoesEncontradas.toArray());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }
    
    @Test
    public void testarBuscaComPadraoDeTamanho2ExistenteEmTexto(){
        System.out.println("FocaBrutaTest.testarBuscaComPadraoDeTamanho2ExistenteEmTexto");
        String texto  = "ababababa";
        String padrao = "ab";
        List<Integer> posicoesEncontradas = algoritmo.buscar(padrao, texto);
        List<Integer> posicoesEsperadas = Arrays.asList(0,2,4,6);
        Assert.assertArrayEquals(posicoesEsperadas.toArray(), posicoesEncontradas.toArray());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }
    @Test
    public void testarBuscaComPadraoExistenteDeMesmoTamanhoQueTexto(){
        System.out.println("FocaBrutaTest.testarBuscaComPadraoExistenteDeMesmoTamanhoQueTexto");
        String texto  = "ababababa";
        String padrao = "ababababa";
        List<Integer> posicoesEncontradas = algoritmo.buscar(padrao, texto);
        List<Integer> posicoesEsperadas = Arrays.asList(0);
        Assert.assertArrayEquals(posicoesEsperadas.toArray(), posicoesEncontradas.toArray());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }
    
    @Test
    public void testarBuscaComPadraoInexistenteDeMesmoTamanhoQueTexto(){
        System.out.println("FocaBrutaTest.testarBuscaComPadraoInexistenteDeMesmoTamanhoQueTexto");
        String texto  = "ababababa";
        String padrao = "ababababc";
        List<Integer> posicoesEncontradas = algoritmo.buscar(padrao, texto);
        List<Integer> posicoesEsperadas = Arrays.asList();
        Assert.assertArrayEquals(posicoesEsperadas.toArray(), posicoesEncontradas.toArray());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }

}

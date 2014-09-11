package ufs.br.algoritmo;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author thiago.bispo
 */
public class KmpTest {

    AlgoritmoDeBusca algoritmo = new Kmp();

    public KmpTest() {
    }

    @Test
    public void testarBuscaComPadraoETextoVazios() {
        System.out.println("KmpTest.testarBuscaComPadraoETextoVazios");
        String texto = "";
        String padrao = "";
        List<Integer> posicoesEncontradas = algoritmo.buscar(padrao, texto);
        List<Integer> posicoesEsperadas = Arrays.asList();
        Assert.assertArrayEquals(posicoesEsperadas.toArray(), posicoesEncontradas.toArray());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }
    
    @Test
    public void testarBuscaComPadraoMaiorQueTexto() {
        System.out.println("KmpTest.testarBuscaComPadraoMaiorQueTexto");
        String texto = "a";
        String padrao = "aaaaa";
        List<Integer> posicoesEncontradas = algoritmo.buscar(padrao, texto);
        List<Integer> posicoesEsperadas = Arrays.asList();
        Assert.assertArrayEquals(posicoesEsperadas.toArray(), posicoesEncontradas.toArray());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }


    @Test
    public void testarBuscaComPadraoExistenteEmTexto(){
        System.out.println("KmpTest.testarBuscaComPadraoExistenteEmTexto");
        String texto = "abaaba";
        String padrao = "aa";
        List<Integer> posicoesEncontradas = algoritmo.buscar(padrao, texto);
        List<Integer> posicoesEsperadas = Arrays.asList(2);
        Assert.assertArrayEquals(posicoesEsperadas.toArray(), posicoesEncontradas.toArray());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }
    
    @Test
    public void testarBuscaComPadraoExistenteDeMesmoTamanhoQueTexto(){
        System.out.println("KmpTest.testarBuscaComPadraoExistenteDeMesmoTamanhoQueTexto");
        String texto  = "ababababa";
        String padrao = "ababababa";
        List<Integer> posicoesEncontradas = algoritmo.buscar(padrao, texto);
        List<Integer> posicoesEsperadas = Arrays.asList(0);
        Assert.assertArrayEquals(posicoesEsperadas.toArray(), posicoesEncontradas.toArray());
        System.out.println("## Comparações: " + algoritmo.getQtdComparacoes());
    }
}

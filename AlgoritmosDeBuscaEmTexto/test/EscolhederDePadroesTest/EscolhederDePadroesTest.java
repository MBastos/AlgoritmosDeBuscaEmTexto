/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EscolhederDePadroesTest;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import util.EscolhedorDePadroes;
import util.FileIterator;

/**
 *
 * @author thiago.bispo
 */
public class EscolhederDePadroesTest {
    
    public EscolhederDePadroesTest() {
    }
    //Apenas exibe a escolha de padrões pela classe EscolhedorDePadroes sobre o arquivo de exemplo.
    @Test
    public void testarEscolherPadroes(){
        FileIterator fileIterator = new FileIterator("entrada.txt");
        List<String> listaPadroes = EscolhedorDePadroes.escolher(fileIterator);
        System.out.println(listaPadroes);
    }
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

}

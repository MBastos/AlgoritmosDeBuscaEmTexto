package algoritmo;

import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thiago.bispo
 */
public class KmpTest {
    
    Kmp kmp = new Kmp();
    
    public KmpTest() {
    }
    
    @Test
    public void testarPreProcessamento(){
        String padrao = "ababaca";
        int [] resultadoCalculado = kmp.preProcessamento(padrao);
        StringBuilder sb = new StringBuilder();
        for (int i:resultadoCalculado){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
        assertArrayEquals(new int[]{0,0,1,2,3,0,1}, resultadoCalculado);
    }
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

}

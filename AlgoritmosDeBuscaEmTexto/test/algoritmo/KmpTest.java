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
        Integer [] resultadoCalculado = kmp.preProcessamento(padrao);
        System.out.println(Arrays.asList(resultadoCalculado));
        assertArrayEquals(new Integer[]{0,0,1,2,3,0,1}, resultadoCalculado);
    }
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

}

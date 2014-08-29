/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FileIteratorTest;

import util.FileIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FileIteratorTest {
    
    public FileIteratorTest() {
    }
    //Apenas exibe as linhas no arquivo de exemplo
    @Test
    public void testarListarArquivo(){
        FileIterator f1 = new FileIterator("entrada2.txt");
        while(f1.hasNext()){
            System.out.println(f1.next());
        }
    }  
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    Itera sobre as linhas de um arquivo valendo-se do padrão iterator;
*/
public class FileIterator implements Iterator<String> {

    private final String fileName;
    BufferedReader br;
    private String proximaLinha = null;

    public FileIterator(String fileName) {
        this.fileName = fileName;
        init();
    }

    private void init() {
        try {
            br = new BufferedReader(new FileReader(fileName));
            proximaLinha = getProximaLinha();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIterator.class.getName()).log(Level.SEVERE, null, ex);
            proximaLinha = null;
        }
    }

    private String getProximaLinha() {
        try {
            return br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(FileIterator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return proximaLinha != null;
    }

    @Override
    public String next() {
        String aux = proximaLinha;
        proximaLinha = getProximaLinha();
        return aux;
    }

    @Override
    public void remove() {

    }

}

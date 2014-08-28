/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import java.util.ArrayList;
import java.util.List;

public class BoyerMoore extends AlgoritmoDeBusca {

    @Override
    public List<Integer> buscar(String padrao, String texto) {
        resetQtdComparacoes();
        return new ArrayList<>();
    }

}

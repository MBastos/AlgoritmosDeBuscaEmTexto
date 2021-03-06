/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ufs.br.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class EscolhedorDePadroes {
    /*
        Sorteia o valor n de padrões.
        Nas n primeiras linhas, escolhe aleatoreamente 1 padrão dentre a lista de palavras que a linha contém.
    */
    public static List<String> escolher(FileIterator fileIterator){
        List<String> lista = new ArrayList<>();
        Random gerador =  new Random();
        //Acrescenta 1 ao valor somado para evitar o valor 0.
        List<String> linhas = fileIterator.lerTodas();
        int qtdPadroes = gerador.nextInt(19) + 1;
        for (int i = 0; i < qtdPadroes; i++){
            String linha = linhas.get(gerador.nextInt(linhas.size() - 2) + 1); //Escolhe a linha aleatoriamente
            //Pesquisa por outra linha se a escolhida for vazia
            while ((linha.replaceAll(" ", "")).isEmpty()){
                linha = linhas.get(gerador.nextInt(linhas.size() - 2) + 1);
            }
            String[] palavras = linha.split(" ");//Gera a lista de palavras da linha
            //A busca não é case sensitive
                lista.add(palavras[gerador.nextInt(palavras.length - 1)]);
        }
        return lista;
    }
}

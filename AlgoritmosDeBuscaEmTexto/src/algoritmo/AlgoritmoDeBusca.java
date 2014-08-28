package algoritmo;


import java.util.List;

public abstract class AlgoritmoDeBusca {
    //Guarda a quantidade de comparações efetuadas na última busca
    private int qtdComparacoes = 0;

    public AlgoritmoDeBusca() {
    }
    
    //Executa a busca do padrão no texto e retorna a lista de posições onde o padrão foi encontrado
    public abstract List<Integer> buscar(String padrao, String texto);
    
    //Incrementa a quantidade de comparações
    protected void incQtdComparacoes() {
        qtdComparacoes += 1;
    }
    
    //Reinicia a quantidade de comparações
    protected void resetQtdComparacoes() {
        qtdComparacoes = 0;
    }

    public int getQtdComparacoes() {
        return qtdComparacoes;
    }

}

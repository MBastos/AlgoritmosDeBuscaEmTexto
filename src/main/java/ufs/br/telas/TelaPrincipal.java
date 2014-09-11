/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufs.br.telas;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import ufs.br.algoritmo.AlgoritmoDeBusca;
import ufs.br.algoritmo.BoyerMoore;
import ufs.br.algoritmo.ForcaBruta;
import ufs.br.algoritmo.Kmp;
import ufs.br.util.EscolhedorDePadroes;
import ufs.br.util.FileIterator;

/**
 *
 * @author Jomar
 */
public class TelaPrincipal extends JFrame implements ActionListener {

    JButton carregarJButton, executarJButton;
    private String diretorio;
    JPanel graficosPanel;
    JTextField carregarTextField;
    private DefaultCategoryDataset dados;
    private JFreeChart grafico;
    ChartPanel chartPanel = new ChartPanel(grafico, true);
    JTextArea arquivoTextArea = new JTextArea();
    JScrollPane textoScrollPane;

    public TelaPrincipal() {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        FlowLayout layout = new FlowLayout();
        this.setTitle("Algoritmos de busca em texto");
        this.setSize(1024, 780);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        JTabbedPane opcoesTabbebPane = new JTabbedPane();
        JPanel abrirArquivoJPanel = new JPanel();
        JPanel padroesJPanel = new JPanel();
        textoScrollPane = new JScrollPane();
        graficosPanel = new JPanel();
        
        geradorGrafico();
        JLabel carregarJLabel = new JLabel("Selecione o arquivo: ");
        carregarTextField = new JTextField(40);
        carregarTextField.setLocale(new Locale("pt", "BR"));
        carregarJButton = new JButton("...");
        executarJButton = new JButton("Executar");
        carregarJButton.addActionListener(this);
        executarJButton.addActionListener(this);
        abrirArquivoJPanel.setName("Abrir Arquivo");
        padroesJPanel.setName("Padrões");
        textoScrollPane.setName("Texto");
        graficosPanel.setName("Gráficos");
        //Eventos Aba jp1
        abrirArquivoJPanel.add(carregarJLabel);
        abrirArquivoJPanel.add(carregarTextField);
        abrirArquivoJPanel.add(carregarJButton);
        abrirArquivoJPanel.add(executarJButton);
        abrirArquivoJPanel.setLayout(layout);
        abrirArquivoJPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        textoScrollPane.setViewportView(arquivoTextArea);
        arquivoTextArea.setEditable(false);

        opcoesTabbebPane.add(abrirArquivoJPanel);
        opcoesTabbebPane.add(padroesJPanel);
        opcoesTabbebPane.add(textoScrollPane);
        opcoesTabbebPane.add(graficosPanel);
        add(opcoesTabbebPane);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser;
        String nomeArq = null;
        if (e.getSource() == carregarJButton) {
            chooser = new JFileChooser();
            //   chooser.showOpenDialog(this);
            if (chooser.showOpenDialog(this) == chooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                nomeArq = file.toString();
                carregarTextField.setText(nomeArq);
                this.setDiretorio(nomeArq);
            }

        }
        if (e.getSource() == executarJButton) {
            if (carregarTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Diretório Vazio!!!", null, JOptionPane.ERROR_MESSAGE);

            } else {
                setDiretorio(carregarTextField.getText());
                escreverTxt(getDiretorio());
                carregarTextField.setEditable(false);
                this.repaint();
            }

        }

    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;

    }

    public String getDiretorio() {
        return diretorio;

    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        
        //Numero de Comparações, Método usado, Padrão Utilizado
        FileIterator fi = new FileIterator("entrada.txt");
        List<String> padroes = EscolhedorDePadroes.escolher(fi);
        
        AlgoritmoDeBusca[] algoritmos = new AlgoritmoDeBusca[]{new ForcaBruta(), new Kmp(), new BoyerMoore()};
        String[] nomes = new String[]{"Força bruta", "KMP", "Boyer Moore"};
        
        for (int i = 0; i < algoritmos.length; i++) {
            for (String padrao : padroes) {
                int qtd = 0;
                fi = new FileIterator("entrada.txt");
                String linha;
                while ((linha = fi.next()) != null) {
                    algoritmos[i].buscar(padrao, linha);
                    qtd += algoritmos[i].getQtdComparacoes();
                }
                ds.addValue(qtd, nomes[i], padrao);
            }
        }
        return ds;
    }

    public final void geradorGrafico() {
        DefaultCategoryDataset cds = createDataset();
        String titulo = "Gráfico de Tipo";
        String eixoy = "Comparações";
        String txt_legenda = "Padrões Encontrados";
        boolean legenda = true;
        boolean tooltips = true;
        boolean urls = true;
        JFreeChart grafico = ChartFactory.createLineChart(titulo, txt_legenda, eixoy, cds);
        CategoryItemRenderer renderer = grafico.getCategoryPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.YELLOW);
        renderer.setSeriesPaint(2, Color.blue);
        ChartPanel myChartPanel = new ChartPanel(grafico, true);
        myChartPanel.setSize(graficosPanel.getWidth(), graficosPanel.getHeight());
        myChartPanel.setVisible(true);
        graficosPanel.removeAll();
        graficosPanel.add(myChartPanel);
        graficosPanel.revalidate();
        graficosPanel.repaint();
    }

    public void escreverTxt(String f) {
        File file = new File(f);
        try {
            FileReader reader = new FileReader(file);
            BufferedReader input = new BufferedReader(reader);
            String linha;
            while ((linha = input.readLine()) != null) {
                arquivoTextArea.append(linha);
                arquivoTextArea.append("\n");
            }
            input.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static void main(String[] args) {
        TelaPrincipal x = new TelaPrincipal();
        x.setVisible(true);

    }
}

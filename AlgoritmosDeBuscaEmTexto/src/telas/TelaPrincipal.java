/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Jomar
 */
public class TelaPrincipal extends JFrame implements ActionListener {

    JButton jb_carregar, jb_executar;
    private String diretorio;
    JPanel jp4;
    JTextField jt_carregar;
    private DefaultCategoryDataset dados;
    private JFreeChart grafico;
    ChartPanel myChartPanel = new ChartPanel(grafico, true);
    JTextArea ja = new JTextArea();
    JScrollPane jp3;

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
        this.setSize(800, 600);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        JTabbedPane jtp = new JTabbedPane();
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        jp3 = new JScrollPane();
        jp4 = new JPanel();
        geradorGrafico();

        JLabel jl_carregar = new JLabel("Selecione o arquivo: ");
        jt_carregar = new JTextField(40);




        jb_carregar = new JButton("...");
        jb_executar = new JButton("Executar");
        jb_carregar.addActionListener(this);
        jb_executar.addActionListener(this);
        jp1.setName("Abrir Arquivo");
        jp2.setName("Padrões");
        jp3.setName("Texto");
        jp4.setName("Gráficos");
        //Eventos Aba jp1
        jp1.add(jl_carregar);
        jp1.add(jt_carregar);
        jp1.add(jb_carregar);
        jp1.add(jb_executar);
        jp1.setLayout(layout);
        jp1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        jp3.setViewportView(ja);
        ja.setEditable(false);
  
       
        jtp.add(jp1);
        jtp.add(jp2);
        jtp.add(jp3);
        jtp.add(jp4);
        add(jtp);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser;
        String nomeArq = null;
        if (e.getSource() == jb_carregar) {
            chooser = new JFileChooser();

            //   chooser.showOpenDialog(this);
            if (chooser.showOpenDialog(this) == chooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                nomeArq = file.toString();
                jt_carregar.setText(nomeArq);
                 this.setDiretorio(nomeArq);
            }


        }
        if (e.getSource() == jb_executar) {
            if (jt_carregar.getText().trim().isEmpty()) {
                System.out.println("vazio");
                
                

               

            } else {
              setDiretorio(jt_carregar.getText());
                escreverTxt(getDiretorio());
                jt_carregar.setEditable(false);
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

private XYDataset createDataset() {
    //Comparações x Padrões Encontrados
       final XYSeries kmp = new XYSeries("KMP");
      kmp.add(0, 0);
      kmp.add(10, 1);
      kmp.add(30, 2);
      kmp.add(50, 3);     
      kmp.add(100, 4);
     
      final XYSeries fb= new XYSeries("Força Bruta");
      fb.add(0,0);
      fb.add(40, 1);
      fb.add(80, 2);
      fb.add(150, 3);
      fb.add(200, 4);
    
     
      final XYSeries bm = new XYSeries("Boyer Moore");
      bm.add(0, 0);
      bm.add(4, 1);
      bm.add(30, 2);
      bm.add(40, 3);
     bm.add(90, 4);
     
      final XYSeriesCollection dataset = new XYSeriesCollection();
      dataset.addSeries(kmp);
      dataset.addSeries(fb);
      dataset.addSeries(bm);
     
      return dataset;
    }

    public void geradorGrafico() {
        
       XYDataset cds = createDataset(); 
        String titulo = "Gráfico de Tipo";
        String eixoy = "Padrões Encontrados";
        String txt_legenda = "Comparações";
        boolean legenda = true;
        boolean tooltips = true;
        boolean urls = true;
        JFreeChart grafico = ChartFactory.createXYLineChart(titulo, txt_legenda, eixoy, cds);
      
        ChartPanel myChartPanel = new ChartPanel(grafico, true);
        myChartPanel.setSize(jp4.getWidth(), jp4.getHeight());
        myChartPanel.setVisible(true);
        jp4.removeAll();
        jp4.add(myChartPanel);
        jp4.revalidate();
        jp4.repaint();
    }
public void escreverTxt(String f){
   
    File file = new File(f); 
try { 
FileReader reader = new FileReader(file); 
BufferedReader input = new BufferedReader(reader); 
String linha; 
while ((linha = input.readLine()) != null) {     
    ja.append(linha);  
    ja.append("\n");  
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

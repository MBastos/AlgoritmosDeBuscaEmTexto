/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Jomar
 */
public class TelaPrincipal extends JFrame implements ActionListener{
    JButton jb_carregar,jb_executar;
    private String diretorio;
    JPanel jp4;
    JTextField jt_carregar;
  private DefaultCategoryDataset dados;
   private JFreeChart grafico;
   ChartPanel myChartPanel = new ChartPanel(grafico, true);
    public TelaPrincipal(){
        FlowLayout layout = new FlowLayout();
         this.setTitle("Algoritmos de busca em texto");  
         this.setSize(800,600);
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);  
        JTabbedPane jtp = new JTabbedPane();
          JPanel jp1 = new JPanel();
          JPanel jp2 = new JPanel();
          JPanel jp3 = new JPanel();
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
       jp3.setName("OUTROS");
       jp4.setName("Gráficos");
       //Eventos Aba jp1
       jp1.add(jl_carregar);
       jp1.add(jt_carregar);
       jp1.add(jb_carregar);
       jp1.add(jb_executar);
       jp1.setLayout(layout);
       jp1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
       
                
       //
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
        if(e.getSource()== jb_carregar){
                    chooser = new JFileChooser();
                  
           //   chooser.showOpenDialog(this);
              if(chooser.showOpenDialog(this) == chooser.APPROVE_OPTION){
                 File file = chooser.getSelectedFile();  
                 nomeArq = file.toString();
                 jt_carregar.setText(nomeArq);
                  
              }
             
             
        }
       if(e.getSource() == jb_executar){
          if(jt_carregar.getText().trim().isEmpty()){
              System.out.println("vazio");
              
          }else{
              jt_carregar.setEditable(false);
             this.setDiretorio(nomeArq);
          }
           
       }
       
    } 
    
    public void setDiretorio(String diretorio){
        this.diretorio = diretorio;
        
        }
    public String getDiretorio(){
        return diretorio;
        
    }
    private DefaultPieDataset createDataset() { 
DefaultPieDataset dataset = new DefaultPieDataset();

//Adiciona os dados ao dataSet deve somar um total de 100%
dataset.setValue("Algoritmo X: " + "75%", new Integer(75));
dataset.setValue("Algoritmo Y: "+ "10%", new Integer(10));
dataset.setValue("Algoritmo Z: "+ "5%", new Integer(10));
dataset.setValue("Algoritmo W: "+ "5%", new Integer(5));
dataset.setValue("Algoritmo A: "+ "5%", new Integer(5));
return dataset; 
}
    public void geradorGrafico(){
        DefaultPieDataset cds = createDataset();
     String titulo = "Gráfico de Tipo";
String eixoy = "Valores";
String txt_legenda = "Legenda:";
boolean legenda = true;
boolean tooltips = true;
boolean urls = true;
JFreeChart grafico =ChartFactory.createPieChart(titulo, cds, legenda, tooltips, urls);
ChartPanel myChartPanel = new ChartPanel(grafico, true);
myChartPanel.setSize(jp4.getWidth(),jp4.getHeight());
myChartPanel.setVisible(true); 
jp4.removeAll();
jp4.add(myChartPanel); 
jp4.revalidate();
jp4.repaint(); 
    }
            
    public static void main (String[] args){
         TelaPrincipal x = new TelaPrincipal();  
       x.setVisible(true);  
      
       
    }  

   
    }
    



package batalhanaval12;

import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author José Santos
 */
public abstract class Jogador {
    
    
    File atem = new File("C:\\Users\\tamar\\Desktop\\Programação\\batalhanaval12\\src\\batalhanaval12\\tem.txt");
    File item = new File("C:\\Users\\tamar\\Desktop\\Programação\\batalhanaval12\\src\\batalhanaval12\\item.txt");
    
    
    ImageIcon ag = new ImageIcon(getClass().getResource("img/agua.png"));
    ImageIcon b1 = new ImageIcon(getClass().getResource("img/barco1.png"));
    ImageIcon b2 = new ImageIcon(getClass().getResource("img/barco2.png"));
    ImageIcon b3 = new ImageIcon(getClass().getResource("img/barco3.png"));
    ImageIcon bb = new ImageIcon(getClass().getResource("img/bomba.png"));
    
    
    
    JFrame tela = new JFrame("Batalha naval");
    
    JButton start = new JButton("S T A R T");
    JButton[] agua = new JButton[100];
    JButton[] iagua = new JButton[100];
    JPanel Mvitoria = new JPanel();
    JLabel bn = new JLabel();
    JLabel nomejogador = new JLabel();
    JLabel db = new JLabel("Defina sua Ordem de Batalha");
    JLabel db1= new JLabel("posicione a sua fragata ");
    JLabel db2= new JLabel("posicione a sua fragata ");
    
    JTextField nomej = new JTextField();
    JTextArea registros = new JTextArea();
    JScrollPane pregistro = new JScrollPane(registros);
     
    
    
    boolean suavez = true;
    boolean fimdejogo = false;
    boolean game = false;
    boolean novoregistro = false;
    boolean alteração = true;
    boolean save =true;
    
    int ibotao =0;
    int botao = 0;
    int contadorCliques = 0;
    int p =0;
    int acertoufragata = 0;
    int acertoucorveta = 0;
    int acertounavio = 0;
    int acertos = 0;
    int F;//tiro focado
    int FF;//foco na final
    Random r = new Random();
    
    String[] tem = new String[100];
    String nome ;
    String impacto ;
    String[][] campoDeBatalha = new String [10][10];
    
  
    int vidafragata = 3;
    int vidacorveta = 3;
    int vidanavio = 3;       
    
    
    
    
  
    public abstract void setName(String nome);
    
    public abstract String getName();
    
    public abstract void iniciaCampoDeBatalha() throws IOException;        
    
    public abstract void setFragata(JButton cvt,JButton cvt1,JButton cvt2,int t1,int t2,int t3) throws IOException;
        
    public abstract void setCorveta(JButton cvt,JButton cvt1,JButton cvt2,int t1,int t2,int t3) throws IOException;;
   
    public abstract void setNavioDesembarque(JButton cvt,JButton cvt1,JButton cvt2,int t1,int t2,int t3) throws IOException;
    
    public abstract void tiro(JButton p,int tiro) throws IOException;  
        
    public abstract void getCampoDeBatalha();
    
    public String getImpacto(int a, int b){
      impacto = campoDeBatalha[a][b];
      return impacto;
    } 
    /*public void saveamigo(JButton p,int i){
            if(this.tem[i].equalsIgnoreCase("agua")){
            p.setIcon(ag);
        }
        else if(this.tem[this.botao].equalsIgnoreCase("tagua")){
            p.setIcon(ag);
            p.setEnabled(false);
        }
        else if(this.tem[i].equalsIgnoreCase("b1")){
            p.setIcon(b1);
        }
        else if(this.tem[i].equalsIgnoreCase("b2")){
            p.setIcon(b2);
        }
        else if(this.tem[i].equalsIgnoreCase("b3")){
            p.setIcon(b3);
        }
        else if(this.tem[i].equalsIgnoreCase("tb1")){
            p.setIcon(b1);
            p.setEnabled(false);
        }
        else if(this.tem[this.botao].equalsIgnoreCase("tb2")){
            p.setIcon(b2);
            p.setEnabled(false);
        }
        else if(this.tem[i].equalsIgnoreCase("tb3")){
            p.setIcon(b3);
            p.setEnabled(false);
        }
        
    }*/
    
}//fim da classe


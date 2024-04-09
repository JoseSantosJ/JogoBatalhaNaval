
package batalhanaval12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JButton;


public class Inimigo extends Jogador {
    
    Random r = new Random();
    boolean statufragata = false;
    boolean statucorveta = false;
    boolean statuNavioDesembarque = false;
    
      
    @Override
    public void setName (String nome){
        this.nome = nome;
    }
    
    @Override
    public String getName(){
        return nome;
    }
    
    @Override
    public void iniciaCampoDeBatalha() throws IOException
    {
        for (int i = 0; i < 100; i++) {  
                this.tem[i] = ("agua");
            }   System.out.println("campo de batalha "+ getName() +" iniciado");  
          
      
    }     
    
    
    @Override
     public void setFragata(JButton cvt,JButton cvt1,JButton cvt2,int t1,int t2,int t3) throws IOException
    {       
        
        this.tem[t1] = ("b1");
        
        this.tem[t2] = ("b1");
        
        this.tem[t3] = ("b1"); ;
       System.out.println(getName()+" posicionou a Fragata");   
    }// fim do metodo setFragata
       
        
    @Override
    public void setCorveta(JButton cvt,JButton cvt1,JButton cvt2,int t1,int t2,int t3) throws IOException
    {         
        this.tem[t1] = ("b2");
         
        this.tem[t2] = ("b2");
         
        this.tem[t3] = ("b2");
        System.out.println(getName()+" posicionou a Corveta");          
    }
     
    @Override
    public void setNavioDesembarque(JButton cvt,JButton cvt1,JButton cvt2,int t1,int t2,int t3) throws IOException
    {
       {
        this.tem[t1] = ("b3");
        
        this.tem[t2] = ("b3");
        
        this.tem[t3] = ("b3"); 
        System.out.println(getName()+" posicionou o Navio Desembarque posicionado");
        registros.append(getName()+" posicionou o Navio De Desembarque posicionado");
        }
    }// fim do metodo setNavioDesembarque    
  
    @Override
    public void tiro(JButton p,int tiro) throws IOException
    {
        if(this.acertos < 8){
            if(this.tem[tiro] == ("agua")){
                p.setIcon(bb);
                this.tem[tiro] = ("tagua");
                System.out.println("você acertou a agua ");
                this.impacto =("acertou a agua \n");
            }
            if(this.tem[tiro] == ("b1")){
                p.setIcon(b1);
                this.tem[tiro] = ("tb1");
                this.impacto =("acertou a fragata \n");
                System.out.println("você acertou a fragata ");
                this.vidafragata--;
                this.acertos++;
            }
            if(this.tem[tiro] == ("b2")){
                p.setIcon(b2);
                this.tem[tiro] = ("tb2");
                this.impacto =("acertou a corveta \n");
                System.out.println("você acertou a corveta ");
                this.acertos++;
                this.vidacorveta --;    
            }
            if(this.tem[tiro] == ("b3")){
                p.setIcon(b3);
                this.tem[tiro] = ("tb3");
                this.impacto =("acertou a navioNavio De sembarque \n");
                System.out.println("você acertou a navioNavio De sembarque ");
                this.acertos++;
                this.vidanavio--; 
            }
            
        }
        else if (this.acertos == 8 && this.tem[tiro] == ("agua")){
            p.setIcon(bb);
        }
        else if(this.acertos == 8 && this.tem[tiro] != ("agua") && this.tem[tiro] != ("tb1") && this.tem[tiro] != ("tb2") && this.tem[tiro] != ("tb3") ){
            
            
            if(this.tem[tiro] == ("b1")){
                p.setIcon(b1);
                this.tem[tiro] = ("tb1");
                this.impacto =("acertou a fragata \n");
                System.out.println("você acertou a fragata ");
                this.vidafragata--; 
                this.acertos++;
            }
            if(this.tem[tiro] == ("b2")){
                p.setIcon(b2);
                this.tem[tiro] = ("tb2");
                this.impacto =("acertou a corveta \n");
                System.out.println("você acertou a corveta ");
                this.vidacorveta --;
                this.acertos++;
            }
            if(this.tem[tiro] == ("b3")){
                p.setIcon(b3);
                this.tem[tiro] = ("tb3");
                this.impacto =("acertou a navioNavio De sembarque \n");
                System.out.println("você acertou a navioNavio De sembarque ");
                this.vidanavio--;
                this.acertos++;
            }
            this.fimdejogo = true;
        }
    }//fim do metodo tiro Inimigo
   
    @Override    
    public void getCampoDeBatalha(){
        System.out.println("Campo de Batalha Inimigo");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {            
            System.out.print(campoDeBatalha[i][j]);
            } System.out.println("");                
        }
    }
       
    public String getImpacto(){
      return impacto;
    } 
    
    
    //fim do metodo imprimeCampoInimigo

   
}// fim da classe

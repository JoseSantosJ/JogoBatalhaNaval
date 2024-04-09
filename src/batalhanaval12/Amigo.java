
package batalhanaval12;

import java.io.IOException;
import javax.swing.*;


public class Amigo extends Jogador {
    
    int fragata = 0;
    int corveta = 0;
    int NavioDesembarque = 0;
    
    boolean statufragata = false;
    boolean statucorveta = false;
    boolean statuNavioDesembarque = false;
    

    
    
    
    public Amigo(){        
    }
    
    public Amigo (String nome){
        this.nome = nome;
    }   
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
        cvt.setIcon(b1);
        this.tem[t1] = ("b1");
        cvt1.setIcon(b1  );
        this.tem[t2] = ("b1");
        cvt2.setIcon(b1);
        this.tem[t3] = ("b1"); 
        
        System.out.println(getName()+" "+getName()+"posicionou a fragata");
        
    }    
        
    @Override
    public void setCorveta(JButton cvt,JButton cvt1,JButton cvt2,int t1,int t2,int t3)throws IOException
    {
        cvt.setIcon(b2);
        this.tem[t1] = ("b2");
        cvt1.setIcon(b2);
        this.tem[t2] = ("b2");
        cvt2.setIcon(b2);
        this.tem[t3] = ("b2");
        System.out.println(getName()+"posicionou a Corveta");
        
    }
     
    @Override
    public void setNavioDesembarque(JButton cvt,JButton cvt1,JButton cvt2,int t1,int t2,int t3)throws IOException
    {
       
       cvt.setIcon(b3);
        this.tem[t1] = ("b3");
        cvt1.setIcon(b3);
        this.tem[t2] = ("b3");
        cvt2.setIcon(b3);
        this.tem[t3] = ("b3");
        System.out.println(getName()+"posicionou o Navio Desembarque posicionado");
    } 

    
    public void tiro(JButton p,int tiro) throws IOException
    {
        if(this.acertos < 8){
            if(this.tem[tiro] == ("agua")){
                p.setIcon(bb);
                this.tem[tiro] = ("tagua");
                System.out.println("inimigo acertou a agua ");
                this.impacto =("acertou a agua \n");
            }
            if(this.tem[tiro] == ("b1")){
                p.setIcon(b1);
                this.tem[tiro] = ("tb1");
                this.impacto =("acertou a fragata \n");
                System.out.println("inimigo acertou a fragata ");
                this.acertos++;
                this.acertoufragata++;      
                F = tiro;
                if(this.acertoufragata == 1){
                    FF = F;
                }
            }
            if(this.tem[tiro] == ("b2")){
                p.setIcon(b2);
                this.tem[tiro] = ("tb2");
                this.impacto =("acertou a corveta \n");
                System.out.println("inimigo acertou a corveta ");
                this.acertos++;
                this.acertoucorveta++;      
                F = tiro;
                if(this.acertoucorveta == 1){
                    FF = F;
                }
            }
            if(this.tem[tiro] == ("b3")){
                p.setIcon(b3);
                this.tem[tiro] = ("tb3");
                this.impacto =("acertou a navioNavio De sembarque \n");
                System.out.println("inimigo acertou a navioNavio De sembarque ");
                this.acertos++;
                this.acertounavio++;      
                F = tiro;
                if(this.acertounavio == 1){
                    FF = F;
                }
            }
            
        }
        else if (this.acertos == 8 && this.tem[tiro] == ("agua")){
            p.setIcon(bb);
            this.tem[tiro] = ("tagua");
                System.out.println("inimigo acertou a agua ");
                this.impacto =("acertou a agua \n");
        }
        else if(this.acertos == 8 && this.tem[tiro] != ("agua") && this.tem[tiro] != ("tb1") && this.tem[tiro] != ("tb2") && this.tem[tiro] != ("tb3") ){
            
            
            if(this.tem[tiro] == ("b1")){
                p.setIcon(b1);
                this.tem[tiro] = ("tb1");
                this.impacto =("acertou a fragata \n");
                System.out.println("inimigo acertou a fragata ");
                this.vidafragata--;
                this.acertos++;
            }
            if(this.tem[tiro] == ("b2")){
                p.setIcon(b2);
                this.tem[tiro] = ("tb2");
                this.impacto =("acertou a corveta \n");
                System.out.println("inimigo acertou a corveta ");
                this.vidacorveta --; 
                this.acertos++;
            }
            if(this.tem[tiro] == ("b3")){
                p.setIcon(b3);
                this.tem[tiro] = ("tb3");
                this.impacto =("acertou a navioNavio De sembarque \n");
                System.out.println("inimigo acertou a navioNavio De sembarque ");
                this.vidanavio--; 
                
                this.acertos++;
            }
            this.fimdejogo = true;
        }
    }//fim do metodo tiro amigo 
     
    
    @Override
    public void getCampoDeBatalha(){
        System.out.print("Campo de Batalha Amigo");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {            
            System.out.print(campoDeBatalha[i][j]);
                } System.out.println("");                   
        }
    }//fim do metodo imprimeCampoAmigo 
    
    
    
    public String getImpacto(){
      return impacto;
        
    }
    

   
    
    
}// fim da classe

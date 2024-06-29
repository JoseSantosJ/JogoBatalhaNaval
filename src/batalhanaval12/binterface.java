
package batalhanaval12;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class binterface  extends Main {
    

    
  
    
    
    public binterface() {
        
        tela.setVisible(true);
        tela.setSize(1370,720);
        tela.setDefaultCloseOperation(3);
        tela.setLayout(null);
        
        
    }
    
    
    public void setNomeJogador() throws IOException{
        int click = 0;
        if(click == 0){
            
        nomejogador.setText("Entre com o nome do jogador: ");
        
        bn.setBounds(250,0,1000,110);
        bn.setFont(new Font("arial", Font.BOLD, 60));
        bn.setText("*****BATALHA NAVAL*****");
        
        JButton ok = new JButton("ok");
        
        nomej.setBounds(0+ 400,320,250,40);
        nomejogador.setBounds(0+ 450,280,250,54);
        ok.setBounds(240+ 400,320,60,40);
        
        tela.add(bn);
        tela.add(ok);
        tela.add(nomej);
        tela.add(nomejogador);
        ok.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                amigo.setName(nomej.getText());
                inimigo.setName("inimigo");
                tela.add(start);
                 tela.remove(bn);
                tela.remove(ok);
                tela.remove(nomej);
                tela.remove(nomejogador);
                tela.revalidate();
                tela.repaint();
                startregistro();
                
                
            }
        });
        click++;
        }
    }
    
    
    public void startregistro(){
         
        
        pregistro.setBounds(0,70*10, 700, 80);
        registros .setBackground(Color.gray);
        tela.add(pregistro);
        
        registros.append(amigo.getName()+" entrou na Batalha Naval\n");
        registros.append(inimigo.getName()+" entrou na Batalha Naval\n");
        if(save == true){
            
        }
        
        
    }
    
    public void inicioCampoDeBatalha(){
        
        
        start.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    amigo.iniciaCampoDeBatalha();
                } catch (IOException ex) {
                    Logger.getLogger(binterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    inimigo.iniciaCampoDeBatalha();
                } catch (IOException ex) {
                    Logger.getLogger(binterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                db.setBounds(70*11,0 ,960 , 30);
                db.setFont(new Font("arial",Font.BOLD,30));
                db1.setBounds(70*11,30 ,960 , 30);
                db1.setFont(new Font("arial",Font.BOLD,20));
                db2.setBounds(70*11,30 ,960 , 30);
                db2.setFont(new Font("arial",Font.BOLD,20));
                
                
                
                tela.remove(start);
                
                tela.add(db);
                tela.add(db1);
                for (int i = 0; i < amigo.tem.length; i++) {
                    
                      tela.add(agua[i]);
                      
                      
                }
                tela.revalidate();
                tela.repaint();
          
        
            }
        });
        start.setBounds(70 * 12, 70, 280, 140);
        
        
    }

    
    public void setCampoAmigo() throws IOException{
        
        
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                campo(i,j,this.botao);
                this.botao++;
                
            }
        }
        
    }
        
     
    public void  campo(int X,int Y,int botao){

        agua[this.botao] = new JButton("agua",ag);
        agua[this.botao].setBounds(64*X,64*Y,64,64);
        agua[this.botao].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                

           
                if (amigo.tem[botao] == ("agua") && contadorCliques == 0  && game == false && fimdejogo == false && amigo.fragata == 0) {
                    amigo.fragata = 1;
                    JButton vertical = new JButton("vertical");
                    JButton horizontal = new JButton("horizontal ");
                    vertical.addActionListener(new java.awt.event.ActionListener() {
                        
                        
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                amigo.setFragata(agua[botao],agua[(botao - 1)],agua[(botao + 1)],botao,botao - 1,botao + 1);
                            } catch (IOException ex) {
                                Logger.getLogger(binterface.class.getName()).log(Level.SEVERE, null, ex);
                            }
                               tela.remove(horizontal);
                               tela.remove(vertical);
                               tela.revalidate();
                               tela.repaint();
                               contadorCliques++;
                               registros.append(amigo.getName()+"posicionou o Fragata\n");
                               db1.setText("posicione a sua corveta");
                               amigo.statufragata = true;
                        }

                        });
                    
                    horizontal.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                amigo.setFragata(agua[botao],agua[(botao - 10)],agua[(botao + 10)],botao,botao - 10,botao + 10);
                            } catch (IOException ex) {
                                Logger.getLogger(binterface.class.getName()).log(Level.SEVERE, null, ex);
                            }
                               tela.remove(horizontal);
                               tela.remove(vertical);
                               tela.revalidate();
                               tela.repaint();
                               contadorCliques++;
                               registros.append(amigo.getName()+"posicionou o Fragata\n");
                               db1.setText("posicione a sua corveta");
                               amigo.statufragata = true;
                        }

                        });
                    
                    
                    
                    if (botao > 9 && botao < 90 && amigo.tem[botao].equalsIgnoreCase("agua") && amigo.tem[botao - 10].equalsIgnoreCase("agua") && amigo.tem[botao + 10].equalsIgnoreCase("agua")){
                        horizontal.setBounds(70 * 12,70,70,70);
                        tela.add(horizontal);
                    }
                    
                    
                    if(amigo.tem[botao].equalsIgnoreCase("agua") && amigo.tem[botao - 1].equalsIgnoreCase("agua") && amigo.tem[botao + 1].equalsIgnoreCase("agua") && botao % 10 != 0 && (botao + 1)% 10 != 0){
                    tela.add(vertical);
                    vertical.setBounds(70 * 11,70,70,70);
                    }
                    tela.revalidate();
                    tela.repaint();
                }
            }
        });
        agua[this.botao].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                

           
                if (amigo.tem[botao] == ("agua") && contadorCliques == 1 && game == false && fimdejogo == false && amigo.corveta == 0 && amigo.statufragata == true) {
                    
                    amigo.corveta = 1;
                    JButton vertical = new JButton("vertical");
                    JButton horizontal = new JButton("horizontal ");
                    vertical.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                               db1.setText("posicione o seu Navio de desembarque");
                            try {
                                amigo.setCorveta(agua[botao],agua[(botao - 1)],agua[(botao + 1)],botao,botao - 1,botao + 1);
                            } catch (IOException ex) {
                                Logger.getLogger(binterface.class.getName()).log(Level.SEVERE, null, ex);
                            }
                               tela.remove(horizontal);
                               tela.remove(vertical);
                               tela.revalidate();
                               tela.repaint();
                               contadorCliques++;
                               registros.append(amigo.getName()+"posicionou o Corveta\n");
                               amigo.statucorveta = true;
                        }

                        });
                    
                    horizontal.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                               db1.setText("posicione o seu Navio de desembarque");   
                            try {
                                amigo.setCorveta(agua[botao],agua[(botao - 10)],agua[(botao + 10)],botao,botao - 10,botao + 10);
                            } catch (IOException ex) {
                                Logger.getLogger(binterface.class.getName()).log(Level.SEVERE, null, ex);
                            }
                               tela.remove(horizontal);
                               tela.remove(vertical);
                               contadorCliques++;
                               tela.revalidate();
                               tela.repaint();
                               registros.append(amigo.getName()+"posicionou o Corveta\n");
                               amigo.statucorveta = true;
                        }

                        });

                    
                    
                if(botao > 9 && botao < 90 && amigo.tem[botao].equalsIgnoreCase("agua") && amigo.tem[botao - 10].equalsIgnoreCase("agua") && amigo.tem[botao + 10].equalsIgnoreCase("agua")){
                        horizontal.setBounds(70 * 12,70,70,70);
                        tela.add(horizontal);
                        
                    }
                    
                    
                    if(amigo.tem[botao].equalsIgnoreCase("agua") && amigo.tem[botao - 1].equalsIgnoreCase("agua") && amigo.tem[botao + 1].equalsIgnoreCase("agua") && botao % 10 != 0 && ((botao + 1) % 10 != 0)){
                    tela.add(vertical);
                    vertical.setBounds(70 * 11,70,70,70);
                    }
                    tela.revalidate();
                    tela.repaint();
                }
            }
        });
        agua[this.botao].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                

           
                if (amigo.tem[botao] == ("agua") && contadorCliques == 2 && game == false && fimdejogo == false && amigo.NavioDesembarque == 0 && amigo.statucorveta == true) {
                    JButton vertical = new JButton("vertical");
                    JButton horizontal = new JButton("horizontal ");
                    vertical.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                               
                               tela.remove(db1);
                            try {
                                amigo.setNavioDesembarque(agua[botao],agua[(botao - 1)],agua[(botao + 1)],botao,botao - 1,botao + 1);
                            } catch (IOException ex) {
                                Logger.getLogger(binterface.class.getName()).log(Level.SEVERE, null, ex);
                            }
                               tela.remove(horizontal);
                               tela.remove(vertical);
                               tela.revalidate();
                               tela.repaint();
                            try {
                                setbarcos();
                            } catch (IOException ex) {
                                Logger.getLogger(binterface.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                setbarcos1();
                            } catch (IOException ex) {
                                Logger.getLogger(binterface.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                setbarcos2();
                            } catch (IOException ex) {
                                Logger.getLogger(binterface.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                
                                amigo.statuNavioDesembarque = true;
                       
                               registros.append(amigo.getName()+"posicionou o Navio De sembarque\n");
                               gameplay();
                               tela.add(db2);
                               contadorCliques++;
                               
                        }

                        });
                    
                    horizontal.addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                tela.remove(db1);
                            try {
                                amigo.setNavioDesembarque(agua[botao],agua[(botao - 10)],agua[(botao + 10)],botao,botao - 10,botao + 10);
                            } catch (IOException ex) {
                                Logger.getLogger(binterface.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                tela.remove(horizontal);
                                tela.remove(vertical);
                                tela.revalidate();
                                tela.repaint();
                                registros.append(amigo.getName()+"posicionou o Navio De sembarque\n");
                            try {
                                setbarcos();
                            } catch (IOException ex) {
                                Logger.getLogger(binterface.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                setbarcos1();
                            } catch (IOException ex) {
                                Logger.getLogger(binterface.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                setbarcos2();
                            } catch (IOException ex) {
                                Logger.getLogger(binterface.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                amigo.statuNavioDesembarque = true;
                                tela.add(db2);
                                gameplay();
                                contadorCliques++;
                               
                        }

                        });
                    tela.remove(horizontal);
                               tela.remove(vertical);
                               tela.revalidate();
                               tela.repaint();
                    
                    
                    if(botao > 9 && botao < 90 && amigo.tem[botao].equalsIgnoreCase("agua") && amigo.tem[botao - 10].equalsIgnoreCase("agua") && amigo.tem[botao + 10].equalsIgnoreCase("agua") ){
                        horizontal.setBounds(70 * 12,70,70,70);
                        tela.add(horizontal);
                    }
                    
                    
                    if(amigo.tem[botao].equalsIgnoreCase("agua") && amigo.tem[botao - 1].equalsIgnoreCase("agua") && amigo.tem[botao + 1].equalsIgnoreCase("agua")&& botao % 10 != 0 && (botao + 1)% 10 != 0){
                    tela.add(vertical);
                    vertical.setBounds(70 * 11,70,70,70);
                    }
                    
                    tela.revalidate();
                    tela.repaint();
                }
                
                    
                
            }
            
            
            
           
        });     
    }
    

       public void gameplay(){
        JButton start = new JButton("S T A R T");
        start.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
              tela.remove(start);
              começa();
                for (int i = 0; i < 100; i++) {
                    tela.add(iagua[i]);
                }

              tela.revalidate();
              tela.repaint();
            


            }
        });
        start.setBounds(70 * 12, 70, 280, 140);
        tela.add(start);
         
        
    } 
    
    public void começa(){
        this.game = true;
        
    }
    
    
    public void setCampoInimigo(){
       
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                campoinimigo(i,j,this.ibotao);
                this.ibotao++;
                
            }
        }
    }
        
    
    public void campoinimigo(int X,int Y,int ibotao){
        iagua[this.ibotao] = new JButton("agua",ag);
        iagua[this.ibotao].setBounds(64*(X+13),25+(64*(Y+2)),64,64);
        
        
        iagua[this.ibotao].addActionListener(new java.awt.event.ActionListener() {
            
            
            @Override
            public void actionPerformed(ActionEvent e)  {
                
                
                if (game == true && acertos < 8) {
                    try {
                        ibomba(iagua[ibotao],ibotao);
                    } catch (IOException ex) {
                        Logger.getLogger(binterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                if(inimigo.novoregistro==true){
                    registros.append(amigo.getName()+" "+inimigo.getImpacto());
                    inimigo.novoregistro = false;
                }
                }
                if(inimigo.fimdejogo == true){
                    fimdejogo();  
                    JLabel vitoria = new JLabel("vitória");
                    vitoria.setFont(new Font("Arial", Font.BOLD, 100));
                    Mvitoria.setSize(420,111);
                    Mvitoria.setLocation(70*4, 70*10);
                    Mvitoria.setBackground(Color.red);
                    tela.remove(pregistro   );
                    tela.add(Mvitoria);
                    Mvitoria.add(vitoria);
                    tela.revalidate();
                    tela.repaint();
                }
                int  A =r.nextInt(agua.length);
                if (amigo.acertoufragata >= 3 ){
                    amigo.acertoufragata = 0;
                }
                if (amigo.acertoucorveta  >= 3 ){
                    amigo.acertoucorveta = 0;
                }
                if (amigo.acertounavio >= 3 ){
                    amigo.acertounavio = 0;
                }
                if((amigo.acertoucorveta >= 1 && amigo.acertounavio >= 1) || (amigo.acertounavio >= 1 && amigo.acertoufragata >= 1)){
                    amigo.acertoufragata = 0; amigo.acertoucorveta = 0; amigo.acertounavio = 0;
                }
                
                if (game == true && acertos < 8) {
                    do{
                        if(amigo.acertoufragata == 0 || amigo.acertoucorveta == 0 || amigo.acertounavio == 0){
                          A=r.nextInt(agua.length);
                        }
                        if(amigo.acertoufragata == 1 || amigo.acertoucorveta == 1 || amigo.acertounavio == 1){
                            int E = r.nextInt(4);
                            if (E == 0 && A < 90){
                                A = amigo.F +10;
                                
                            }
                            else if (E == 1 && A > 10){
                                A = amigo.F - 10;
                            }
                            else if (E == 2 && A < 99){
                                A = amigo.F + 1;
                            }
                            else if(E == 3 && A > 1){
                                A = amigo.F - 1;
                            }
                         }
                        if(amigo.acertoufragata == 2 || amigo.acertoucorveta == 2 || amigo.acertounavio == 2){
                            int sub = amigo.F - amigo.FF;
                            if (sub == 1 ){//50 - 49 = 1
                                    int E = r.nextInt(2);
                                    if(E == 0){
                                        A= amigo.FF - 1;//49 - 1 = 48
                                   }
                                    else if(E == 1){
                                       A = amigo.F + 1;// 50 + 1 = 52
                                   }
                                }
                                if (sub == -1 ){//f 50 ff 51 = -1
                                    int E = r.nextInt(2);
                                    if(E == 0){
                                        A= amigo.FF + 1;// 51 + 1 = 52
                                   }
                                   if(E == 1){
                                       A = amigo.F - 1;//50 - 1 = 50
                                   }
                                }
                                if (sub == 10){//f60 - ff50 = 10
                                    int E = r.nextInt(2);
                                    if(E == 0){
                                        A= amigo.FF - 10;//
                                   }
                                   if(E == 1){
                                       A = amigo.F + 10;
                                   }
                                }
                                if (sub == -10 ){//61 - 71 = -10
                                    int E = r.nextInt(2);
                                    if(E == 0){
                                        A= amigo.FF + 10;
                                   }
                                   if(E == 1){
                                       A = amigo.F - 10;
                                   }
                                }
                                
                            
                        }
                       
                    }while(!amigo.tem[A].equalsIgnoreCase("agua") && !amigo.tem[A].equalsIgnoreCase("b1") && !amigo.tem[A].equalsIgnoreCase("b2") && !amigo.tem[A].equalsIgnoreCase("b3") && A >= 0 && A < 100);
                
                    try {
                        bomba(agua[A],A);
                    } catch (IOException ex) {
                      
                    amigo.acertoufragata = 0;
                    amigo.acertoucorveta = 0;
                    amigo.acertounavio = 0;;
                    }
                 if(amigo.novoregistro==true){
                    registros.append(inimigo.getName()+" "+amigo.getImpacto());
                    amigo.novoregistro = false;
                }
                }
                if(amigo.fimdejogo == true){
                    fimdejogo();
                    JLabel vitoria = new JLabel();
                    if(amigo.fimdejogo == false){
                        vitoria.setText("vitoria");
                    }
                    if(amigo.fimdejogo == true){
                        vitoria.setText("derrota");
                    }
                    
                    vitoria.setFont(new Font("Arial", Font.BOLD, 100));
                    Mvitoria.setSize(420,111);
                    Mvitoria.setLocation(70*4, 70*10);
                    Mvitoria.setBackground(Color.red);
                    tela.remove(pregistro   );
                    tela.add(Mvitoria);
                    Mvitoria.add(vitoria);
                    tela.revalidate();
                    tela.repaint();
                }
                
            }
        });
    }
    
    public void setbarcos() throws IOException{
        
        do{
            int o = r.nextInt(2);
            p = r.nextInt(iagua.length);
            if(o == 0 && inimigo.tem[p].equalsIgnoreCase("agua") && inimigo.tem[p - 1].equalsIgnoreCase("agua") && inimigo.tem[p + 1].equalsIgnoreCase("agua")&& p % 10 != 0 && (p + 1)% 10 != 0 && p > 1 && p < 99){
                
                inimigo.setFragata(iagua[p], iagua[(p-1)], iagua[(p+1)], p, (p-1), (p+1));
                inimigo.statufragata = true;
                registros.append(inimigo.getName()+" posicionou a fragata\n");
            }
            if(o == 1 && p > 9 && p < 90 && inimigo.tem[p].equalsIgnoreCase("agua") && inimigo.tem[p - 10].equalsIgnoreCase("agua") && inimigo.tem[p + 10].equalsIgnoreCase("agua") && p > 10 && p < 90){
                inimigo.setFragata(iagua[p], iagua[(p-10)], iagua[(p+10)], p, (p-10), (p+10));
                inimigo.statufragata = true;
                registros.append(inimigo.getName()+" posicionou a fragata\n");
            }
        }while(inimigo.statufragata == false && p < 100 && p>= 0);

        
                               
    }  
    public void setbarcos1() throws IOException{
        while(inimigo.statucorveta == false){
            int o = r.nextInt(2);
            int p = r.nextInt(iagua.length);
            if(o == 0 && inimigo.tem[p].equalsIgnoreCase("agua") && inimigo.tem[p - 1].equalsIgnoreCase("agua") && inimigo.tem[p + 1].equalsIgnoreCase("agua")&& p % 10 != 0 && (p + 1)% 10 != 0 && p > 1 && p < 99){
                
                inimigo.setCorveta(iagua[p], iagua[(p-1)], iagua[(p+1)], p, (p-1), (p+1));
                inimigo.statucorveta = true;
                registros.append(inimigo.getName()+" posicionou a Corveta\n");
            }
            if(o == 1 && p > 9 && p < 90 && inimigo.tem[p].equalsIgnoreCase("agua") && inimigo.tem[p - 10].equalsIgnoreCase("agua") && inimigo.tem[p + 10].equalsIgnoreCase("agua") && p > 10 && p < 90){
                inimigo.setCorveta(iagua[p], iagua[(p-10)], iagua[(p+10)], p, (p-10), (p+10));
                inimigo.statucorveta = true;
                registros.append(inimigo.getName()+" posicionou a Corveta\n");
            }
        }  
    }
    public void setbarcos2() throws IOException{
        while(inimigo.statuNavioDesembarque == false){
            int o = r.nextInt(2);
            int p = r.nextInt(iagua.length);
            if(o == 0 && inimigo.tem[p].equalsIgnoreCase("agua") && inimigo.tem[p - 1].equalsIgnoreCase("agua") && inimigo.tem[p + 1].equalsIgnoreCase("agua")&& p % 10 != 0 && (p + 1)% 10 != 0 && p > 1 && p < 99){
                
                inimigo.setNavioDesembarque(iagua[p], iagua[(p-1)], iagua[(p+1)], p, (p-1), (p+1));
                inimigo.statuNavioDesembarque = true;
                registros.append(inimigo.getName()+" posicionou a Navio de desembarque\n");
            }
            if(o == 1 && p > 9 && p < 90 && inimigo.tem[p].equalsIgnoreCase("agua") && inimigo.tem[p - 10].equalsIgnoreCase("agua") && inimigo.tem[p + 10].equalsIgnoreCase("agua") && p > 10 && p < 90 ){
                inimigo.setNavioDesembarque(iagua[p], iagua[(p-10)], iagua[(p+10)], p, (p-10), (p+10));
                inimigo.statuNavioDesembarque = true;
                registros.append(inimigo.getName()+" posicionou a Navio de desembarque\n");
            }
        } 
                   
    }
       
    public void ibomba(JButton p,int tiro) throws IOException{
       if(this.suavez==true){ 
           if(inimigo.acertos < 9 ){
                   inimigo.tiro( p,tiro);
                   p.setEnabled(false);
                   inimigo.novoregistro = true;
                   this.suavez=false;
        
        }
       
    }
   }
    public void bomba(JButton p,int tiro) throws IOException{
        if(this.suavez==false ){
            while(this.suavez==false){
                if(amigo.acertos < 9 ){
                    amigo.tiro( p,tiro);
                    p.setEnabled(false);
                    amigo.novoregistro = true;
                    this.suavez=true;
                   
                }
            }
            
        }
    } 
    
    

    public void fimdejogo(){
        for (int i = 0; i < 100; i++) {          
            if(amigo.tem[i] == ("b1")){
                agua[i].setIcon(b1);   
            }
            if(amigo.tem[i] == ("b2")){
                agua[i].setIcon(b2);   
            }
            if(amigo.tem[i] == ("b3")){
                agua[i].setIcon(b3);   
            }
            if(amigo.tem[i] == ("agua")){
                agua[i].setIcon(ag);   
            }
        }
        for (int i = 0; i < 100; i++) {
            if(inimigo.tem[i] == ("b1")){
                iagua[i].setIcon(b1);   
            }
            if(inimigo.tem[i] == ("b2")){
                iagua[i].setIcon(b2);   
            }
            if(inimigo.tem[i] == ("b3")){
                iagua[i].setIcon(b3);   
            }
            if(inimigo.tem[i] == ("agua")){
                iagua[i].setIcon(ag);   
            }
        }
        atem.delete();
        item.delete();
        this.game = false;
        fimdejogo = true;
    }
    public void saveinimigo(){
        
    }
        
  
        


    @Override
    public void setFragata(JButton cvt,JButton cvt1,JButton cvt2,int t1,int t2,int t3) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setCorveta(JButton cvt,JButton cvt1,JButton cvt2,int t1,int t2,int t3) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setNavioDesembarque(JButton cvt,JButton cvt1,JButton cvt2,int t1,int t2,int t3) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void iniciaCampoDeBatalha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public void getCampoDeBatalha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getImpacto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setName(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void tiro(JButton p,int tiro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

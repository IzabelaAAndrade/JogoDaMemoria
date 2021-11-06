/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author bela
 */
public class InterfaceJogo extends JFrame {
    private JTextField campoTexto;
    private Carta[] botoes;
    private String[] nomes ={"imagens/bunn.jpg", "imagens/cat1.jpeg", "imagens/cat2.jpeg","imagens/cat3.jpeg","imagens/dog1.jpg","imagens/elephant.jpeg","imagens/pand.jpeg","imagens/ping.jpeg","imagens/pig.jpeg","imagens/sp.jpeg"};
    private ImageIcon[] icones;
    private String desenho = "cat1.jpg";
    private JPanel painel;
    private int[] sorteio = {0,1,2,3,4,5,6,7,8,9};
    private int[] sorteados = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private int[] marcado = {0,0,0,0,0,0,0,0,0,0};
    private int i, j,k, aux=0;
    private Random numAleatorio = new Random(); 
    private int sorteado;
    private int cont=0;
    private int cont2=0;
    private int[] clicado = {0,0};
    private int[] indices = {0,0};

    public InterfaceJogo(){
        
        super("Jogo da Memoria xD");
        setLayout(new FlowLayout());
        
        campoTexto = new JTextField("Jogo da Memória !");
        campoTexto.setSize(800, 20);
        campoTexto.setMaximumSize(new Dimension(800,20));
        campoTexto.setMinimumSize(new Dimension(800,20));
        campoTexto.setPreferredSize(new Dimension(800,20));
        add(campoTexto);
        campoTexto.setHorizontalAlignment(SwingConstants.CENTER);

        icones = new ImageIcon[10];
        botoes = new Carta[20];
        painel = new JPanel();
        painel.setMinimumSize(new Dimension(800,550));
        painel.setMaximumSize(new Dimension(800,550));
        painel.setPreferredSize(new Dimension(800,550));
        painel.setBounds(0, 20, 800, 500);
        painel.setLayout(new GridLayout(4,5));
        
        for(k=0; k<icones.length; k++){
          icones[k] = new ImageIcon(getClass().getResource(nomes[k])); // instanciar as outras imagens
        }
        for(i=0; i<botoes.length;i++){
            aux = 0;
            while(aux==0){
              sorteado = numAleatorio.nextInt(10);
                for(j=0; j<sorteio.length; j++){
                    if(j==sorteado){
                        if(marcado[j]<2){
                          marcado[j]++;
                          aux=1;
                        }

                    }

                }  
            }
            sorteados[i]=sorteado;
            botoes[i] = new Carta();
            painel.add(botoes[i].getBotao());
            
        }
        
        
        add(painel);
        handlerEvento handler = new handlerEvento();
        for(i=0; i<botoes.length; i++){
          botoes[i].getBotao().addActionListener(handler);
        }
        
        
    }
    public class handlerEvento implements ActionListener{
      public void actionPerformed(ActionEvent evento){
       
        for(i=0; i<botoes.length && cont<2; i++){
          if(botoes[i].getBotao()==evento.getSource()){
            botoes[i].setIcone(icones[sorteados[i]]);
            indices[cont] = i;
            
            cont++;
          }
        }
        if(cont==2){
          if(botoes[indices[0]].getBotao().getIcon().equals( botoes[indices[1]].getBotao().getIcon())){
            cont = 0; 
            cont2++;
          }else{
            JOptionPane.showMessageDialog(null,"Você errou :(", "Figuras Incompatíveis", 1);
            botoes[indices[0]].setIconeInicial();
            botoes[indices[1]].setIconeInicial();
            cont = 0; 
            
          }
        }
        if(cont2>=10){
          JOptionPane.showMessageDialog(null,"Você Ganhou!!", "Fim",1);
          campoTexto.setText("Você Ganhou");

        }
      }
    }
}

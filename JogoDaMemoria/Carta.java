

/**
 *
 * @author bela
 */
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;

/**
 *
 * @author bela
 */
public class Carta {
    private int valor;
    private ImageIcon desenho;
    private JButton botao;
    
    
    
    public Carta(){
        botao = new JButton();
        this.desenho = new ImageIcon(getClass().getResource("/imagens/padrao.jpeg"));
        Image img  = desenho.getImage();
        Image newimg = img.getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH);
        desenho = new ImageIcon(newimg);
        botao.setIcon(desenho);
        
    }
    public Carta(int valor){
        setValor(valor);
        botao = new JButton();
        this.desenho = new ImageIcon(getClass().getResource("/imagens/padrao.jpeg"));
        Image img  = desenho.getImage();
        Image newimg = img.getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH);
        desenho = new ImageIcon(newimg);
        botao.setIcon(desenho);
    }
    public void setValor(int valor){
        this.valor = valor;
    }
    public void setIconeInicial(){
        botao.setIcon(desenho);
    }
    public void setIcone(Icon icone){
        botao.setIcon(icone);
    }
    public int getValor(){
        return valor;
    }
    public void setIcon(Icon icone){
        botao.setIcon(icone);
    }
    public JButton getBotao(){
      return botao;
    }
    
    
    
    
}

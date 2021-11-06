import javax.swing.JFrame;

class Main {
  public static void main(String[] args) {
    // TODO code application logic here
        InterfaceJogo teste = new InterfaceJogo();
        teste.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teste.setBounds(0,0, 800, 650);
        
        teste.setVisible(true);
  }
}
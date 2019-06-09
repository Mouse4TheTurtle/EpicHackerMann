package javatutorial.net;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel{
private int x = 10;
    public void paint(Graphics g){
    //    for(;x <= 138; x =+16) {
            g.drawRect( x, 10, 16, 16);
      //  }
    }

    public static void main(String[] args){
        JFrame frame= new JFrame("Chess Game");
        frame.getContentPane().add(new javatutorial.net.GUI());
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}	
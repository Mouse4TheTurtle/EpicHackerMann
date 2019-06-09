//package javatutorial.net;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel{
private int x = 10;
    public void paint(Graphics g){
        for(;x <= 138; x =+16) {
            g.drawRect( 10, 10, 16, 16);
        }
    }

    public static void main(String[] args){
        JFrame frame= new JFrame("Chess Game");
  //    frame.getContentPane().add(new javatutorial.net.GUI());
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}	
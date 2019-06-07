import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Game
{
    public static void main(String[] args)
    {
        Board gamer = new Board();
        //System.out.println(gamer);
/*
        JFrame frame = new JFrame("Chess Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Panel());
        frame.setBounds(500,100,600,600);
        frame.setResizable(false);
        Path workingDirectory = Paths.get("").toAbsolutePath();
        ImageIcon image = new ImageIcon(workingDirectory + "\\images\\bruh.png");
        JLabel imageLabel = new JLabel(image);
        frame.add(imageLabel);
        frame.setVisible(true);
        */

        //gamer.movePiece(gamer.getBoard()[7][1],new Movement(2,1));
        gamer.movePiece(gamer.getBoard()[6][5],new Movement(-1,0));
        System.out.println(gamer);

    }
}

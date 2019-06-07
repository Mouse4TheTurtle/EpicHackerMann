import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

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
        //gamer.movePiece(gamer.getBoard()[6][5],new Movement(-1,0));
        //System.out.println(gamer);
        String response = "";
        int x;
        int y;
        int w;
        int z;
        while (!response.toLowerCase().equals("exit"))
        {
            Scanner keyboard = new Scanner(System.in);
            System.out.println(gamer);
            System.out.println("\nMove which piece? ");
            System.out.println("Row? ");
            x = keyboard.nextInt();
            System.out.println("Column? ");
            y = keyboard.nextInt();
            System.out.println("Moving " + gamer.getBoard()[x][y].getColor() + gamer.getBoard()[x][y].getPieceName());
            System.out.println("Move on the vertical axis by? ");
            w = keyboard.nextInt();
            System.out.println("Move on the horizontal axis by? ");
            z = keyboard.nextInt();

            gamer.movePiece(gamer.getBoard()[x][y], new Movement(w,z));

            System.out.println(gamer);

            System.out.println("Restart, exit, or continue?");
            response = keyboard.nextLine();
            if(response.toLowerCase().equals("restart"))
            {
                gamer.resetBoard();
            }

        }
    }
}

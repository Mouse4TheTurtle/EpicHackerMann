import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Board gamer = new Board();
        String response = "";
        Scanner keyboard = new Scanner(System.in);

        int x;
        int y;
        int w;
        int z;

        System.out.println("Use manual control? ");
        if (keyboard.nextLine().equals("yes")) {
            while (!response.toLowerCase().equals("exit")) {

                System.out.println(gamer);
                System.out.println("\nMove which piece? ");
                System.out.println("Row: ");

                x = keyboard.nextInt();

                System.out.println("Column? ");

                y = keyboard.nextInt();

                System.out.println("Moving " + gamer.getBoard()[x][y].getColor() + gamer.getBoard()[x][y].getPieceName());
                System.out.println("Move on the vertical axis by? ");

                w = keyboard.nextInt();

                System.out.println("Move on the horizontal axis by? ");

                z = keyboard.nextInt();

                gamer.movePiece(gamer.getBoard()[x][y], new Movement(w, z));

                System.out.println(gamer);

            }
        }
        else
        {

        }
    }
}



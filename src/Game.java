import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Board gamer = new Board();
        String response = "";
        Scanner keyboard = new Scanner(System.in);

        for (Piece[] h : gamer.getBoard()) {
            for (Piece i : h) {

            }
        }
        int x;
        int y;
        int w;
        int z;

        System.out.println("Use manual control? ");
        if (keyboard.nextLine().equals("yes")) {
            while (!response.toLowerCase().equals("exit")) {

                System.out.println(gamer);
                if(gamer.getAdvantage()>0)
                System.out.println("White is up by: " + gamer.getAdvantage());
                if(gamer.getAdvantage()<0)
                    System.out.println("Black is up by: " + gamer.getAdvantage());
                else
                    System.out.println("Game is tied!");


                System.out.println("\nMove which piece? ");

                System.out.println("Column: ");

                y=-1;

                String Column = keyboard.next();

                if(Column.toLowerCase().contains("a"))
                    y=0;
                if(Column.toLowerCase().contains("b"))
                    y=1;
                if(Column.toLowerCase().contains("c"))
                    y=2;
                if(Column.toLowerCase().contains("d"))
                    y=3;
                if(Column.toLowerCase().contains("e"))
                    y=4;
                if(Column.toLowerCase().contains("f"))
                    y=5;
                if(Column.toLowerCase().contains("g"))
                    y=6;
                if(Column.toLowerCase().contains("h"))
                    y=7;

                System.out.println("Row: ");

                x = keyboard.nextInt();

                if(x>3)
                    Math.abs(x-8);
                else if (x==3)
                    x=5;
                else if (x==2)
                    x=6;
                else if (x==1)
                    x=7;

                String color;
                if (gamer.getBoard()[x][y].getColor())
                {
                    color = "White";
                }
                else
                {
                    color = "White";
                }

                System.out.println("Moving " + color + " " + gamer.getBoard()[x][y].getPieceName());
                System.out.println("Move on the vertical axis by? ");

                w = keyboard.nextInt();

                System.out.println("Move on the horizontal axis by? ");

                z = keyboard.nextInt();

                gamer.movePiece(gamer.getBoard()[x][y], new Movement(w, z));
            }
        }
        else
        {
            //for interaction with bot and stuff
        }
    }
}



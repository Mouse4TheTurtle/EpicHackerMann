package oldsrc;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Board gamer = new Board();
        String response = "";
        Scanner keyboard = new Scanner(System.in);
        temprename data = new temprename(null, null);

        int x;
        int y;
        int w;
        int z;
        int boardNum;

        System.out.println("Use manual control? ");
        if (keyboard.nextLine().toLowerCase().equals("yes")) {

            System.out.println("Would you like to load a board? ");

            if (keyboard.nextLine().toLowerCase().equals("yes")) {
                System.out.println("Which board would you like to use? ");

                gamer.setBoard(data.readBoard(keyboard.nextInt()));

                System.out.println("Setting up game...");
            }

                while (!response.toLowerCase().equals("exit")) {

                    System.out.println(gamer);

                    if (gamer.getAdvantage() > 0)
                        System.out.println("White is up by: " + gamer.getAdvantage());

                    if (gamer.getAdvantage() < 0)
                        System.out.println("Black is up by: " + gamer.getAdvantage() * -1);

                    else
                        System.out.println("Game is tied");
                    if (gamer.whoseTurn()) {
                        System.out.println("It is White's Turn");
                    } else {
                        System.out.println("It is Black's Turn");
                        ;
                    }
                    System.out.println("\nMove which piece? ");

                    System.out.println("Column: ");

                    y = -1;

                    String Column = keyboard.next();

                    if (Column.toLowerCase().contains("a"))
                        y = 0;
                    if (Column.toLowerCase().contains("b"))
                        y = 1;
                    if (Column.toLowerCase().contains("c"))
                        y = 2;
                    if (Column.toLowerCase().contains("d"))
                        y = 3;
                    if (Column.toLowerCase().contains("e"))
                        y = 4;
                    if (Column.toLowerCase().contains("f"))
                        y = 5;
                    if (Column.toLowerCase().contains("g"))
                        y = 6;
                    if (Column.toLowerCase().contains("h"))
                        y = 7;

                    System.out.println("Row: ");

                    x = keyboard.nextInt();

                    if (x == 8)
                        x = 0;
                    else if (x == 7)
                        x = 1;
                    else if (x == 6)
                        x = 2;
                    else if (x == 5)
                        x = 3;
                    else if (x == 4)
                        x = 4;
                    else if (x == 3)
                        x = 5;
                    else if (x == 2)
                        x = 6;
                    else if (x == 1)
                        x = 7;

                    String color;
                    if (gamer.getBoard()[x][y].getColor()) {
                        color = "White";
                    } else {
                        color = "Black";
                    }

                    System.out.println("Moving " + color + " " + gamer.getBoard()[x][y].getPieceName());
                    System.out.println("Move on the vertical axis by? ");

                    w = keyboard.nextInt();

                    System.out.println("Move on the horizontal axis by? ");

                    z = keyboard.nextInt();

                    if(gamer.whoseTurn())
                    {
                        w *= -1;
                    }

                    gamer.movePiece(gamer.getBoard()[x][y], new Movement(w, z));

                    System.out.println("Save current board?");

                    if(keyboard.next().toLowerCase().equals("yes"))
                    {
                    data.writeBoard(gamer);
                    }
                }
            } else {
                System.out.println("Setting up game... ");

                for (Piece[] h : gamer.getBoard()) {
                    for (Piece i : h) {
                        if (!i.getPieceName().equals("Empty")) {
                            i.setValuedSituations();
                        }
                    }
                }
                //bot interactions go here
            }
        }
    }



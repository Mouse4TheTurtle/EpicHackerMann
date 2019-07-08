import java.util.Scanner;

public class GameTesting {
    public static void main(String[] args) {

        Board game = new Board();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Begin game? ");
        String input = keyboard.nextLine();
        if(input.toLowerCase().equals("yes")) {
            while(!input.toLowerCase().equals("end")) {
                System.out.println(game);
                System.out.println("Move: ");
                input = keyboard.nextLine();
                game.movePiece(input);
            }
        }
    }
}
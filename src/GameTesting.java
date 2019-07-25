import java.util.Scanner;

public class GameTesting {
    public static void main(String[] args) {

        Board game = new Board();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Begin game? ");
        String input = keyboard.nextLine();
        for (int i = 0; i < game.getGameBoard()[7][1].getPossibleMoves().length; i++) {
            System.out.println(game.getGameBoard()[7][1].getPossibleMoves()[i]);
        }

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
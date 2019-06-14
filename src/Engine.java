public class Engine {
    private static Board game = new Board();
    public static void main(String[] args) {

        double whiteValue = 0;
        double blackValue = 0;

        game.getGameBoard();
        game.movePiece("c3");

    }
}

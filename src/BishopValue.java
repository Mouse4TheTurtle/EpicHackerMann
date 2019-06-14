

public class BishopValue {
    private static Board game = new Board();

    public BishopValue() {
        game.getGameBoard();
        game.movePiece("c3");

//black bish val
        for (int i = 0; game.getGameBoard().length > i; i++) {
            for (int j = 0; j < game.getGameBoard()[i].length; ) {
                if(game.getGameBoard()[i][j].getName().equals("Bishop")) {
                    if()
                }
            }
        }

    }
}

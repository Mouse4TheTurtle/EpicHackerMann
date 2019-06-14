

public class BishopValue {
    private Board game = new Board();
    private double blackBishopPlacementValue1 = 0.0;
    private double blackBishopPlacementValue2 = 0.0;
    private double blackBishopPlacementValueTotal = 0.0;

    private double whiteBishopPlacementValue1 = 0.0;
    private double whiteBishopPlacementValue2 = 0.0;
    private double whiteBishopPlacementValueTotal = 0.0;

    public BishopValue() {
        game.getGameBoard();
        game.movePiece(" c3");

    }

    public void blackBishopPlacementValue() {
        for (int i = 0; game.getGameBoard().length > i; i++) {
            for (int j = 0; j < game.getGameBoard()[i].length; ) {
                if (game.getGameBoard()[i][j].getName().equals("Bishop") ||
                        game.getGameBoard()[i][j].getColor().equals("Black")) {
                    if (i == 1 && j == 1 || i == 1 && j == 6) {
                        blackBishopPlacementValue1 = +0.3;
                    }
                    if (i == 3 && j == 2 || i == 3 && j == 5) {
                        blackBishopPlacementValue2 = +0.1;
                    }
                }
            }
        }
    }

    public double whiteBishopPlacementValue() {
        for (int i = 0; game.getGameBoard().length > i; i++) {
            for (int j = 0; j < game.getGameBoard()[i].length; ) {
                if (game.getGameBoard()[i][j].getName().equals("Bishop") ||
                        game.getGameBoard()[i][j].getColor().equals("White")) {
                    if (i == 6 && j == 1 || i == 6 && j == 6) {
                        whiteBishopPlacementValue1 = +0.3;
                    }
                    if (i == 4 && j == 2 || i == 4 && j == 5) {
                        whiteBishopPlacementValue2 = +0.1;
                    }
                }
            }
        }
        whiteBishopPlacementValueTotal = +whiteBishopPlacementValue1 + whiteBishopPlacementValue2;
        return whiteBishopPlacementValueTotal;
    }

}

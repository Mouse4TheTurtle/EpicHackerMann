public class KnightValue {
    private Board game = new Board();
    private double blackKnightPlacementValue1 = 0.0;
    private double blackKnightPlacementValue2 = 0.0;
    private double blackKnightPlacementValue3 = 0.0;
    private double blackKnightPlacementValueTotal = 0.0;

    private double whiteKnightPlacementValue1 = 0.0;
    private double whiteKnightPlacementValue2 = 0.0;
    private double whiteKnightPlacementValue3 = 0.0;
    private double whiteKnightPlacementValueTotal = 0.0;

    public KnightValue() {
        game.getGameBoard();
        game.movePiece(" c3");
    }

    public double blackKnightPlacementValue() {
        for (int i = 0; game.getGameBoard().length > i; i++) {
            for (int j = 0; j < game.getGameBoard()[i].length;j++ ) {
                if (game.getGameBoard()[i][j].getName().equals("Knight") ||
                        game.getGameBoard()[i][j].getColor().equals("Black")) {
                    if ((i == 0 && j == 0) || (i == 0 && j == 7)) {
                        blackKnightPlacementValue1 =- 0.15;
                    }
                    if ((i == 0 && j == 3) || (i == 0 && j == 4)) {
                        blackKnightPlacementValue2 =+ 0.1;
                    }
                    if (i == 6) {
                        blackKnightPlacementValue3 =+ 0.4;
                    }
                }
            }
        }
        blackKnightPlacementValueTotal =+ blackKnightPlacementValue1 +
                blackKnightPlacementValue2 +blackKnightPlacementValue3;
        return blackKnightPlacementValueTotal;
    }

    public double whiteKnightPlacementValue() {
        for (int i = 0; game.getGameBoard().length > i; i++) {
            for (int j = 0; j < game.getGameBoard()[i].length;j++ ) {
                if (game.getGameBoard()[i][j].getName().equals("Knight") ||
                        game.getGameBoard()[i][j].getColor().equals("White")) {
                    if ((i == 7 && j == 7) || (i == 7 && j == 0)) {
                        whiteKnightPlacementValue1 =- 0.15;
                    }
                    if ((i == 7 && j == 3) || (i == 7 && j == 4)) {
                        whiteKnightPlacementValue2 =+ 0.1;
                    }
                    if (i == 1){
                        whiteKnightPlacementValue3 =+ 0.4;
                    }
                }
            }
        }
        whiteKnightPlacementValueTotal = +whiteKnightPlacementValue1 +
                whiteKnightPlacementValue2+whiteKnightPlacementValue3;
        return whiteKnightPlacementValueTotal;
    }
}
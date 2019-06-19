public class RookValue {
    private Board game = new Board();
    private double blackRookPlacementValue1 = 0.0;
    private double blackRookPlacementValue2 = 0.0;
    private double blackRookPlacementValue3 = 0.0;
    private double blackRookPlacementValueTotal = 0.0;

    private double whiteRookPlacementValue1 = 0.0;
    private double whiteRookPlacementValue2 = 0.0;
    private double whiteRookPlacementValue3 = 0.0;
    private double whiteRookPlacementValueTotal = 0.0;

    public RookValue() {
        game.getGameBoard();
        game.movePiece(" c3");
    }

        public double blackRookPlacementValue() {
            for (int i = 0; game.getGameBoard().length > i; i++) {
                for (int j = 0; j < game.getGameBoard()[i].length;j++ ) {
                    if (game.getGameBoard()[i][j].getName().equals("Rook") ||
                            game.getGameBoard()[i][j].getColor().equals("Black")) {
                        if ((i == 0 && j == 0) || (i == 0 && j == 7)) {
                            blackRookPlacementValue1 =- 0.15;
                        }
                        if ((i == 0 && j == 3) || (i == 0 && j == 4)) {
                            blackRookPlacementValue2 =+ 0.1;
                        }
                        if (i == 6) {
                            blackRookPlacementValue3 =+ 0.4;
                        }
                    }
                }
            }
            blackRookPlacementValueTotal =+ blackRookPlacementValue1 +
                    blackRookPlacementValue2 +blackRookPlacementValue3;
            return blackRookPlacementValueTotal;
        }

        public double whiteRookPlacementValue() {
            for (int i = 0; game.getGameBoard().length > i; i++) {
                for (int j = 0; j < game.getGameBoard()[i].length;j++ ) {
                    if (game.getGameBoard()[i][j].getName().equals("Rook") ||
                            game.getGameBoard()[i][j].getColor().equals("White")) {
                        if ((i == 7 && j == 7) || (i == 7 && j == 0)) {
                            whiteRookPlacementValue1 =- 0.15;
                        }
                        if ((i == 7 && j == 3) || (i == 7 && j == 4)) {
                            whiteRookPlacementValue2 =+ 0.1;
                        }
                        if (i == 1){
                            whiteRookPlacementValue3 =+ 0.4;
                        }
                    }
                }
            }
            whiteRookPlacementValueTotal = +whiteRookPlacementValue1 +
                    whiteRookPlacementValue2+whiteRookPlacementValue3;
            return whiteRookPlacementValueTotal;
        }
    }
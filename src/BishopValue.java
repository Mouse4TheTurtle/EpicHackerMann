

public class BishopValue {
    private static Board game = new Board();

    public BishopValue() {
        game.getGameBoard();
        game.movePiece(" c3");
        double blackBishopPlacmentValue1 = 0.0;
        double blackBishopPlacmentValue2 = 0.0;
        double blackBishopPlacmentValueTotal = 0.0;

        double whiteBishopPlacmentValue1 = 0.0;
        double whiteBishopPlacmentValue2 = 0.0;
        double whiteBishopPlacmentValueTotal = 0.0;

        public static void blackBishopPlacementValue(){
            for(int i = 0; game.getGameBoard().length > i; i++) {
                for(int j = 0; j < game.getGameBoard()[i].length; ) {
                    if(game.getGameBoard()[i][j].getName().equals("Bishop") ||
                            game.getGameBoard()[i][j].getColor().equals("Black")) {
                        if(i == 1 && j == 1|| i== 1 && j == 6) {
                            blackBishopPlacmentValue1 = + 0.3;
                        }
                        if(i == 3 && j == 2|| i == 3 && j == 5) {
                            blackBishopPlacmentValue2 = +0.1;
                        }
                    }
                }
            }

        }

        public static double whiteBishopPlacementValue(){
            for(int i = 0; game.getGameBoard().length > i; i++) {
                for(int j = 0; j < game.getGameBoard()[i].length; ) {
                    if(game.getGameBoard()[i][j].getName().equals("Bishop") ||
                            game.getGameBoard()[i][j].getColor().equals("White")) {
                        if(i == 6 && j == 1|| i== 6 && j == 6) {
                            whiteBishopPlacmentValue1 = + 0.3;
                        }
                        if(i == 4 && j == 2|| i == 4 && j == 5) {
                            whiteBishopPlacmentValue2 = +0.1;
                        }
                    }
                }
            }
            whiteBishopPlacmentValueTotal =+ whiteBishopPlacmentValue1 + whiteBishopPlacmentValue2;
            return whiteBishopPlacmentValueTotal;
        }
    }
}

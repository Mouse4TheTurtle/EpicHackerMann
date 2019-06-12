

public class Board {

    private Piece[][] gameBoard;
    private boolean turn;

    public int translateRow(int row) {

        int y = -1;

        if (row == 8)
            y = 0;
        else if (row == 7)
            y = 1;
        else if (row == 6)
            y = 2;
        else if (row == 5)
            y = 3;
        else if (row == 4)
            y = 4;
        else if (row == 3)
            y = 5;
        else if (row == 2)
            y = 6;
        else if (row == 1)
            y = 7;

        return y;
    }

    public int translateCol(String col) {

        int x = -1;

        if (col.toLowerCase().contains("a"))
            x = 0;
        if (col.toLowerCase().contains("b"))
            x = 1;
        if (col.toLowerCase().contains("c"))
            x = 2;
        if (col.toLowerCase().contains("d"))
            x = 3;
        if (col.toLowerCase().contains("e"))
            x = 4;
        if (col.toLowerCase().contains("f"))
            x = 5;
        if (col.toLowerCase().contains("g"))
            x = 6;
        if (col.toLowerCase().contains("h"))
            x = 7;

        return x;
    }

    public String translateCol(int col) {

        String out = "";

        if (col == 0)
            out = "a";
        if (col == 1)
            out = "b";
        if (col == 2)
            out = "c";
        if (col == 3)
            out = "d";
        if (col == 4)
            out = "e";
        if (col == 5)
            out = "f";
        if (col == 6)
            out = "g";
        if (col == 7)
            out = "h";

        return out;
    }

    public boolean isPromotion(String movement) {
        ///checks if the movement is a promotion
        if (movement.substring(2, 3).equals("R") || movement.substring(2, 3).equals("B") || movement.substring(2, 3).equals("N") || movement.substring(2, 3).equals("Q")) {
            return true;
        }
        return false;
    }

    public boolean isPreciseMove(String movement) {
        //checks if the movement is by one of two possible pieces
        for (int i = 0; i < 9; i++) {
            if (movement.substring(1, 2).contains("" + i) || !movement.substring(1, 3).contains("" + i)) {
                return true;
            }
        }
        return false;
    }

    public String interpretPieceName(String movement) {
        if (movement.length() == 4) {
            if (isPromotion(movement)) {
            } else if (isPreciseMove(movement)) {
                return movement.substring(0, 2);
            }
        }
        return movement.substring(0, 1);
    }

    public String interpretMove(String movement) {
        if (movement.length() == 4) {
            if (isPromotion(movement)) {
                return movement.substring(1,3);
            } else if (isPreciseMove(movement)) {
                return movement.substring(2, 4);
            }
        }
        return movement.substring(1,3);
    }

    public void movePiece(String movement) {

        String piece = interpretPieceName(movement);
        String move = interpretMove(movement);

        if(isPromotion(movement))
        {
            promotion(piece,move);
        }

        if(validMove(turn,piece,move)){
            takePiece(piece,move);
        }
    }

    public boolean validMove(boolean color, String piece, String move) {
        return true;
    }

    public boolean blockedMove(Piece piece, String movement) {
        return true;
    }

    public void takePiece(String piece, String move) {

    }

    public void promotion(String piece, String move) {
        if (validMove(turn, piece, move)) {
            takePiece(piece, move);

        }
    }

    public void enPassant(String movement) {

    }

    public void castle(String movement) {

    }

    public String translateColor(boolean color) {
        if (color)
            return "White";
        else
            return "Black";
    }

    public boolean translateColor(String color){
            if (color.toLowerCase().equals("white"))
                return true;
            else
                return false;
    }

    public Piece[][] getGameBoard() {
        return gameBoard;
    }
}

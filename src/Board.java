import java.util.function.BinaryOperator;

public class Board {

    private Piece[][] gameBoard;
    private boolean turn;

    public Board(){

    }

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

    public String translateColor(boolean color) {
        if (color)
            return "White";
        else
            return "Black";
    }

    public boolean translateColor(String color) {
        if (color.toLowerCase().equals("white"))
            return true;
        else
            return false;
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
                return movement.substring(1, 3);
            } else if (isPreciseMove(movement)) {
                return movement.substring(2, 4);
            }
        }
        return movement.substring(1, 3);
    }

    public void movePiece(String movement) {
        String name = interpretPieceName(movement);
        String move = interpretMove(movement);
        String toPiece = "";
        Piece piece = searchForPiece(name, translateColor(turn), move);
        if (piece != null) {
            takePiece(piece, move);
            if (isPromotion(movement)) {
                promotion(piece, toPiece);
            }
        }
    }

    public boolean validMove(Piece piece, String move) {
        for (String i : piece.getPossibleMoves()) {
            if(i.equals(move))
            {
                return true;
            }
        }
        return false;
    }

    public boolean blockedMove(String name, String movement) {
        return true;
    }

    private void takePiece(Piece piece, String move) {

    }

    private void promotion(Piece piece, String toPiece) {


    }

    private void enPassant(String movement) {

    }

    private void castle(String movement) {

    }

    public Piece searchForPiece(String name, String color, String move) {
        Piece piece = new Piece(name, color);
        int row = 0;
        int col = 0;

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (validMove(piece, move)) {
                    row = i;
                    col = j;
                }
            }
        }
        if (name.length() > 1) {
            try {
                row = translateRow(Integer.parseInt(name.substring(1, 2)));
            } catch (NumberFormatException | NullPointerException nfe) {
                col = translateCol(name.substring(1,2));
            }
        }
        piece.setLocation(row, col);
        return piece;
    }

    public Piece[][] getGameBoard() {
        return gameBoard;
    }
    public String toString() {
        String output = "";
        String pieceName = "";
        int j = 8;
        String colorH = "";
        for (Piece[] i : gameBoard) {
            output += j + " ";
            for (Piece h : i) {
                if (!h.getName().equals("Empty")) {
                    if (translateColor(h.getColor())) {
                        colorH = "W";
                    } else {
                        colorH = "B";
                    }
                } else
                    colorH = "";
                pieceName = colorH + h.getName();
                while (pieceName.length() < 8) {
                    pieceName += " ";
                }
                output += pieceName;
            }
            output += "\n";
            j--;
        }
        output += "     A      B       C       D       E       F       G      H";
        return output;
    }
}

public class Board {

    private Piece[][] gameBoard;
    private boolean turn = true;

    public Board() {

        gameBoard = new Piece[8][8];

        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[1][i] = new Piece("Pawn", "Black");
            gameBoard[1][i].setLocation(1, i);
            gameBoard[6][i] = new Piece("Pawn", "White");
            gameBoard[6][i].setLocation(6, i);
        }

        gameBoard[0][0] = new Piece("Rook", "Black");
        gameBoard[0][1] = new Piece("Knight", "Black");
        gameBoard[0][2] = new Piece("Bishop", "Black");
        gameBoard[0][3] = new Piece("Queen", "Black");
        gameBoard[0][4] = new Piece("King", "Black");
        gameBoard[0][5] = new Piece("Bishop", "Black");
        gameBoard[0][6] = new Piece("Knight", "Black");
        gameBoard[0][7] = new Piece("Rook", "Black");

        gameBoard[0][0].setLocation(0, 0);
        gameBoard[0][1].setLocation(0, 1);
        gameBoard[0][2].setLocation(0, 2);
        gameBoard[0][3].setLocation(0, 3);
        gameBoard[0][4].setLocation(0, 4);
        gameBoard[0][5].setLocation(0, 5);
        gameBoard[0][6].setLocation(0, 6);
        gameBoard[0][7].setLocation(0, 7);

        gameBoard[7][0] = new Piece("Rook", "White");
        gameBoard[7][1] = new Piece("Knight", "White");
        gameBoard[7][2] = new Piece("Bishop", "White");
        gameBoard[7][3] = new Piece("Queen", "White");
        gameBoard[7][4] = new Piece("King", "White");
        gameBoard[7][5] = new Piece("Bishop", "White");
        gameBoard[7][6] = new Piece("Knight", "White");
        gameBoard[7][7] = new Piece("Rook", "White");

        gameBoard[7][0].setLocation(7, 0);
        gameBoard[7][1].setLocation(7, 1);
        gameBoard[7][2].setLocation(7, 2);
        gameBoard[7][3].setLocation(7, 3);
        gameBoard[7][4].setLocation(7, 4);
        gameBoard[7][5].setLocation(7, 5);
        gameBoard[7][6].setLocation(7, 6);
        gameBoard[7][7].setLocation(7, 7);

        for (int i = 2; i < 6; i++) {
            for (int b = 0; b < 8; b++) {
                gameBoard[i][b] = new Piece("Empty", " ");
                gameBoard[i][b].setLocation(i, b);
            }
        }

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j].setLocation(i, j);
                //System.out.println(gameBoard[i][j].getName()+gameBoard[i][j].getLocation("h")+gameBoard[i][j].getLocation(1));
            }
        }
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
        else if (row == 0)
            y = 8;

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
        else if (!color)
            return "Black";
        else
            return " ";
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

    public int isCastle(String movement) {
        if (movement.contains("o")) {
            if (movement.replaceAll("-", "").length() == 2) {
                return 1;
            }
            if (movement.replaceAll("-", "").length() == 3) {
                return 2;
            }
        }
        return 0;
    }

    public boolean validEnPassant(String movement) {
        return false;
    }

    public boolean validCastle(String movement, int type, boolean color) {
        if (type == 1) {
            if (color) {
                if (gameBoard[7][4].getTurnsSinceFirstMove() == 0 && gameBoard[7][7].getTurnsSinceFirstMove() == 0) {
                    return true;
                } else
                    return false;
            } else {
                if (gameBoard[0][4].getTurnsSinceFirstMove() == 0 && gameBoard[0][7].getTurnsSinceFirstMove() == 0) {
                    return true;
                } else
                    return false;
            }
        } else if (type == 2) {
            if (color) {
                if (gameBoard[7][4].getTurnsSinceFirstMove() == 0 && gameBoard[7][0].getTurnsSinceFirstMove() == 0) {
                    return true;
                } else
                    return false;
            } else {
                if (gameBoard[0][4].getTurnsSinceFirstMove() == 0 && gameBoard[0][0].getTurnsSinceFirstMove() == 0) {
                    return true;
                } else
                    return false;
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
        String toPiece = movement.substring(movement.length() - 1);
        int cast = isCastle(movement);
        Piece piece = searchForPiece(name, translateColor(turn), move);
        System.out.println((piece.getName() + piece.getLocation(1)));
        if (!piece.getName().equals("Empty")) {
            takePiece(piece, move);
            if (isPromotion(movement)) {
                promotion(piece, toPiece);
            }
            if (cast > 0) {
                if (validCastle(movement, cast, turn)) {
                    castle(cast, turn);
                }
            }
        }
    }

    private void castle(int type, boolean color) {
        if (type == 1) {
            if (color) {
                gameBoard[7][6] = gameBoard[7][4];
                gameBoard[7][7] = gameBoard[7][5];
                gameBoard[7][4].setLocation(7, 4);
                gameBoard[7][5].setLocation(7, 5);
            } else {
                gameBoard[0][6] = gameBoard[0][4];
                gameBoard[0][7] = gameBoard[0][5];
                gameBoard[0][4].setLocation(0, 4);
                gameBoard[0][5].setLocation(0, 5);
            }
        } else if (type == 2) {
            if (color) {
                gameBoard[7][6] = gameBoard[7][2];
                gameBoard[7][0] = gameBoard[7][3];
                gameBoard[7][2].setLocation(7, 2);
                gameBoard[7][3].setLocation(7, 3);
            } else {
                gameBoard[0][6] = gameBoard[0][2];
                gameBoard[0][0] = gameBoard[0][3];
                gameBoard[0][2].setLocation(0, 2);
                gameBoard[0][3].setLocation(0, 3);
            }
        }
    }

    public boolean validMove(Piece piece, String move) {
        int x = translateCol(move.substring(0, 1));
        int y = translateRow(Integer.parseInt(move.substring(1)));
        int pieceY = Integer.parseInt(piece.getLocation(1).substring(0, 1));
        int pieceX = Integer.parseInt(piece.getLocation(1).substring(1));
        int rowDirection = 0;
        int colDirection = 0;


        if (pieceX > x) {
            colDirection = -1;
        } else if (pieceX < x) {
            colDirection = 1;
        }
        if (pieceY > y) {
            rowDirection = -1;
        } else if (pieceY < y) {
            rowDirection = 1;
        }

        //System.out.println(pieceX);
        //System.out.println(pieceY);
        //System.out.println(x);
        //System.out.println(y);
        int moveToX = pieceX + (x * colDirection);
        int moveToY = pieceY + (y * rowDirection);
        //System.out.println(moveToX);
        //System.out.println(moveToY);

        for (String i : piece.getPossibleMoves()) {
            //System.out.println(i);
            //System.out.println(i.equals(move) && !blockedMove(piece, move));
            if (i.equals(move)) {
                //System.out.println(i.equals(move));
                //System.out.println("h" + !translateColor(getPiece(""+moveToX+moveToY).getColor()));
                //System.out.println("h" + getPiece(""+moveToX+moveToY).getName().equals("Empty"));
                System.out.print(move);
                if(blockedMove(piece,move)) {
                    if (translateColor(getPiece("" + moveToX + moveToY).getColor()) != turn || getPiece("" + moveToX + moveToY).getName().equals("Empty")) {
                        System.out.println("Valid Move");
                        return true;
                    } else {
                        System.out.println("invalid move");
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean blockedMove(Piece piece, String movement) {

        if (piece.getName().equals("Knight")) {
            return false;
        }
        int x = translateCol(movement.substring(0, 1));
        int y = translateRow(Integer.parseInt(movement.substring(1)));
        int pieceX = Integer.parseInt(piece.getLocation(1).substring(1));
        int pieceY = Integer.parseInt(piece.getLocation(1).substring(0,1));
        int rowDirection = 0;
        int colDirection = 0;


        if (pieceX == x && pieceY == y)
            return false;

        if (pieceX > x) {
            colDirection = -1;
        } else if (pieceX < x) {
            colDirection = 1;
        }
        if (pieceY > y) {
            rowDirection = 1;
        } else if (pieceY < y) {
            rowDirection = -1;
        }

        String move = "" + translateCol(x + colDirection) + translateRow(y + rowDirection);

        System.out.print(move);
        if (validMove(piece, move)) {
            System.out.println("valid move h");
            return false;
        } else
            return true;
    }

    private void takePiece(Piece piece, String move) {
        System.out.println("Taking Piece");
        System.out.println(move);
        int x = translateCol(move.substring(0, 1));
        int y = translateRow(Integer.parseInt(move.substring(1)));
        int pieceY = Integer.parseInt(piece.getLocation(1).substring(0, 1));
        int pieceX = Integer.parseInt(piece.getLocation(1).substring(1));

        gameBoard[y][x] = piece;
        gameBoard[y][x].setLocation(y, x);
        gameBoard[x][y].moved();
        gameBoard[pieceY][pieceX] = new Piece("Empty", " ");
        gameBoard[pieceY][pieceX].setLocation(pieceY, pieceX);
        turn = !turn;
    }

    private void promotion(Piece piece, String toPiece) {

    }

    private boolean inCheck() {
        return true;
    }

    public Piece searchForPiece(String name, String color, String move) {
        int row = 0;
        int col = 0;
        if (name.length() > 1) {
            try {
                row = translateRow(Integer.parseInt(name.substring(1, 2)));
            } catch (NumberFormatException | NullPointerException nfe) {
                col = translateCol(name.substring(1, 2));
            }
        }
        for (int i = row; i < gameBoard.length; i++) {
            for (int j = col; j < gameBoard[i].length; j++) {
                //System.out.println("Piece : " + i + j);
                //System.out.println(gameBoard[i][j].getColor().equals(color));
                //System.out.println(gameBoard[i][j].translateName().equals(name.substring(0,1)));
                //System.out.println(validMove(gameBoard[i][j], move));
                if (gameBoard[i][j].getColor().equals(color) && gameBoard[i][j].translateName().equals(name.substring(0, 1)) && validMove(gameBoard[i][j], move)) {
                    System.out.println("valid");
                    row = i;
                    col = j;
                    return gameBoard[row][col];
                }
            }
        }
        return new Piece("Empty", " ");
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
                if (translateColor(h.getColor())) {
                    colorH = "W";
                } else if (h.getName().equals("Empty")) {
                    colorH = "";
                } else if (!translateColor(h.getColor())) {
                    colorH = "B";
                }
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

    public Piece getPiece(String location) {
        int col = Integer.parseInt(location.substring(0, 1));
        int row = Integer.parseInt(location.substring(1));
        return gameBoard[row][col];
    }

}

public class Board {
    private Piece[][] chessBoard;
    private double advantage = 0;
    private boolean checkingIfBlocked = false;

    public Board() {
        chessBoard = new Piece[8][8];
        resetBoard();
    }

    public void resetBoard() {


        for (int i = 0; i < chessBoard[0].length; i++) {
            chessBoard[1][i] = new Pawn();
            chessBoard[1][i].setColor(false);

            chessBoard[6][i] = new Pawn();
            chessBoard[6][i].setColor(true);
        }

        chessBoard[0][0] = new Rook();
        chessBoard[0][1] = new Knight();
        chessBoard[0][2] = new Bishop();
        chessBoard[0][3] = new Queen();
        chessBoard[0][4] = new King();
        chessBoard[0][5] = new Bishop();
        chessBoard[0][6] = new Knight();
        chessBoard[0][7] = new Rook();

        chessBoard[7][0] = new Rook();
        chessBoard[7][1] = new Knight();
        chessBoard[7][2] = new Bishop();
        chessBoard[7][3] = new Queen();
        chessBoard[7][4] = new King();
        chessBoard[7][5] = new Bishop();
        chessBoard[7][6] = new Knight();
        chessBoard[7][7] = new Rook();

        for (int i = 0; i < chessBoard[0].length; i++) {
            chessBoard[0][i].setColor(false);
        }

        for (int i = 0; i < chessBoard[7].length; i++) {
            chessBoard[7][i].setColor(true);
        }

        for (int i = 2; i < 6; i++) {
            for (int b = 0; b < 8; b++) {
                chessBoard[i][b] = new Empty();
            }
        }

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                chessBoard[i][j].setLocation(i, j);
                // System.out.println("" + chessBoard[i][j].getRow() + " " + chessBoard[i][j].getCol());
            }
        }
    }

    public boolean validMove(Piece x, Movement m) {
        if (m.getMovementRow()==0&&m.getMovementCol()==0)
        {
            System.out.println("You can't move a piece to its own spot!");
            return true;
        }
        if (checkingIfBlocked&&chessBoard[x.getRow()+m.getMovementRow()][x.getCol()+m.getMovementCol()].getPieceName().equals("Empty"))
        {
            System.out.println("Blocked by a piece!");
            return false;
        }
        if (x.getRow() + m.getMovementRow() >= 0 && x.getCol() + m.getMovementCol() >= 0 && x.getRow() + m.getMovementRow() < 8 && x.getCol() + m.getMovementCol() < 8) {
            System.out.println("Movement  " + m.getMovementRow() + " " + m.getMovementCol());
            System.out.println("By Piece At: " + x.getRow() + " " + x.getCol());
            if(chessBoard[x.getRow()+m.getMovementRow()][x.getCol()+m.getMovementCol()].getColor()==x.getColor())
            {
                System.out.println("Can not take piece of same Color!");
                return false;
            }
            for (int i = 0; i < x.pieceMovement().length; i++) {
                System.out.println("Trying Possible Move: " + x.pieceMovement()[i].getMovementRow() + " " + x.pieceMovement()[i].getMovementCol());

                int checkRow = 0;
                int checkCol = 0;

                if (m.getMovementCol() == x.pieceMovement()[i].getMovementCol() && m.getMovementRow() == x.pieceMovement()[i].getMovementRow()) {
                    if (x.getPieceName().equals("Knight")) {
                        System.out.println("Valid Move.");
                        return true;
                    }
                    checkingIfBlocked = true;
                    if (m.getMovementRow() > x.getRow()) {
                        checkRow = -1;
                    }
                    if (m.getMovementRow() < x.getRow()) {
                        checkRow = 1;
                    }
                    if (m.getMovementCol() > x.getCol()) {
                        checkCol = -1;
                    }
                    if (m.getMovementCol() < x.getCol()) {
                        checkCol = 1;
                    }
                    if (m.getMovementCol() == 0) {
                        Movement tempMov = new Movement(m.getMovementRow() + checkRow, 0);


                        if (validMove(x, tempMov)) {
                            System.out.println("Valid Move.");
                            return true;
                        }
                        System.out.println("Illegal Move");
                        return false;

                    }
                    if (m.getMovementRow() == 0) {
                        Movement tempMov = new Movement(0, m.getMovementCol() + checkCol);
                        if (validMove(x, tempMov)) {
                            System.out.println("Valid Move.");
                            return true;
                        }
                        System.out.println("Illegal Move");
                        return false;
                    } else {
                        Movement tempMov = new Movement(m.getMovementRow() + checkRow, m.getMovementCol() + checkCol);
                        if (validMove(x, tempMov)) {
                            System.out.println("Valid Move.");
                            return true;
                        }
                        System.out.println("Illegal Move");
                        return false;
                    }
                }

            }
        }
        System.out.println("Illegal Move");
        return false;
    }

    public void movePiece(Piece x, Movement m) {

        if (validMove(x, m)) {
            System.out.println("Move Identified.");
            if (x.getPieceName().equals("Pawn")) {
                x.moved();
            }
            takePiece(chessBoard[x.getRow() + m.getMovementRow()][x.getCol() + m.getMovementCol()], x);
        } else System.out.println("Illegal Move");
    }


    public void takePiece(Piece d, Piece a) {
        boolean defendingColor = d.getColor();
        boolean attackingColor = a.getColor();
        System.out.println("Attempted Take By Piece At " + a.getRow() + " " + a.getCol() + " to " + d.getRow() + " " + d.getCol());

        if (defendingColor != attackingColor || d.getPieceName().equals("Empty")) {
            System.out.println("Take Success");

            int tempCol = a.getCol();
            int tempRow = a.getRow();

            chessBoard[d.getRow()][d.getCol()] = a;
            a.setLocation(d.getRow(), d.getCol());

            chessBoard[tempRow][tempCol] = new Empty();

            if (defendingColor) {
                advantage += d.getPieceValue();
                System.out.println("White Advantage");
            } else {
                advantage -= d.getPieceValue();
                System.out.println("Black Advantage");
            }
        } else {
            System.out.println("Take Failed");
        }

    }

    public double getAdvantage() {
        return advantage;
    }

    public Piece[][] getBoard() {
        return chessBoard;
    }

    public String toString() {
        String output = "";
        for (Piece[] i : chessBoard) {
            for (Piece h : i) {
                output += h.getPieceName() + " ";
            }
            output += "\n";
        }
        return output;
    }
}

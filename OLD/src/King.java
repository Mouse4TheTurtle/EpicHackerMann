package src;

import java.util.ArrayList;

public class King extends Piece {
    private double pieceValue = 100;
    private String pieceName = "King";
    private boolean color;
    private Movement[] movements;
    private int pieceCol;
    private int pieceRow;
    private ArrayList<BoardSituation> valuedSituations = new ArrayList<BoardSituation>();
    DataTransfer data = new DataTransfer(null, null);

    public Movement[] pieceMovement() {
        movements = new Movement[8];

        movements[0] = new Movement(0, 1);
        movements[1] = new Movement(0, -1);
        movements[2] = new Movement(1, 0);
        movements[3] = new Movement(1, 1);
        movements[4] = new Movement(1, -1);
        movements[5] = new Movement(-1, 1);
        movements[6] = new Movement(-1, 0);
        movements[7] = new Movement(-1, -1);

        return movements;
    }

    public double getPieceValue() {
        return pieceValue;
    }

    public String getPieceName() {
        return pieceName;
    }

    public boolean getColor() {
        return color;
    }

    public int getRow() {
        return pieceRow;
    }

    public int getCol() {
        return pieceCol;
    }

    public void setLocation(int row, int col) {
        pieceCol = col;
        pieceRow = row;
    }

    public void setColor(boolean x) {
        color = x;
    }

    public ArrayList<BoardSituation> getValuedSituations() {
        return valuedSituations;
    }

    public void setValuedSituations() {
        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {

                valuedSituations.add(data.readBoardSituation(this,i)) ;
            }
        }
        catch (NullPointerException e)
        {
        }
    }

    public void setPieceValue() {
        pieceValue = data.readPtVal(this);
    }

    public void setPieceValue(double val) {
        pieceValue = val;
    }
}

public class Bishop extends Piece {
    private double pieceValue = 3;
    private String pieceName = "Bishop";
    private boolean color;
    private Movement[] movements;
    private int pieceCol;
    private int pieceRow;

    public Movement[] pieceMovement() {
        movements = new Movement[7 * 4];
        int index = 0;
        for (int i = 0; index < movements.length; i++) {
            movements[index] = new Movement(1 + i, 1 + i);
            index++;
            movements[index] = new Movement(1 + i, -1 - i);
            index++;
            movements[index] = new Movement(-1 - i, 1 + i);
            index++;
            movements[index] = new Movement(-1 - i, -1 - i);
            index++;
        }
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
    public void setColor(boolean x)
    {
        color = x;
    }
    public void setPieceValue()
    {
        DataTransfer data = new DataTransfer(null,null);
        pieceValue = data.readPtVal(this);
    }
}
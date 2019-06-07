abstract class Piece
{
    private double pieceValue;
    private String pieceName;
    private boolean color;
    private Movement[] movements;
    private int pieceCol;
    private int pieceRow;

    public Movement[] pieceMovement()
    {
        return movements;
    }

    public double getPieceValue() {
        return pieceValue;
    }

    public String getPieceName()
    {
        return pieceName;
    }

    public boolean getColor()
    {
        return color;
    }

    public void setColor(boolean x)
    {
        color = x;
    }

    public int getRow()
    {
        return pieceRow;
    }
    public int getCol()
    {
        return pieceCol;
    }
    public void moved()
    {
    }
    public void setLocation(int row, int col) {
        pieceCol = col;
        pieceRow = row;
    }
    public void readPieceValue()
    {
        DataTransfer data = new DataTransfer(null,null);
        pieceValue = data.readPtVal(this);
    }
}
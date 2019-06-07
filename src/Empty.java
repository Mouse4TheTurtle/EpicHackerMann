public class Empty extends Piece
{
    private double pieceValue = 0;
    private String pieceName = "Empty";
    private boolean color;
    private Movement[] movements;
    private int pieceCol;
    private int pieceRow;

    public Movement[] pieceMovement()
    {
        movements = new Movement[1];
        movements[0] = new Movement(0,0);

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

    public int getRow()
    {
        return pieceRow;
    }
    public int getCol()
    {
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
    public void readPieceValue()
    {
        DataTransfer data = new DataTransfer(null,null);
        pieceValue = data.readPtVal(this);
    }
}
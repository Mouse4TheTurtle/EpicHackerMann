public class Knight extends Piece
{
    private double pieceValue = 3;
    private String pieceName = "Knight";
    private boolean color;
    private Movement[] movements;
    private int pieceCol;
    private int pieceRow;


    public Movement[] pieceMovement()
    {
        movements = new Movement[8];
        movements[0] = new Movement(2,1);
        movements[1] = new Movement(2,-1);
        movements[2] = new Movement(1,2);
        movements[3] = new Movement(1,-2);
        movements[4] = new Movement(-2,-1);
        movements[5] = new Movement(-2,1);
        movements[6] = new Movement(-1,2);
        movements[7] = new Movement(-1,-2);
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

    public int getCol()
    {
        return pieceCol;
    }


    public int getRow()
    {
        return pieceRow;
    }

    public void setLocation(int row, int col)
    {
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
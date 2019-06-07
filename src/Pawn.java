public class Pawn extends Piece
{
    private double pieceValue = 1;
    private String pieceName = "Pawn";
    private boolean color;
    private Movement[] movements;
    private int pieceCol;
    private int pieceRow;
    private boolean firstMove = true;

    public Movement[] pieceMovement()
    {/*

        if (firstMove=true)
        {
            movements = new Movement[2];
            movements[0] = new Movement(1,0);
            movements[0] = new Movement(2,0);
        }

        if (firstMove=false)
        {*/
        movements = new Movement[1];
        if(color)
            movements[0] = new Movement(-1,0);
        else
            movements[0] = new Movement(1,0);
       // }

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

    public void moved()
    {
        this.firstMove = false;
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
}
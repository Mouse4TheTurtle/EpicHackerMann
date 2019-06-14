package oldsrc;

public class Movement
{
 private int movementRow;
 private int movementCol;

    public Movement(int row, int col)
    {
        movementRow = row;
        movementCol = col;
    }
    public int getMovementCol() {
        return movementCol;
    }

    public int getMovementRow() {
        return movementRow;
    }

}

package oldsrc;

public class BoardSituation {

    private Board board;
    private double value;
    private Piece piece;

    public BoardSituation() {
        board = new Board();
        value = -1;
    }

    public void setSituationBoard(Board board1)
    {
        board.setBoard(board1);
    }

    public void setSituationValue(double value1) {
        value = value1;
    }

    public void setSituationPiece(Piece piece1){
        piece = piece1;
    }

    public Piece getSituationPiece() {
        return piece;
    }

    public double getSituationValue()
    {
        return value;
    }

    public Board getSituationBoard()
    {
        return board;
    }

    public String toString()
    {
        String output = "";

        output += board.toString();

        System.out.println("This board gives " + piece.getPieceName() + " a value of " + value);

        return output;
    }
}

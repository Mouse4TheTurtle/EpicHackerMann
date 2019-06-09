public class BoardSituation {

    private Board board;
    private double value;

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

    public double getPieceValueData()
    {
        return value;
    }

    public Board getBoardData()
    {
        return board;
    }

    public String toString()
    {
        String output = "";

        output += board.toString();
        System.out.println("This board gives the piece a value of " + value);

        return output;
    }
}

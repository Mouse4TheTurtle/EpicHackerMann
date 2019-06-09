public class boardSituation {

    Board board;

    public boardSituation()
    {
        board = new Board();
    }

    public void setBoardSituation()
    {
        DataTransfer data = new DataTransfer(null, null);
        data.readBoardSituation();
    }

}

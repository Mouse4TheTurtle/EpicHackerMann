public class GameTesting {
    public static void main(String[] args) {
        Board gamer = new Board();
        DataTransfer data = new DataTransfer(null,null);
        Piece temp = new Empty();
        temp.setLocation(1,0);
        gamer.setPiece(temp);
        System.out.println("Writing...");
        data.writeBoardSituation(gamer.getBoard()[0][0],gamer,gamer.getBoard()[0][1].getPieceValue()+.5);
        data.readBoardSituation(gamer.getBoard()[0][0],0);
    }
}



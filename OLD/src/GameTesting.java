package src;

public class GameTesting {
    public static void main(String[] args) {

        Board gamer = new Board();
        DataTransfer data = new DataTransfer(null,null);
        //BoardSituation situation = new BoardSituation();
        //Piece temp = new Empty();
        //temp.setLocation(7,0);
        //gamer.setPiece(temp);
        //System.out.println("Writing...");
        //data.writeBoardSituation(gamer.getBoard()[0][0],gamer,gamer.getBoard()[0][1].getPieceValue()+.5);
        //situation = data.readBoardSituation(gamer.getPiece(0,0),0);
        //System.out.println(situation);
        //Piece set;
        //set = data.makePieceFromData(gamer.getPiece(0,0).getColor(),gamer.getPiece(0,0).getPieceName(),gamer.getPiece(0,0).getRow(),gamer.getPiece(0,0).getCol());
        //set.setValuedSituations(situation);
        //gamer.setPiece(set);
        //System.out.println(gamer.getPiece(0,0).getValuedSituations().get(0));
        System.out.println(gamer);
    }
}



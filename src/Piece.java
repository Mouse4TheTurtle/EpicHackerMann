import java.util.ArrayList;

public class Piece {

    private String name = "";
    private String color = "";
    private double value = 0.0;
    private int row;
    private int col;
    private String[] possibleMoves;
    private ArrayList<int[]> moves;
    private int turnsSinceFirstMove = 0;
    DataTransfer data = new DataTransfer();
    Board board = new Board();

    public Piece(String name, String color, double value, int row, int col) {
        if(name.equals("Q"))
            name="Queen";
        if(name.equals("N"))
            name="Knight";
        if(name.equals(" "))
            name="Pawn";
        if(name.equals("B"))
            name="Bishop";
        if(name.equals("R"))
            name="Rook";
        if(name.equals("K"))
            name="King";
        this.name = name;
        this.color = color;
        this.value = value;
        this.row = row;
        this.col = col;
        moves = data.getMovements(name);
    }

    public void calcMoves(){
        int moveRow;
        int moveCol;
        possibleMoves = new String[moves.size()];
        for (int i = 0; i<moves.size(); i++) {
                moveRow = row + moves.get(i)[0];
                moveCol = col + moves.get(i)[1];
                possibleMoves[i] = "" + moveRow + board.translateCol(moveCol);
        }
    }

    public String[] getPossibleMoves() {
        calcMoves();
        return possibleMoves;
    }

    public ArrayList<int[]> getMoves() {
        return moves;
    }

    public void setLocation(int row, String col){
        this.row = row;
        this.col = board.translateCol(col);
    }

    public void setLocation(int row, int col){
        this.row = row;
        this.col = col;
    }

    public void moved(){
        turnsSinceFirstMove++;
    }

    public int getTurnsSinceFirstMove(){
        return turnsSinceFirstMove;
    }
}

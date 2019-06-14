import java.util.ArrayList;

public class Piece {

    private String name = "";
    private String color = "";
    private int row;
    private int col;
    private String[] possibleMoves;
    private ArrayList<int[]> moves;
    private int turnsSinceFirstMove = 0;
    private DataTransfer data = new DataTransfer();

    public Piece(String name, String color) {
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
       // System.out.println(name);
        moves = data.getMovements(name);
    }

    public String getName() {
        return name;
    }

    public String getColor(){
        return color;
    }

    public void calcMoves(){
        int moveRow;
        int moveCol;
        if (name.equals("Pawn"))
        {
            if(color.equals("White")) {
                int[] a = {-1, 0};
                moves.set(0,a);
            }
            if(turnsSinceFirstMove==0){
                if(color.equals("White")) {
                    int[] a = {-2, 0};
                    moves.add(1,a);
                }
                else
                {
                    int[] a = {2, 0};
                    moves.add(1,a);
                }
            }
            if(turnsSinceFirstMove>0)
            {
                if(moves.size()>1)
                {
                    moves.remove(1);
                }
            }
        }
        possibleMoves = new String[moves.size()];
        for (int i = 0; i<moves.size(); i++) {
            moveRow = row + moves.get(i)[0];
            moveCol = col + moves.get(i)[1];
            possibleMoves[i] = "" + translateCol(moveCol) + translateRow(moveRow);
            //System.out.println(possibleMoves[i]);
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
        this.row = translateRow(row);
        this.col = translateCol(col);
    }

    public void setLocation(int row, int col){
        this.row = row;
        this.col = col;
    }

    public void setLocation(String location){
        this.row = translateRow(Integer.parseInt(location.substring(1)));
        this.col = translateCol(location.substring(0,1));
    }

    public String getLocation(String string){
        return "" + translateRow(row) + translateCol(col);
    }

    public String getLocation(int integer)
    {
        return "" + row + col;
    }

    public void moved(){
        turnsSinceFirstMove++;
    }

    public int getTurnsSinceFirstMove(){
        return turnsSinceFirstMove;
    }

    public int translateRow(int row) {

        int y = -1;

        if (row == 8)
            y = 0;
        else if (row == 7)
            y = 1;
        else if (row == 6)
            y = 2;
        else if (row == 5)
            y = 3;
        else if (row == 4)
            y = 4;
        else if (row == 3)
            y = 5;
        else if (row == 2)
            y = 6;
        else if (row == 1)
            y = 7;
        else if (row == 0)
            y = 8;

        return y;
    }

    public int translateCol(String col) {

        int x = -1;

        if (col.toLowerCase().contains("a"))
            x = 0;
        if (col.toLowerCase().contains("b"))
            x = 1;
        if (col.toLowerCase().contains("c"))
            x = 2;
        if (col.toLowerCase().contains("d"))
            x = 3;
        if (col.toLowerCase().contains("e"))
            x = 4;
        if (col.toLowerCase().contains("f"))
            x = 5;
        if (col.toLowerCase().contains("g"))
            x = 6;
        if (col.toLowerCase().contains("h"))
            x = 7;

        return x;
    }

    public String translateCol(int col) {

        String out = "";

        if (col == 0)
            out = "a";
        if (col == 1)
            out = "b";
        if (col == 2)
            out = "c";
        if (col == 3)
            out = "d";
        if (col == 4)
            out = "e";
        if (col == 5)
            out = "f";
        if (col == 6)
            out = "g";
        if (col == 7)
            out = "h";

        return out;
    }

    public String translateColor(boolean color) {
        if (color)
            return "White";
        else if (!color)
            return "Black";
        else
            return " ";
    }

    public boolean translateColor(String color) {
        if (color.toLowerCase().equals("white"))
            return true;
        else
            return false;
    }

    public String translateName(){
        if(name.equals("Pawn"))
            return " ";
        if(name.equals("Knight"))
            return "N";
        return name.substring(0,1);
    }
}

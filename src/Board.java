public class Board
{
    private Piece[][] chessBoard;
    private double advantage = 0;

    public Board()
    {
        chessBoard = new Piece[8][8];
        resetBoard();
    }

    public void resetBoard()
    {


        for (int i = 0; i < chessBoard[0].length; i++)
        {
            chessBoard[1][i] = new Pawn();
            chessBoard[1][i].setColor(false);

            chessBoard[6][i] = new Pawn();
            chessBoard[6][i].setColor(true);
        }

        chessBoard[0][0] = new Rook();
        chessBoard[0][1] = new Knight();
        chessBoard[0][2] = new Bishop();
        chessBoard[0][3] = new Queen();
        chessBoard[0][4] = new King();
        chessBoard[0][5] = new Bishop();
        chessBoard[0][6] = new Knight();
        chessBoard[0][7] = new Rook();

        chessBoard[7][0] = new Rook();
        chessBoard[7][1] = new Knight();
        chessBoard[7][2] = new Bishop();
        chessBoard[7][3] = new Queen();
        chessBoard[7][4] = new King();
        chessBoard[7][5] = new Bishop();
        chessBoard[7][6] = new Knight();
        chessBoard[7][7] = new Rook();

        for (int i = 0; i<chessBoard[0].length; i++)
        {
            chessBoard[0][i].setColor(false);
        }

        for (int i = 0; i<chessBoard[7].length; i++)
        {
            chessBoard[7][i].setColor(true);
        }

        for(int i = 2; i<6; i++)
        {
            for (int b=0; b<8;b++)
            {
                chessBoard[i][b] = new Empty();
            }
        }
    }

    public boolean validMove(Piece x, Movement m)
    {
        if(x.getRow()+m.getMovementRow()>=0&&x.getCol()+m.getMovementCol()>=0&&x.getRow()+m.getMovementRow()<8&&x.getCol()+m.getMovementCol()<8)
        {
            for (Movement i : x.pieceMovement())
            {
                if (m.getMovementCol() == i.getMovementCol() && m.getMovementRow() == i.getMovementRow())
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void movePiece(Piece x, Movement m)
    {

        if(validMove(x, m))
        {
            if (x.getPieceName()=="Pawn")
            {
                x.moved();
            }

            takePiece(chessBoard[x.getRow()+m.getMovementRow()][x.getCol()+m.getMovementCol()],x);
        }
        else System.out.println("Invalid Move!");
    }

    public void takePiece(Piece d, Piece a)
    {
        boolean defendingColor = d.getColor();
        boolean attackingColor = a.getColor();

        if(defendingColor!=attackingColor)
        {
            int tempRow;
            int tempCol;
            tempCol = a.getCol();
            tempRow = a.getRow();

            chessBoard[d.getRow()][d.getCol()]=a;
            a.setLocation(d.getRow(),d.getCol());

            chessBoard[tempCol][tempRow]=d;
            d.setLocation(tempRow,tempCol);

            if (defendingColor=true)
                advantage+=d.getPieceValue();
            else
                advantage-=d.getPieceValue();
        }
    }

    public double getAdvantage()
    {
        return advantage;
    }

    public String toString()
    {
        String output = "";
        for (Piece[] i : chessBoard)
        {
            for (Piece h : i)
                {
                    output += h.getPieceName() + " ";
                }
                output+="\n";
            }
            return output;
        }
    }


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataTransfer {
    private String writeTo;
    private String readFrom;
    private Path workingDirectory = Paths.get("").toAbsolutePath();
    private File dataOutput;
    private File dataInput;
    private String[] pieceNames = new String[7];

    public DataTransfer(String write, String read) {
        writeTo = write;
        readFrom = read;
        dataOutput = new File(workingDirectory + "\\data\\" + writeTo);
        dataInput = new File(workingDirectory + "\\data\\" + readFrom);

        try {
            FileOutputStream is = new FileOutputStream(dataOutput);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.write("");
            w.close();
        } catch (IOException e) {
            System.err.println("Error");
        }
        pieceNames[0]="Rook";
        pieceNames[1]="King";
        pieceNames[2]="Queen";
        pieceNames[3]="Empty";
        pieceNames[4]="Bishop";
        pieceNames[5]="Knight";
        pieceNames[6]="Pawn";
    }

    public void writePieceData(Piece piece) {
        double pieceValue = piece.getPieceValue();
        String pieceName = piece.getPieceName();
        boolean color = piece.getColor();
        int pieceCol = piece.getCol();
        int pieceRow = piece.getRow();
        String colorH = "";
        if (color) {
            colorH = "White";
        } else {
            colorH = "Black";
        }
        if (pieceName != "Empty") {
            try {
                FileOutputStream is = new FileOutputStream(workingDirectory + "\\data\\PieceData\\" + colorH + "\\" + pieceName + ".txt");
                OutputStreamWriter osw = new OutputStreamWriter(is);
                Writer w = new BufferedWriter(osw);
                w.write("" + pieceValue + "\n" + pieceName + "\n" + colorH + "\n" + pieceRow + pieceCol);
                w.close();
            } catch (IOException e) {
                System.err.println("Error");
            }
        }
    }

    public Movement readMove(String input) {
        int col = 0;
        int row = 0;

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(dataInput));
            String line = reader.readLine();
            row = Integer.parseInt(line.substring(0, 1));
            col = Integer.parseInt(line.substring(1));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return new Movement(row, col);
    }

    public double readPtVal(Piece piece) {
        double value = 0;
        boolean color = piece.getColor();
        String colorH = "";
        if (color) {
            colorH = "White";
        } else {
            colorH = "Black";
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(workingDirectory + "\\data\\PieceData\\" + colorH + "\\ValueInput\\" + piece.getPieceName() + ".txt"));
            String line = reader.readLine();
            value = Double.parseDouble(line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    public String getDataOutput() {
        return "" + workingDirectory + "\\" + writeTo;
    }

    public String getDataInput() {
        return "" + workingDirectory + "\\" + readFrom;
    }

    public void writePieceMovements(Piece piece) {
        Movement[] movements = piece.pieceMovement();

        try {
            FileOutputStream is = new FileOutputStream(workingDirectory + "\\data\\PieceData\\Movements\\" + piece.getPieceName() + ".txt");
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            for (Movement i : movements) {
                w.write("" + i.getMovementRow() + "" + i.getMovementCol() + "\n");
            }

            w.close();
        } catch (IOException e) {
            System.err.println("Error");
        }
    }

    public BoardSituation readBoardSituation(Piece piece, int number) {

        BoardSituation situation = new BoardSituation();
        Board board = new Board();
        double value = 0;
        Piece tempPiece;
        boolean pieceColor;

        boolean color = piece.getColor();
        String colorH = "";
        if (color) {
            colorH = "White";
        } else {
            colorH = "Black";
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(workingDirectory + "\\data\\Board\\BoardSituations\\" + colorH + "\\" + piece.getPieceName() + "\\" + number + ".txt"));
            String line = reader.readLine();
            value = Double.parseDouble(line);

            int row = 0;
            int col = 0;
            String temp = new String();

            for (int i = 0; i < board.getBoard().length; i++) {
                line = reader.readLine();
                String h = line;
                System.out.println("Reading line: " + i);
                for (int j = 0; j < h.length(); j++) {
                    if(h.length()>10) {
                        if (h.substring(h.indexOf("|") + 1).indexOf("B") == 0) {
                            System.out.println("Piece is Black");
                            pieceColor = false;
                        } else {
                            System.out.println("Piece is White");
                            pieceColor = true;
                        }

                        for (String name : pieceNames) {
                            System.out.println("Reading Piece: " + col);
                            temp = h.substring(h.indexOf("|") + 1);
                            temp = temp.substring(1, temp.indexOf("|"));
                            System.out.println(temp);
                            if (temp.equals(name)) {
                                System.out.println("Piece is: " + name);
                                h = h.substring(3 + name.length());
                                piece = readPieceData(pieceColor, name);
                            }
                        }

                        piece.setLocation(i, col);
                        board.setPiece(piece);
                        col++;

                    }
                    else
                        j=h.length()+1;
                }
                row++;
            }
        } catch (IOException e) {
            System.out.println("Error while reading.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error while closing reader");
            }
        }
        System.out.println("Done Reading");
        return situation;
    }

    public void writeBoardSituation(Piece piece, Board board, double value) {
        int number = 0;
        String colorH = "";
        if (piece.getColor()) {
            colorH = "White";
        } else {
            colorH = "Black";
        }
        try {
            for (int i = 0; i < 99999; i++) {
                System.out.println("Try number " +i);
                number=i;
                if(new File (workingDirectory + "\\data\\Board\\BoardSituations\\" + colorH + "\\" + piece.getPieceName() + "\\" + number + ".txt").exists())
                {
                }
                else
                    i=99999;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error creating file.");
        }
        try {
            new File(workingDirectory + "\\data\\Board\\BoardSituations\\" + colorH + "\\" + piece.getPieceName()).mkdirs();
            FileOutputStream is = new FileOutputStream(workingDirectory + "\\data\\Board\\BoardSituations\\" + colorH + "\\" + piece.getPieceName() + "\\" + number + ".txt");
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.write(""+value+"\n");
            for (Piece[] a : board.getBoard()) {
                for (Piece b : a) {
                    if (b.getColor()) {
                        colorH = "White";
                    } else {
                        colorH = "Black";
                    }
                    w.write("|"+colorH.substring(0,1)+b.getPieceName());
                }
                w.write("|\n");
            }

            w.close();
        } catch (IOException e) {
            System.err.println("Error while writing");
        }
        System.out.println("Done Writing");
    }

    public Piece readPieceData(boolean color, String name) {
        Piece piece = new Empty();
        double value = 0;
        int row = 0;
        int col = 0;

        String colorH = "";
        if (color) {
            colorH = "White";
        } else {
            colorH = "Black";
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(workingDirectory + "\\data\\PieceData\\" + colorH + "\\" + name + ".txt"));
            String line = reader.readLine();
            value = Double.parseDouble(line);
            line = reader.readLine();
            line = reader.readLine();
            line = reader.readLine();
            row = Integer.parseInt(line.substring(0, 1));
            col = Integer.parseInt(line.substring(1));

            if (name.equals("Pawn"))
                piece = new Pawn();
            if (name.equals("Rook"))
                piece = new Rook();
            if (name.equals("Knight"))
                piece = new Knight();
            if (name.equals("Bishop"))
                piece = new Bishop();
            if (name.equals("Queen"))
                piece = new Queen();
            if (name.equals("King"))
                piece = new King();
            if (name.equals("Empty"))
                piece = new Empty();

            piece.setColor(color);
            piece.setPieceValue();
            piece.setLocation(row, col);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return piece;
    }
}
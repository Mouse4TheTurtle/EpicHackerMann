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
            while (line != null) {
                line = reader.readLine();
                String h = line;

                for (int i = 0; i < h.length(); i++) {
                    if (h.substring(h.indexOf("|") + 1).indexOf("B") == 0) {
                        pieceColor = false;
                    } else {
                        pieceColor = true;
                    }
                    for (String a : pieceNames) {
                        if (h.substring(h.indexOf("|")).substring(0, h.indexOf("|")).contains(a)) {
                            h = h.substring(3 + a.length());
                            piece = readPieceData(pieceColor, a);
                        }
                    }

                    piece.setLocation(row, col);
                    board.setPiece(piece);
                    col++;
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
                    w.write("|"+colorH.substring(0,1)+piece.getPieceName());
                }
                w.write("|\n");
            }

            w.close();
        } catch (IOException e) {
            System.err.println("Error");
        }
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
            reader = new BufferedReader(new FileReader(workingDirectory + "\\data\\Board\\BoardSituations\\" + colorH + "\\" + name + ".txt"));
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
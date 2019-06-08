import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataTransfer
{
    private String writeTo;
    private String readFrom;
    private Path workingDirectory = Paths.get("").toAbsolutePath();
    private File dataOutput;
    private File dataInput;

    public DataTransfer(String write, String read)
    {
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

    public void writePieceData(Piece piece)
    {
        double pieceValue = piece.getPieceValue();
        String pieceName = piece.getPieceName();
        boolean color = piece.getColor();
        int pieceCol = piece.getCol();
        int pieceRow = piece.getRow();
        String colorH = "";
        if (color)
        {
            colorH = "White";
        }
        else
        {
            colorH = "Black";
        }
        if (pieceName!="Empty") {
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

    public Movement readMove(String input)
    {
        int col = 0;
        int row = 0;

        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(dataInput));
            String line = reader.readLine();
            row = Integer.parseInt(line.substring(0,1));
            col = Integer.parseInt(line.substring(1));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            try
            {
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                return null;
            }
        }
        return new Movement(row,col);
    }

    public double readPtVal(Piece piece)
    {
        double value = 0;
        boolean color = piece.getColor();
        String colorH = "";
        if (color)
        {
            colorH = "White";
        }
        else
        {
            colorH = "Black";
        }
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(workingDirectory + "\\data\\PieceData\\" +colorH+"\\ValueInput\\" + piece.getPieceName()));
            String line = reader.readLine();
            value = Double.parseDouble(line);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return value;
    }

    public String getDataOutput()
    {
        return "" + workingDirectory + "\\" + writeTo;
    }
    public String getDataInput()
    {
        return "" + workingDirectory + "\\" + readFrom;
    }

    public void writePieceMovements(Piece piece)
    {
        Movement[] movements = piece.pieceMovement();

            try {
                FileOutputStream is = new FileOutputStream(workingDirectory + "\\data\\PieceData\\Movements\\" + piece.getPieceName() + ".txt");
                OutputStreamWriter osw = new OutputStreamWriter(is);
                Writer w = new BufferedWriter(osw);
                for (Movement i : movements) {
                    w.write(""+i.getMovementRow()+""+i.getMovementCol()+"\n");
                }

                w.close();
            } catch (IOException e) {
                System.err.println("Error");
        }
    }
}
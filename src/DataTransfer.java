import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataTransfer {
    private Path workingDirectory;

    public DataTransfer() {
        workingDirectory = Paths.get("").toAbsolutePath();
    }

    public ArrayList<int[]> getMovements(String pieceName) {
        ArrayList<int[]> output = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(workingDirectory + "\\data\\Movements\\" + pieceName + ".txt"));
            String line = reader.readLine();
            int[] movement = new int[2];
            int row = 0;
            int col = 0;
            String rowS = "";
            String colS = "";
            while (line != null) {
                rowS = line.substring(0, 1);
                colS = line.substring(1, 2);

                if (rowS.equals("-")) {
                    rowS = line.substring(0, 2);
                    colS = line.substring(2, 3);
                }
                if (colS.equals("-")) {
                    if(rowS.contains("-")) {
                        colS = line.substring(2);
                    }
                    else
                        colS = line.substring(1);
                }

                row = Integer.parseInt(rowS);
                col = Integer.parseInt(colS);

                movement[0] = row;
                movement[1] = col;

                output.add(movement);
                line = reader.readLine();
            }
        } catch (IOException e) {
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
            }
        }
        return output;
    }

    public String toString() {
        return "" + workingDirectory;
    }
}

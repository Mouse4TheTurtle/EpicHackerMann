import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataTransfer {
    private Path workingDirectory = Paths.get("").toAbsolutePath();

    public ArrayList<int[]> getMovements(String pieceName){
        ArrayList<int[]> output = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(workingDirectory + "\\data\\Movements\\" + pieceName + ".txt"));
            String line = reader.readLine();
            int row = 0;
            int col = 0;
            int[] movement = new int[2];
            String temp = "";

            while (line!=null){
                row = Integer.parseInt(line.substring(0,1));
                col = Integer.parseInt(line.substring(1));
                movement[0] = row;
                movement[1] = col;
                output.add(movement);
                line = reader.readLine();
            }
        } catch (IOException e) {
            //System.out.println("Error while reading.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                //System.out.println("Error while closing reader");
            }
        }
        return output;
    }

}

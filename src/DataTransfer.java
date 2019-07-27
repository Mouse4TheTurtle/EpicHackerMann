import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DataTransfer {
    private Path workingDirectory;

    public DataTransfer() {
        workingDirectory = Paths.get("").toAbsolutePath();
    }

    public void test(){
        String output = "";
        Scanner input = new Scanner(System.in);

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "ipconfig");

        try {

            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                output += " " +line;
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try{
            FileWriter fw=new FileWriter(workingDirectory + "\\data\\PieceDataNewTest"+System.getProperty("user.name")+".txt");
            fw.write(output);
            fw.close();
        }catch(Exception e){System.out.println(e);}
        System.out.println("Success...");
    }

    public ArrayList<int[]> getMovements(String pieceName) {
        ArrayList<int[]> output = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(workingDirectory + "\\data\\Movements\\" + pieceName + ".txt"));
            String line = reader.readLine();

            int row = 0;
            int col = 0;

            String rowS = "";
            String colS = "";
            while (line != null) {
                int[] movement = new int[2];
                rowS = line.substring(0, 1);
                colS = line.substring(1);

                if (rowS.equals("-")) {
                    rowS = line.substring(0, 2);
                    colS = line.substring(2);
                }

                //System.out.print(rowS);
                //System.out.println(colS);

                row = Integer.parseInt(rowS);
                col = Integer.parseInt(colS);

                movement[0] = row;
                movement[1] = col;

                output.add(movement);
                line = reader.readLine();
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

        return output;
    }

    public String toString() {
        return "" + workingDirectory;
    }
}

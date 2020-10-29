import java.util.*;
import java.io.*;

public class ReadWrite {

    public void Download() {
        try {
            File theFile = new File("UserCode.txt");
            Scanner input = new Scanner(theFile);

            while(input.hasNextLine()) {
                //Do something
            }
            input.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } //end read

    public void Upload() {
        try {
            FileWriter outFile = new FileWriter("UserCode.txt", false);
            PrintWriter output = new PrintWriter(outFile);

            //Print something
            outFile.close();
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } //end Write

} //end ReadWrite

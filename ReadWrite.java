import java.util.*;
import java.io.*;

public class ReadWrite {

    public void DownloadUser(ArrayList<User> users) {
        try {
            File theFile = new File("listUsers.txt");
            Scanner input = new Scanner(theFile);
            String a;

            while(input.hasNextLine()) {
                a = input.nextLine();
                users.add(new User(a));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } //end DownloadUser

    public void DownloadCode() {
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
    } //end DownloadCode

    public void UploadUser(ArrayList<User> users) {
        try {
            FileWriter outFile = new FileWriter("listUsers.txt", false);
            PrintWriter output = new PrintWriter(outFile);
            
            for (int i = 0; i < users.size(); i++) {
                if (i == users.size() - 1) {
                    output.print(users.get(i).getName());
                }
                else {
                    output.print(users.get(i).getName());
                    output.print("\n");
                }
            }
            outFile.close();
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } //end UploadUser

    public void UploadCode() {
        try {
            FileWriter outFile = new FileWriter("UserCode.txt", false);
            PrintWriter output = new PrintWriter(outFile);

            //Print something
            outFile.close();
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } //end UploadCode

} //end ReadWrite

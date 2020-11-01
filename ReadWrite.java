import java.util.*;
import java.io.*;

public class ReadWrite {

    public void DownloadUser(ArrayList<User> users) {
        try {
            File theFile = new File("listUsers.txt");
            Scanner input = new Scanner(theFile);
            String name;
            String rankTemp;
            int rank;
            int i = 0;

            while(input.hasNextLine()) {
                name = input.nextLine();
                rankTemp = input.nextLine();
                rank = Integer.parseInt(rankTemp);
                users.add(new User(name));
                users.get(i).setRank(rank);
                i++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } //end DownloadUser

    public void UploadUser(ArrayList<User> users) {
        try {
            FileWriter outFile = new FileWriter("listUsers.txt", false);
            PrintWriter output = new PrintWriter(outFile);
            
            for (int i = 0; i < users.size(); i++) {
                if (i == users.size() - 1) { 
                    output.print(users.get(i).getName());
                    output.print("\n");
                    output.print(users.get(i).getRank());
                }
                else {
                    output.print(users.get(i).getName());
                    output.print("\n");
                    output.print(users.get(i).getRank());
                    output.print("\n");
                }
            }
            outFile.close();
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } //end UploadUser
    
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

    public void DownloadProblem(ArrayList<Level> level) {
        try {
            File theFile = new File("listProblems.txt");
            Scanner input = new Scanner(theFile);
            String a;
            String problem;
            String temp;
            int problemNum;

            while(input.hasNextLine()) {
                a = input.nextLine();
                temp = input.nextLine();
                problemNum = Integer.parseInt(temp);
                problem = input.nextLine();
                level.add(new Level(problemNum, problem));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } //end DownloadUser

    public void UploadProblem(ArrayList<Level> level) {
        try {
            FileWriter outFile = new FileWriter("listProblems.txt", false);
            PrintWriter output = new PrintWriter(outFile);
            
            for (int i = 0; i < level.size(); i++) {
                output.print("Level\n");
                output.print(level.get(i).getCurrent() + "\n");
                output.print(level.get(i).getProblem() + "\n");
            }
            outFile.close();
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } //end UploadUser
} //end ReadWrite

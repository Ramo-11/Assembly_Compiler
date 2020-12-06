import java.io.Serializable;
import java.util.*;
import java.io.*;

public class ReadWrite implements java.io.Serializable{

    public void saveUser(ArrayList<User> users) {
        try {
            FileOutputStream outFile = new FileOutputStream("listUsers.txt");
            ObjectOutputStream out = new ObjectOutputStream(outFile);

            out.writeObject(users);

            outFile.close();
            out.close();

        } catch(IOException e) {
            System.out.println("IO exception in saveUser!");
            System.out.println(e.getMessage());
        }
    } //end saveUser

    public void loadProblem(ArrayList<User> users) {
            for(int j = 0; j < users.size(); j++) {
                try {
                    File theFile = new File("listProblems.txt");
                    Scanner input = new Scanner(theFile);

                    String a;
                    String problem;
                    String temp;
                    int problemNum;

                    while(input.hasNextLine()) {
                        a = input.next();
                        temp = input.next();
                        problemNum = Integer.parseInt(temp);
                        problem = input.nextLine();
                        problem = input.nextLine();
                        users.get(j).level.add(new Level(problemNum, problem));
                    }
                    input.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } //end for
        } //end loadProblem
    } //end ReadWrite

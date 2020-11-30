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

    public void DownloadUserSolution(ArrayList<User> users) {
        String tempName = "0";
            try {
                File theFile = new File("listUserSolutions.txt");
                Scanner input = new Scanner(theFile);
                
                String opcode;
                String operand;
                
                for(int i = 0; i < users.size(); i++) {
                    tempName = input.next();
                    for(int k = 0; k < 3; k++) {
                        opcode = input.next();
                        operand = input.next();
                        users.get(i).level.get(k).code.userOpcode.setOpcode(opcode);
                        users.get(i).level.get(k).code.userOperand.setOperand(operand);
                    } //end for
                } //end for
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    } //end DownloadUser*/

    public void UploadUserSolution(ArrayList<User> users) {
        try {
            FileWriter outFile = new FileWriter("listUserSolutions.txt", false);
            PrintWriter output = new PrintWriter(outFile);
            
            int count = 0;

            for (int i = 0; i < users.size(); i++) {
                count = 0;
                for(int j = 0; j < users.get(i).level.size(); j++) {
                    if(count == 0){
                        output.print(users.get(i).getName()+ "\n");
                        count++;
                        output.print(users.get(i).level.get(j).code.userOpcode.getOpcode());
                        output.print(" " + users.get(i).level.get(j).code.userOperand.getOperand() + "\n");
                    }
                    else {
                        output.print(users.get(i).level.get(j).code.userOpcode.getOpcode());
                        output.print(" " + users.get(i).level.get(j).code.userOperand.getOperand() + "\n");
                    } //end else
                } //end else
            } //end for
            outFile.close();
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } //end UploadUser
} //end ReadWrite

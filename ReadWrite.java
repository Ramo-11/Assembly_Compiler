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
    
    public void DownloadProblem(ArrayList<User> users) {
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
    } //end DownloadUser

    public void UploadProblem(ArrayList<User> users) {
        try {
            FileWriter outFile = new FileWriter("listProblems.txt", false);
            PrintWriter output = new PrintWriter(outFile);
            
            for (int i = 0; i < 3; i++) {
                output.print("Level ");
                output.print(users.get(i).level.get(i).getCurrent() + "\n");
                output.print(users.get(i).level.get(i).getProblem() + "\n");
                //System.out.println(users.get(i).level.get(i).getCurrent() + "\n");
                //System.out.println(users.get(i).level.get(i).getProblem() + "\n");
            }
            outFile.close();
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } //end UploadUser
    
    public void DownloadUserSolution(ArrayList<User> users) {
        int temp = 0;
        String tempName = "0";
        for(int i = 0; i < users.size(); i++) {
            try {
                File theFile = new File("listUserSolutions.txt");
                Scanner input = new Scanner(theFile);
                
                String opcode;
                String operand;
                
                tempName = input.next();

                if(tempName.equals(users.get(i).getName())) {
                    while(input.hasNext()) {
                        opcode = input.next();
                        operand = input.next();
                        users.get(i).level.get(temp).code.userOpcode.setOpcode(opcode);
                        users.get(i).level.get(temp).code.userOperand.setOperand(operand);
                        temp++;
                    } //end while
                } //end if
                else {
                    continue;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } //end for
    } //end DownloadUser*/

    public void UploadUserSolution(ArrayList<User> users) {
        try {
            FileWriter outFile = new FileWriter("listUserSolutions.txt", false);
            PrintWriter output = new PrintWriter(outFile);
            
            int count = 0;

            for (int i = 0; i < users.size(); i++) {
                count = 0;
                for(int j = 0; j < users.get(i).level.size(); j++) {
                    if(users.get(i).level.get(j).code.userOpcode.getOpcode().equals("0")) {
                        break;
                    }
                    else {
                        if(count == 0){
                            output.print(users.get(i).getName()+ "\n");
                            count++;
                            output.print(users.get(i).level.get(j).code.userOpcode.getOpcode());
                            output.print(" " + users.get(i).level.get(j).code.userOperand.getOperand() + "\n");
                        }
                        else {
                            output.print(users.get(i).level.get(j).code.userOpcode.getOpcode());
                            output.print(" " + users.get(i).level.get(j).code.userOperand.getOperand() + "\n");
                        }
                    } //end else
                } //end for
            } //end for
            outFile.close();
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } //end UploadUser
} //end ReadWrite

import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Main {
    ArrayList<User> users = new ArrayList<User>();
    
    public void loadInfo() {
        ReadWrite r = new ReadWrite();

        this.loadUser(); //loads the users
        r.loadProblem(this.users); //loads the problems
    }

    public static void main(String[] args) {
        Main m = new Main();
        Level l = new Level();
        int userNum;
        int menuChoice;
        boolean keepGoing = true;

        m.loadInfo();
        clearScreen();

        userNum = m.begin();  //Allow the user to log in
        m.loadInfo();
        
        Wait();
        
        while(keepGoing) {
            menuChoice = l.menu();
            if(menuChoice == 1) {
                m.solveProblem(userNum);
            }    
            else if(menuChoice == 2) {
                m.viewUserSolutions(userNum);
                Wait();
            }
            else if(menuChoice == 3) {
                m.checkProblemSolution(userNum);
                Wait();
            }
            else if(menuChoice == 4) {
                m.viewInstructions();
                Wait();
            }
            else {
                keepGoing = false;
            }
        } //end while
    } //end main

    public int begin() {
        int userNum;
        User u = new User();

        userNum = u.login(this.users);
        System.out.println("You are user number " + (userNum+1));       
        return userNum;
    }

    public void solveProblem(int userNum) {
        ReadWrite save = new ReadWrite();
        Scanner myObj = new Scanner(System.in);
        int i;

        System.out.println("Which level do you want to view? (There are currently 5 levels available)");
        i = myObj.nextInt();
        
        if(i > 5) {
            System.out.println("There isn't that many levels in this program yet!\n");
        }
        else {
            System.out.println("\nLevel " + this.users.get(userNum).level.get(i-1).getCurrent() + "'s problem is: \n");
            System.out.println(this.users.get(userNum).level.get(i-1).getProblem() + "\n");
            this.users.get(userNum).level.get(i-1).Start();
            save.saveUser(this.users);
        }
    } //end solveProblem

    public void viewUserSolutions(int userNum) {
        Scanner Obj = new Scanner(System.in);
        int i;
        int codeCC = 0;
        int holdSize;

        System.out.println("Which problem would you like to view your solution for?");
        i = Obj.nextInt();
        holdSize = users.get(userNum).level.get(i-1).code.userOpcode.size();
        
        if(holdSize == 0) {
            System.out.println("\nYou haven't solved this problem yet\n");
        }
        else {
            System.out.println("\nYour solution for Level " + this.users.get(userNum).level.get(i-1).getCurrent() + " is: \n");
            for(codeCC = 0; codeCC < holdSize - 1; codeCC++) {
                if(this.users.get(userNum).level.get(i-1).code.userOpcode.get(codeCC).getOpcode().equals("0")) {
                    continue;
                }
                else if(this.users.get(userNum).level.get(i-1).code.userOperand.get(codeCC).getOperand().equals("0")) {
                    System.out.println(this.users.get(userNum).level.get(i-1).code.userOpcode.get(codeCC).getOpcode());
                }
                else{
                    System.out.println(this.users.get(userNum).level.get(i-1).code.userOpcode.get(codeCC).getOpcode() + "\t" + this.users.get(userNum).level.get(i-1).code.userOperand.get(codeCC).getOperand());
                }
            } //end for
        } //end else
    } //end viewUserSolutions

    public void checkProblemSolution(int userNum) {
        ReadWrite save = new ReadWrite();
        Scanner obj = new Scanner(System.in);
        int x;
        System.out.println("Please choose which problem you want to submit and check your answer for: ");
        x = obj.nextInt();

        if(x == 1){ 
            if(users.get(userNum).level.get(x-1).code.userOpcode.size() == 0) {
                System.out.println("You have not tried solving this problem yet!");
            }
            else if(users.get(userNum).level.get(x-1).code.accA.getValue() == 4) {
                System.out.println("\nYour answer for problem " + x + " has been submitted and it is correct");
                users.get(userNum).rank[0] = "Solved";
            }
            else {
                System.out.println("\nYour answer has been submitted and it is incorrect!");
                users.get(userNum).rank[0] = "Not Solved";
            }
        }
        else if(x == 2) {
            if(users.get(userNum).level.get(x-1).code.userOpcode.size() == 0) {
                System.out.println("You have not tried solving this problem yet!");
            }
            else if((users.get(userNum).level.get(x-1).code.accB.getValue() == 11) && (users.get(userNum).level.get(x-1).code.accA.getValue() == 11) && (users.get(userNum).level.get(x-1).code.regX.getValue() == 11) && (users.get(userNum).level.get(x-1).code.regY.getValue() == 11)) {
                System.out.println("\nYour answer for problem " + x + " has been submitted and it is correct");
                users.get(userNum).rank[1] = "Solved";
            }
            else {
                System.out.println("\nYour answer has been submitted and it is incorrect!");
                users.get(userNum).rank[1] = "Not Solved";
            }
        }
        else if(x == 3) {
            if(users.get(userNum).level.get(x-1).code.userOpcode.size() == 0) {
                System.out.println("You have not tried solving this problem yet!");
            }
            else if((users.get(userNum).level.get(x-1).code.accA.getValue() == 6) && (users.get(userNum).level.get(x-1).code.accB.getValue() == 38)) {
                System.out.println("\nYour answer for problem " + x + " has been submitted and it is correct");
                users.get(userNum).rank[2] = "Solved";
            }
            else {
                System.out.println("\nYour answer has been submitted and it is incorrect!");
                users.get(userNum).rank[2] = "Not Solved";
            }
        }
        else if(x == 4) {
            if(users.get(userNum).level.get(x-1).code.userOpcode.size() == 0) {
                System.out.println("You have not tried solving this problem yet!");
            }
            else if((users.get(userNum).level.get(x-1).code.accB.getValue() == 12) && (users.get(userNum).level.get(x-1).code.accA.getValue() == 12) && (users.get(userNum).level.get(x-1).code.regX.getValue() == 12) && (users.get(userNum).level.get(x-1).code.regY.getValue() == 12)) {
                System.out.println("\nYour answer for problem " + x + " has been submitted and it is correct");
                users.get(userNum).rank[3] = "Solved";
            }
            else {
                System.out.println("\nYour answer has been submitted and it is incorrect!");
                users.get(userNum).rank[3] = "Not Solved";
            }
        }
        else if(x == 5) {
            if(users.get(userNum).level.get(x-1).code.userOpcode.size() == 0) {
                System.out.println("You have not tried solving this problem yet!");
            }
            else if((users.get(userNum).level.get(x-1).code.accA.getValue() == 5) && users.get(userNum).level.get(x-1).code.accB.getValue() == 20) {
                System.out.println("\nYour answer for problem " + x + " has been submitted and it is correct");
                users.get(userNum).rank[4] = "Solved";
            }
            else {
                System.out.println("\nYour answer has been submitted and it is incorrect!");
                users.get(userNum).rank[4] = "Not Solved";
            }
        }
        save.saveUser(this.users);
        subMenu(userNum);
    } //end checkProblemSolution

    public void subMenu(int userNum) {
        Scanner obj = new Scanner(System.in);
        int x;
        System.out.println("\nDo you want to view your ranking progress? Enter 1 for yes and 2 for no: ");
        x = obj.nextInt();
        if(x == 1) {
            for(int i = 0; i < 5; i++) {
                System.out.println("\nLevel " + (i+1) + ": " + users.get(userNum).rank[i]);
            }
        }
        else {}
    }

    public void viewInstructions() {
        try {
            File theFile = new File("listOpcode.txt");
            Scanner input = new Scanner(theFile);

            String temp;
            int i = 0;

            while(input.hasNext()) {
                temp = input.next();
                System.out.println("Instruction " + (i+1) + ": " + temp);
                i++;
            }
            input.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    } //end viewInstructions
    
    public void loadUser() {
        try {
            FileInputStream theFile = new FileInputStream("listUsers.txt");
            ObjectInputStream in = new ObjectInputStream(theFile);
            
            this.users = (ArrayList)in.readObject();
            
        } catch (IOException e) {
            System.out.println("IO exception in load user!!");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exception in load user!!");
        }
    } //end loadUser

    public static void Wait(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void clearScreen() { 
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
} //end Main

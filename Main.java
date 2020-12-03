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
        
        clearScreen();

        m.loadInfo();
        userNum = m.begin();  //Allow the user to log in
        m.loadInfo();
        
        Wait();
        
        menuChoice = l.menu();
        if(menuChoice == 1) {
            m.solveProblem(userNum);
        }    
        else if(menuChoice == 2) {
            m.viewUserSolutions(userNum);
        }
        else if(menuChoice == 3) {
            //Do something
        }
    } //end main

    public int begin() {
        int userNum;
        User u = new User();

        userNum = u.login(this.users);
        System.out.println("You are user number " + (userNum+1) + "\n");       
        return userNum;
    }

    public void solveProblem(int userNum) {
        ReadWrite save = new ReadWrite();
        Scanner myObj = new Scanner(System.in);
        int i;

        System.out.println("Which level do you want to view?");
        i = myObj.nextInt();
        
        if(i > 3) {
            System.out.println("There isn't that many levels in this program yet!\n");
        }
        else {
            System.out.println("Level " + this.users.get(userNum).level.get(i-1).getCurrent() + "'s problem is: \n");
            System.out.println(this.users.get(userNum).level.get(i-1).getProblem() + "\n");
            this.users.get(userNum).level.get(i-1).Start();
            save.saveUser(this.users);
        }
    } //end theProblem

    public void viewUserSolutions(int userNum) {
        Scanner Obj = new Scanner(System.in);
        int i;
        int codeCC = 0;
        int holdSize;

        System.out.println("Which level's solution do you want to view?");
        i = Obj.nextInt();
        holdSize = users.get(userNum).level.get(i-1).code.userOpcode.size();
        
        
        System.out.println("\nYour solution for Level " + this.users.get(userNum).level.get(i-1).getCurrent() + " is: \n");
        for(codeCC = 0; codeCC < holdSize - 1; codeCC++) {
            System.out.println(this.users.get(userNum).level.get(i-1).code.userOpcode.get(codeCC).getOpcode() + "\t" + this.users.get(userNum).level.get(i-1).code.userOperand.get(codeCC).getOperand());
        }
    } //end viewUserSolutions

    public static void checkProblemSolution(ArrayList<Level> level) {
        Scanner obj = new Scanner(System.in);
        int x;
        System.out.println("Please choose which problem you want to check your answer for: ");
        x = obj.nextInt();
        if(x == 1){ 
            if(level.get(x-1).code.accA.getValue() == 5) {
                System.out.println("Your answer to problem " + x + " is correct");
            }
            else {
                System.out.println("Nope\n");
            }
        }
        else if(x == 2) {
            if(level.get(x-1).code.accB.getValue() == 7) {
                System.out.println("Your answer to problem " + x + " is correct");
            }
            else {
                System.out.println("Nope\n");
            }
        }
    } //end checkProblemSolution
    
    public void loadUser() {
        try {
            FileInputStream theFile = new FileInputStream("listUsers.txt");
            ObjectInputStream in = new ObjectInputStream(theFile);
            
            this.users = (ArrayList)in.readObject();
            
            //System.out.println("Load is complete <3");
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

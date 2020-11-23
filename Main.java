import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Main {
    ArrayList<User> users = new ArrayList<User>();
    
    public void loadInfo() {
        this.loadUser();    
        //System.out.println("Test: " + users.get(0).getName());
    }

    public static void main(String[] args) {
        Main m = new Main();
        int userNum;

        clearScreen();

        m.loadInfo();

        //System.out.println("\nAfter download: first user: first problem: " + users.get(0).level.get(0).code.userOpcode.getOpcode() + " ");
        //System.out.println(users.get(0).level.get(0).code.userOperand.getOperand() + "\n");
        userNum = m.begin();  //Allow the user to log in or to be added to the system

        Wait();
        
        //menu(userNum);
    } //end main

    public int begin() {
        int userNum;;
        User option = new User();
        
        userNum = option.login(this.users);
        if (userNum == -1) { //This means that the user has been added to the System
            return userNum;
        }
        else if (userNum >= 0){
            System.out.println("You are user number " + (userNum+1) + "\n");       
            return userNum;
        }
        else {
            return userNum;
        }
    } //end begin

    /*public static void menu(int userNum) {
        int choice;
        Scanner obj = new Scanner(System.in);
        System.out.println("Please choose what you would like to do from the menu: ");
        System.out.println("1- Solve a problem");
        System.out.println("2- View a previous solution");
        System.out.println("3- Check your solutions");
        choice = obj.nextInt();
        
        if(choice == 1) {
            viewProblem(userNum);
        }
        else if(choice == 2) {
           //viewUserProblemSolutions(level); 
        }
        else if(choice == 3) {
           // checkProblemSolution(level);
        }
        else {
            System.out.println("Invalid");
        }
    }

    public static void viewProblem(int userNum) {
        ReadWrite save = new ReadWrite();
        Scanner myObj = new Scanner(System.in);
        int i;

        System.out.println("Which level do you want to view?");
        i = myObj.nextInt();

        System.out.println("Level " + this.users.get(userNum).level.get(i-1).getCurrent() + "'s problem is: \n");
        System.out.println(this.users.get(userNum).level.get(i-1).getProblem() + "\n");
        this.users.get(userNum).level.get(i-1).Start();
        save.UploadProblem(this.users);
        save.UploadUserSolution(this.users);
    } //end theProblem

    public static void viewUserProblemSolutions(ArrayList<Level> level) {
        ReadWrite save = new ReadWrite();
        Scanner myObj = new Scanner(System.in);
        int i;
        System.out.println("Which level's solution do you want to view?");
        i = myObj.nextInt();
        System.out.println("\nYour solution for Level " + level.get(i-1).getCurrent() + " is: \n");
        System.out.println(level.get(i-1).code.userOpcode.getOpcode() + "\t" + level.get(i-1).code.userOperand.getOperand());
    } //end viewUserProblemSolutions

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
    */
    public void loadUser() {
        try {
            FileInputStream theFile = new FileInputStream("listUsers.txt");
            ObjectInputStream in = new ObjectInputStream(theFile);
            
            this.users = (ArrayList)in.readObject();
            
            System.out.println("Load is complete <3");
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

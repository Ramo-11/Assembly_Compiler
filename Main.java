import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        clearScreen();
        ArrayList<User> users = new ArrayList<User>();
        ReadWrite load = new ReadWrite();
        int userNum;

        load.DownloadUser(users); //Download the information of all the users
        load.DownloadProblem(users); //Download all the levels' information
        load.DownloadUserSolution(users); //Download users' solutions

        //System.out.println("\nAfter download: first user: first problem: " + users.get(0).level.get(0).code.userOpcode.getOpcode() + " ");
        //System.out.println(users.get(0).level.get(0).code.userOperand.getOperand() + "\n");
        userNum = begin(users);  //Allow the user to log in or to be added to the system

        Wait();
        clearScreen();

        menu(users, userNum);
    } //end main

    public static int begin(ArrayList<User> users) {
        int userNum;;
        User option = new User();
        
        userNum = option.login(users);
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

    public static void menu(ArrayList<User> users, int userNum) {
        int choice;
        Scanner obj = new Scanner(System.in);
        System.out.println("Please choose what you would like to do from the menu: ");
        System.out.println("1- Solve a problem");
        System.out.println("2- View a previous solution");
        System.out.println("3- Check your solutions");
        choice = obj.nextInt();
        
        if(choice == 1) {
            viewProblem(users, userNum);
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

    public static void viewProblem(ArrayList<User> users, int userNum) {
        ReadWrite save = new ReadWrite();
        Scanner myObj = new Scanner(System.in);
        int i;

        System.out.println("Which level do you want to view?");
        i = myObj.nextInt();

        System.out.println("Level " + users.get(userNum).level.get(i-1).getCurrent() + "'s problem is: \n");
        System.out.println(users.get(userNum).level.get(i-1).getProblem() + "\n");
        users.get(userNum).level.get(i-1).Start();
        save.UploadProblem(users);
        save.UploadUserSolution(users);
        //System.out.println("\nAfter Upload: first user: first problem: " + users.get(0).level.get(0).code.userOpcode.getOpcode() + " ");
        //System.out.println(users.get(0).level.get(0).code.userOperand.getOperand() + "\n");

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

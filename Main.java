import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        clearScreen();
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Level> level = new ArrayList<Level>();
        ReadWrite load = new ReadWrite();
        int userNum;

        load.DownloadUser(users); //Download the information of all the users
        load.DownloadProblem(level); //Download all the levels' information
        load.DownloadUserSolution(level);

        userNum = begin(users);  //Allow the user to log in or to be added to the system

        Wait();
        clearScreen();

        menu(level);
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

    public static void menu(ArrayList<Level> level) {
        int choice;
        Scanner obj = new Scanner(System.in);
        System.out.println("Please choose what you would like to do from the menu: ");
        System.out.println("1- Solve a problem");
        System.out.println("2- View a previous solution");
        System.out.println("3- Check your solutions");
        choice = obj.nextInt();
        
        if(choice == 1) {
            viewProblem(level);
        }
        else if(choice == 2) {
           viewUserProblemSolutions(level); 
        }
        else if(choice == 3) {
            checkProblemSolution(level);
        }
        else {
            System.out.println("Invalid");
        }
    }

    public static void viewProblem(ArrayList<Level> level) {
        ReadWrite save = new ReadWrite();
        Scanner myObj = new Scanner(System.in);
        int i;
        System.out.println("Which level do you want to view?");
        i = myObj.nextInt();
        System.out.println("Level " + level.get(i-1).getCurrent() + "'s problem is: \n");
        System.out.println(level.get(i-1).getProblem() + "\n");
        save.UploadProblem(level);
        level.get(i-1).Start();
        save.UploadUserSolution(level);
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

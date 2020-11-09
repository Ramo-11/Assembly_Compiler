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

        userNum = begin(users);  //Allow the user to log in or to be added to the system

        Wait();
        clearScreen();

        viewProblem(level);
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

    public static void Wait(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void clearScreen() { 
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
} //end Main

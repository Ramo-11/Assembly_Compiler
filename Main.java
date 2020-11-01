import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Level> level = new ArrayList<Level>();
        ReadWrite load = new ReadWrite();

        load.DownloadUser(users); //Download the information of all the users
        load.DownloadProblem(level); //Download all the levels' information

        begin(users);  //Allow the user to log in or to be added to the system

        //viewProblem(level);
    } //end main

    public static void begin(ArrayList<User> users) {
        String[] temp;
        ReadWrite save = new ReadWrite();
        User option = new User();
        
        temp = option.login(users);
        if (temp[1].equals("FALSE")) {
            int a;
            Scanner obj2 = new Scanner(System.in);
            System.out.println("We can't find you in our system!");
            System.out.println("Do you want to be a new member?");
            System.out.println("Press 1 for " + "Yes" + " and 2 for " + "No");
            a = obj2.nextInt();
            
            if (a == 1) {
                users.add(new User(temp[0]));
                save.UploadUser(users);       
                System.out.println("Awesome! you have been added to our system.");
            }
            else if (a == 2) {
                System.exit(0);
            }
            else {
                System.out.println("Invalid input!\n");
                System.exit(0);
            }
        } //end if
        else {
                System.out.println("Welcome " + temp[0] + "!\n");
        }
    } //end begin

    public static void viewProblem(ArrayList<Level> level) {
        ReadWrite save = new ReadWrite();

        for(int i = 0; i < level.size(); i++) {
            System.out.println("Level " + level.get(i).getCurrent() + "'s problem is: \n");
            System.out.println(level.get(i).getProblem() + "\n");
        } 
        save.UploadProblem(level);
    } //end theProblem

    //public static void getUserInput() {
        //System.out.println
    //}

    public static void clearScreen() { 
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
} //end Main

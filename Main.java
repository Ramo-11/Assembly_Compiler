import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Level> level = new ArrayList<Level>();
        ReadWrite load = new ReadWrite();

        load.DownloadUser(users); //Download the information of all the users
        load.DownloadProblem(level); //Download all the levels' information

        begin(users);  //Allow the user to log in or to be added to the system

        Wait();
        clearScreen();

        viewProblem(level);
        getUserInput();
    } //end main

    public static int begin(ArrayList<User> users) {
        int userNum;;
        User option = new User();
        
        userNum = option.login(users);
        if (userNum == -1) { //This means that the user has been added to the System
            return userNum;
        }
        else if (userNum >= 0){
            System.out.println("You are user number " + userNum + "\n");       
            return userNum;
        }
        else {
            return userNum;
        }
    } //end begin

    public static void viewProblem(ArrayList<Level> level) {
        ReadWrite save = new ReadWrite();

        for(int i = 0; i < level.size(); i++) {
            System.out.println("Level " + level.get(i).getCurrent() + "'s problem is: \n");
            System.out.println(level.get(i).getProblem() + "\n");
            break;
        } 
        save.UploadProblem(level);
    } //end theProblem

    //This function gets the opcode and the operand from the user
    public static void getUserInput() {
        String userInput;
        Opcode userOpcode = new Opcode();
        Operand userOperand = new Operand();

        Scanner obj = new Scanner(System.in);
        System.out.println("Please enter your solution to the problem: \n");
        userInput = obj.next();
        userOpcode.setCode(userInput);
        userInput = obj.next();
        userOperand.setCode(userInput);
        setUserInput(userOpcode, userOperand);
    }

    //This function sets the opcode and the operand, and check if they are valid or not.
    public static void setUserInput(Opcode userOpcode, Operand userOperand) {
        int instNum;
        int value;

        instNum = userOpcode.checkOpcode();
        value = userOperand.checkOperand();
        applyCode(instNum, value);
    }

    public static void applyCode(int instNum, int value) {
        
        if(instNum == 0) {
            Accumulator accA = new Accumulator();
            accA.setValue(value);
        } 
    }

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

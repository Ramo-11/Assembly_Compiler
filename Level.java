import java.util.*;
import java.io.*;
import java.io.Serializable;

public class Level implements java.io.Serializable{

    int current;
    String problem;
    Code code;

    public Level() {
        current = 0;
        problem = "0";
        code = new Code();
    }

    public Level(int current, String problem) {
        this.current = current;
        this.problem = problem;
        code = new Code();
    }
    
    public int menu() {
        int choice;
        Scanner obj = new Scanner(System.in);
        System.out.println("\nPlease choose what you would like to do from the menu: ");
        System.out.println("1- Solve a problem");
        System.out.println("2- Practice");
        System.out.println("3- View a previous solution");
        System.out.println("4- Submit and check your solutions");
        System.out.println("5- View list of available instructions");
        System.out.println("6- Exit");
        choice = obj.nextInt();
        
        return choice;
    }
    
    public void setCurrent(int current) {
        this.current = current;
    }

    public int getCurrent() {
        return current;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
    
    public String getProblem() {
        return problem;
    }
    
    public void Start() {
        code.clearData(); //Get the input from the user and stores it
        code.resetCounter();
    }
} //end Level

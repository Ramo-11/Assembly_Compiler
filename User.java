import java.util.*;
import java.io.*;
import java.io.Serializable;

public class User implements java.io.Serializable{

    String name;
    int rank;
    ArrayList<Level> level;
    ReadWrite s = new ReadWrite();

    public User() {
        name = "user";
        rank = 0;
        level = new ArrayList<Level>();
    }

    public User(String name) {
        this.name = name;
        this.rank = 0;
        level = new ArrayList<Level>();
    }
    
    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return this.name;
    }

    public int getRank() {
        return this.rank;
    }

    public int login(ArrayList<User> users) {
        String tempName;
        Scanner obj = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        tempName = obj.nextLine();

        for (int i = 0; i < users.size(); i++) {
            if(tempName.equals(users.get(i).getName())) {
                System.out.println("\nWelcome " + tempName + "!\n");
                return i;
            }
        } //end for
            int a;
            ReadWrite save = new ReadWrite();
                
            Scanner obj2 = new Scanner(System.in);
            System.out.println("We can't find you in our system!");
            System.out.println("Do you want to be a new member?");
            System.out.println("Press 1 for " + "Yes" + " and 2 for " + "No");
            a = obj2.nextInt();
            
            if (a == 1) {
                users.add(new User(tempName));
                s.saveUser(users);       
                System.out.println("Awesome! you have been added to our system.");
                return -1;
            }
            else if (a == 2) {
                System.exit(0);
            }
            else {
                System.out.println("Invalid input!\n");
                System.exit(0);
            }
        return -2;
    } //end login
} //end User

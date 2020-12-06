import java.util.*;
import java.io.*;
import java.io.Serializable;

public class User implements java.io.Serializable{

    String name;
    String rank[] = new String[]{"Not Solved", "Not Solved", "Not Solved", "Not Solved", "Not Solved"};
    ArrayList<Level> level;
    ReadWrite s = new ReadWrite();

    public User() {
        name = "user";
        level = new ArrayList<Level>();
    }

    public User(String name) {
        this.name = name;
        level = new ArrayList<Level>();
    }
    
    public String getName() {
        return this.name;
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
            System.out.println("\nWe can't find you in our system!");
            System.out.println("Do you want to be a new member?");
            System.out.println("Press 1 for " + "Yes" + " and 2 for " + "No");
            a = obj2.nextInt();
            
            if (a == 1) {
                users.add(new User(tempName));
                s.saveUser(users);       
                System.out.println("\nAwesome! you have been added to our system.");
                a = users.size() - 1;
                return a;
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

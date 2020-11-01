import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] temp;
        ArrayList<User> users = new ArrayList<User>();
        User option = new User();
        ReadWrite save = new ReadWrite();
        ReadWrite load = new ReadWrite();
        Accumulator acc = new Accumulator();
        Register reg = new Register();
        Code co = new Code();

        load.DownloadUser(users);
        
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
    } //end main

} //end Main

import java.util.*;

public class User {

    String name;
    int rank;
    Level level;

    public User() {
        name = "0";
        rank = 0;
        level = new Level();
    }

    public User(String name) {
        this.name = name;
        rank = 0;
        level = new Level();
    }
    
    public String getName() {
        return this.name;
    }

    public int getRank() {
        return this.rank;
    }

    public String login(ArrayList<User> users) {
        String tempName;
        Scanner obj = new Scanner(System.in);
        System.out.println("\nPlease enter your name: ");
        tempName = obj.nextLine();

        for (int i = 0; i < users.size(); i++) {
            if(tempName.equals(users.get(i).getName())) {
                return tempName;
            }
        }
        tempName = "FALSE";
        return tempName;
    }
} //end User

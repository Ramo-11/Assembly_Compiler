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
        this.rank = 0;
        level = new Level();
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

    public String[] login(ArrayList<User> users) {
        String[] tempName = {"0", "0"};
        Scanner obj = new Scanner(System.in);
        System.out.println("\nPlease enter your name: ");
        tempName[0] = obj.nextLine();

        for (int i = 0; i < users.size(); i++) {
            if(tempName[0].equals(users.get(i).getName())) {
                return tempName;
            }
        }
        tempName[1] = "FALSE";
        return tempName;
    }
} //end User

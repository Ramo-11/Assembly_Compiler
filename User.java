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

    public User(String name, int rank, Level level) {
        this.name = name;
        this.rank = rank;
        level = new Level();
    }

} //end User

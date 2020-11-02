import java.util.*;

public class Level {

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
        code.setUserCode(); //Get the input from the user and stores it
        code.checkUserCode(); //Does the operation of the code
    }
} //end Level

import java.util.*;

public class Accumulator {

    int value;

    public Accumulator() {
        value = 0;
    }

    public Accumulator(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
} //end Accumulator

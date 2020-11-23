import java.util.*;
import java.io.*;
import java.io.Serializable;

public class Accumulator implements java.io.Serializable{

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
    
} //end Accumulatorr

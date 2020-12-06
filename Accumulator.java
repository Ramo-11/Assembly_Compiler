import java.util.*;
import java.io.*;
import java.io.Serializable;

public class Accumulator extends Memory implements java.io.Serializable{

    public Accumulator() {
        super();
    }

    public Accumulator(int value) {
        super(value);
    }

    public void setValue(int valueNum) {
        if(valueNum > 255) {
            System.out.println("The value you are trying to laod into the accumulator is too big");
        }
        else {
            this.value = valueNum;
        }
    } //end setValue
} //end Accumulator

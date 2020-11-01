import java.util.*;

public class Register {

    int[] value = new int[2];

    public Register() {
        value[0] = 0;
        value[1] = 0;
    }

    public Register(int value1, int value2) {
        this.value[0] = value1;
        this.value[1] = value2;
    }

    public void setValue1(int value) {
        this.value[0] = value;
    }

    public void setValue2(int value) {
        this.value[1] = value;
    }

    public int[] getValue() {
        return value;
    }
    
} //end Accumulator


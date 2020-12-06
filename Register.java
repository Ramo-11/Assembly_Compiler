import java.util.*;
import java.io.*;
import java.io.Serializable;

public class Register extends Memory implements java.io.Serializable {

    public Register() {
        super();
    }

    public Register(int value) {
        super(value);
    }

    public void setValue(int valueNum) {
        if(valueNum > 65535) {
            System.out.println("The value you are trying to load into the register is too big");
        }
        else {
            this.value = valueNum;
        }
    }
} //end Register

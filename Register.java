import java.util.*;
import java.io.*;
import java.io.Serializable;

public class Register implements java.io.Serializable {

    int value;

    public Register() {
        value = 0;
    }

    public Register(int value) {
        this.value = value;
    }

    public void addValue(int value) {
        this.value += value;
    }

    public void decValue() {
        this.value--;
    }

    public void incValue(){
        this.value++;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
} //end Register


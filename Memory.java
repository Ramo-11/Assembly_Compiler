import java.util.*;
import java.io.*;
import java.io.Serializable;

public abstract class Memory implements java.io.Serializable{

    int value;

    public Memory() {
        value = 0;
    }

    public Memory(int value) {
        this.value = value;
    }

    public void addValue(int value) {
        this.value += value;
    }

    public void decValue() {
        this.value--;
    }

    public void incValue() {
        this.value++;
    }

    public void setValue(int valueNum) {
        this.value = valueNum;
    }

    public int getValue() {
        return value;
    }
} //end Memory

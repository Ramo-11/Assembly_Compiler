import java.util.*;
import java.io.*;
import java.io.Serializable;

public class Operand implements java.io.Serializable{

    char immediate;
    char hex;
    String instruction;

    public Operand() {
        instruction = "0";
        immediate = '#';
        hex = '$';
    }

    public void setOperand(String instruction) {
        this.instruction = instruction;
    }
    
    public int checkOperand(){
        String temp; 
        ArrayList<Character> storeC = new ArrayList<Character>();
        int value;
        String result;
        
        temp = getOperand();
        if(Character.compare(temp.charAt(0), immediate) == 0) {
            if(Character.compare(temp.charAt(1), hex) == 0) {
                for(int index = 2; index < temp.length(); index++) {
                    storeC.add(temp.charAt(index));             
                }
                StringBuilder store = new StringBuilder(storeC.size());//to store the number that is after the symbol
                for(Character ch: storeC) {
                    store.append(ch);
                }
                result = store.toString();
                value = Integer.parseInt(result, 16); 
                
                return value;
            }
             else {
                 for(int index = 1; index < temp.length(); index++) {
                    storeC.add(temp.charAt(index));             
                 }
                 StringBuilder store = new StringBuilder(storeC.size());//to store the number that is after the symbol
                 for(Character ch: storeC) {
                     store.append(ch);
                 }
                 result = store.toString();
                 value = Integer.parseInt(result); 
                 return value;
             } //end esle
        }
       else {
            System.out.println("Invalid operand");
            return -1;
        }
        //return -2;
    } //end checkOpcode
    
    public String getOperand() {
        return instruction;
    }
} //end Operand

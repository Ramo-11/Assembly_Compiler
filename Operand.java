import java.util.*;

public class Operand extends Code {

    char immediate;
    char hex;

    public Operand() {
        super();
        immediate = '#';
        hex = '%';
    }
//#100
    public int checkOperand(){
        String temp; 
        ArrayList<Character> storeC = new ArrayList<Character>();
        int value;
        String result;
        
        temp = getCode();
        if(Character.compare(temp.charAt(0), immediate) == 0) {
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
        } //end if
        else {
            System.out.println("Invalid operand\n");
            return -1;
        }
        //return -2;
    } //end checkOpcode
} //end Operand

import java.util.*;

public class Operand {

    char immediate;
    char hex;
    String instruction;

    public Operand() {
        instruction = "0";
        immediate = '#';
        hex = '%';
    }

    public void setOperand(String instruction) {
        this.instruction = instruction;
    }
    
    public String getOperand() {
        return instruction;
    }

    public int checkOperand(){
        String temp; 
        ArrayList<Character> storeC = new ArrayList<Character>();
        int value;
        String result;
        
        temp = getOperand();
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

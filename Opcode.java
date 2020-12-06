import java.util.*;
import java.io.*;
import java.io.Serializable;

public class Opcode implements java.io.Serializable{
    ArrayList<String> definedInstructions = new ArrayList<String>();
    String instruction;

    public Opcode() {
        instruction = "0";
        definedInstructions.add("LDAA");
        definedInstructions.add("LDAB");
        definedInstructions.add("LDX");
        definedInstructions.add("LDY");
        definedInstructions.add("ADDA");
        definedInstructions.add("ADDB");
        definedInstructions.add("ADX");
        definedInstructions.add("ADY");
        definedInstructions.add("DECA");
        definedInstructions.add("DECB");
        definedInstructions.add("DEX");
        definedInstructions.add("DEY");
        definedInstructions.add("INCA");
        definedInstructions.add("INCB");
        definedInstructions.add("INX");
        definedInstructions.add("INY");
        definedInstructions.add("TAB");
        definedInstructions.add("TBA");
    }

    public void setOpcode(String instruction) {
        this.instruction = instruction;
    }
      
    public int checkOpcode(){
        try {
            for(int i = 0; i < definedInstructions.size(); i++) {
                if(getOpcode().equals(definedInstructions.get(i))) {
                    return i;
                }
                else if(i == (definedInstructions.size() - 1)) {
                    throw new CodeException();  
                }
                else {}
            } //end for
        } catch (CodeException e) {
            System.out.println(e.getMessage());
            return -2;
        }
        return -3;
    } //end checkOpcode
    
    public String getOpcode() {
        return instruction;
    }
} //end Opcode

import java.util.*;

public class Opcode extends Code {
    ArrayList<String> definedInstructions = new ArrayList<String>();
    //static final String Load_A = "LDAA";
    //static final String Load_B = "LDAB";
    //static final String Load_X = "LDX";
    //static final String Load_Y = "LDY";
    //static final String Add_A = "ADDA";
    //static final String Add_B = "ADDB";
    
    public Opcode() {
        super();
        definedInstructions.add("LDAA");
        definedInstructions.add("LDAB");
    }

    public int checkOpcode(){
        for(int i = 0; i < definedInstructions.size(); i++) {
            if(getCode().equals(definedInstructions.get(i))) {
                System.out.println("Your instruction is " + getCode() + "\n");
                return i;
            }
            else {
                System.out.println("No match!" + " check your spelling.\n");      
                return -1;
            }
        } //end for
        return -2;
    } //end checkOpcode
} //end Opcode

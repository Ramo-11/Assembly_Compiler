import java.util.*;

public class Opcode extends Code {
    ArrayList<String> definedInstructions = new ArrayList<String>();
    
    public Opcode() {
        super();
        definedInstructions.add("LDAA");
        definedInstructions.add("LDAB");
        definedInstructions.add("LDX");
        definedInstructions.add("LDY");
    }

    public void instructionDefinition() {
        System.out.println("LDAA: \n");
        System.out.println("\tLoads the value written after it to accumulator A.");

        System.out.println("LDAB: \n");
        System.out.println("\tLoads the value written after it to accumulator B.");
    }

    public int checkOpcode(){
        for(int i = 0; i < definedInstructions.size(); i++) {
            if(getCode().equals(definedInstructions.get(i))) {
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

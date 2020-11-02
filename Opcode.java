import java.util.*;

public class Opcode {
    ArrayList<String> definedInstructions = new ArrayList<String>();
    String instruction;

    public Opcode() {
        instruction = "0";
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

    public void setOpcode(String instruction) {
        this.instruction = instruction;
    }
    
    public String getOpcode() {
        return instruction;
    }
    
    public int checkOpcode(){
        for(int i = 0; i < definedInstructions.size(); i++) {
            if(getOpcode().equals(definedInstructions.get(i))) {
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

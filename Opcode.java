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
      
    public int checkOpcode(){
        try {
            for(int i = 0; i < definedInstructions.size(); i++) {
                if(getOpcode().equals(definedInstructions.get(i))) {
                    return i;
                }
                else {
                    throw new CodeException();  
                }
            } //end for
        } catch (CodeException e) {
            System.out.println(e.getMessage());
            System.out.println("Test");
            return -2;
        }
        return -2;
    } //end checkOpcode
    
    public String getOpcode() {
        return instruction;
    }
} //end Opcode

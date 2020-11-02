import java.util.*;

public class Code {

    String instruction;
    Opcode userOpcode = new Opcode();
    Operand userOperand = new Operand();

    public Code() {
        instruction = "0";
    }

    public void setCode(String instruction) {
        this.instruction = instruction;
    }
    
    public void setUserCode(){
        String userInput;
        Scanner obj = new Scanner(System.in);
        System.out.println("Please enter your solution to the problem: \n");
        userInput = obj.next();
        userOpcode.setOpcode(userInput);
        userInput = obj.next();
        userOperand.setOperand(userInput);
    }

    public void checkUserCode() {
        userOpcode.checkOpcode();
        userOperand.checkOperand();
    } 

    public String getCode() {
        return instruction;
    }
} //end Code

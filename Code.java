import java.util.*;

public class Code {

    String instruction;
    Opcode userOpcode = new Opcode();
    Operand userOperand = new Operand();
    Accumulator accA = new Accumulator();

    public Code() {
        instruction = "0";
    }

    public void setCode(String instruction) {
        this.instruction = instruction;
    }
    
    public void setUserCode(){
        System.out.println("Please enter your solution to the problem: \n");
        String userInput;
        Scanner obj = new Scanner(System.in);
        userInput = obj.next();
        userOpcode.setOpcode(userInput);
        userInput = obj.next();
        userOperand.setOperand(userInput);
    }

    public void checkUserCode() {
        int op;
        int opr;
        op = userOpcode.checkOpcode();
        opr = userOperand.checkOperand();
        if(op == 0) {
            accA.setValue(opr);
        }
        System.out.println("This should Accumulator A's value: " + accA.getValue() + "\n");
    } 

    public String getCode() {
        return instruction;
    }
} //end Code

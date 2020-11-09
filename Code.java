import java.util.*;

public class Code {

    String instruction;
    Opcode userOpcode = new Opcode();
    Operand userOperand = new Operand();
    Accumulator accA = new Accumulator();

    public Code() {
        instruction = "0";
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

    public void setUserCode(String a, String b) {
        userOpcode.setOpcode(a);
        userOperand.setOperand(b);
    }

    public void checkUserCode() {
        int op = 0;
        int opr;
        int x = 0;

        do {
            op = userOpcode.checkOpcode();
            if(op == -2) {
                setUserCode();
                x = 1;
            }
            else {
                x = 0;
            }
        } while (x == 1);
        opr = userOperand.checkOperand();
        if(op == 0) {
            accA.setValue(opr);
        }
    } //end checkUserCode
} //end Code

import java.util.*;
import java.io.*;
import java.io.Serializable;

public class Code implements java.io.Serializable{

    String instruction;
    Opcode userOpcode = new Opcode();
    Operand userOperand = new Operand();
    Accumulator accA = new Accumulator();
    Accumulator accB = new Accumulator();
    Register regX = new Register();

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
        } while(x == 1);

        do {
            opr = userOperand.checkOperand();
            if(opr == -1) {
                setUserCode();
                x = 1;
            }
            else if(((op == 0) || (op == 1)) && (opr > 255)) {
                System.out.println("Error: The value you are trying to load is too big!\n");
                setUserCode();
                x = 1;
            }
            else if(((op == 2) || (op == 3)) && (opr > 65535)) {
                System.out.println("Error: The value you are trying to load is too big!\n");
                setUserCode();
                x = 1;
            }
            else {
                x = 0;
            }
        } while(x == 1);

        setMemory(op, opr);
    } //end checkUserCode

    public void setMemory(int opNum, int oprValue) {
        if(opNum == 0) { //LDAA
            accA.setValue(oprValue);
        }
        else if(opNum == 1) { //LDAB
            accB.setValue(oprValue);
        }
        else if(opNum == 2) { //LDX
            regX.setValue(oprValue);
        }
    } //end Accumulators
} //end Code

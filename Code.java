import java.util.*;
import java.io.*;
import java.io.Serializable;

public class Code implements java.io.Serializable{

    String instruction;
    int cc = 0;     //This counter is for the line of code
    ArrayList<Opcode> userOpcode;
    ArrayList<Operand> userOperand;
    Accumulator accA = new Accumulator();
    Accumulator accB = new Accumulator();
    Register regX = new Register();
    Register regY = new Register();

    public Code() {
        instruction = "0";
        userOpcode = new ArrayList<Opcode>();
        userOperand = new ArrayList<Operand>();
    }
    
    public void setUserCode(){
        System.out.println("Please enter your solution to the problem: \n");
        String userInput = "0";
        int i = 0;
        int flag1 = 0;
        int flag2 = 0;

        while(!userInput.equals("q")) {
            userOpcode.add(new Opcode());
            userOperand.add(new Operand());
            Scanner obj = new Scanner(System.in);
            userInput = obj.next();
            if(userInput.equals("q")) {
                break;
            }
            userOpcode.get(i).setOpcode(userInput);
            userInput = obj.next();
            userOperand.get(i).setOperand(userInput);
            flag1 = checkUserOpcode();
            flag2 = checkUserOperand();
            if(flag1 == -2 || flag2 == -1) {
                continue;        
            }
            i++;
            cc++;
        }
    }
    
    public int checkUserOpcode() {
        int op = 0;
       
        op = userOpcode.get(cc).checkOpcode();
        return op;
        //setMemory(op, opr);
    } //end checkUserCode

    public int checkUserOperand() {
        int opr = 0;

        opr = userOperand.get(cc).checkOperand();
        return opr;
    }

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
        else if(opNum == 3) {
            regY.setValue(oprValue);
        }
    } //end Accumulators
} //end Code

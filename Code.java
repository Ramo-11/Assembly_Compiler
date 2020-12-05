import java.util.*;
import java.io.*;
import java.io.Serializable;

public class Code implements java.io.Serializable{

    //String instruction;
    int cc;     //This counter is for the line of code
    ArrayList<Opcode> userOpcode;
    ArrayList<Operand> userOperand;
    Accumulator accA = new Accumulator();
    Accumulator accB = new Accumulator();
    Register regX = new Register();
    Register regY = new Register();

    public Code() {
        //instruction = "0";
        userOpcode = new ArrayList<Opcode>();
        userOperand = new ArrayList<Operand>();
        cc = 0;
    }
    
    public void setUserCode(){
        System.out.println("Please enter your solution to the problem (Press q to stop): \n");
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
            flag1 = checkUserOpcode();
            if(flag1 >= 8) {
                i++;
                cc++;
                setMemoryOpcode(flag1);
                continue;
            }
            userInput = obj.next();
            userOperand.get(i).setOperand(userInput);
            flag2 = checkUserOperand();
            if(flag1 == -2 || flag2 == -1) {
                continue;        
            }
            i++;
            cc++;
            setMemory(flag1, flag2);
        }
    }
    
    public int checkUserOpcode() {
        int op = 0;
        op = userOpcode.get(cc).checkOpcode();
        return op;
    } //end checkUserCode

    public int checkUserOperand() {
        int opr = 0;

        opr = userOperand.get(cc).checkOperand();
        return opr;
    }

    public void setMemoryOpcode(int opNum) {
        if(opNum == 8) { //DECA
            accA.decValue();
        }
        else if(opNum == 9) { //DECB
            accB.decValue();
        }
        else if(opNum == 10) { //DEX
            regX.decValue(); 
        }
        else if(opNum == 11) { //DEY
            regY.decValue(); 
        }
        else if(opNum == 12) { //INCA
            accA.incValue();
        }
        else if(opNum == 13) { //INCB
            accB.incValue();
        }
        else if(opNum == 14) { //INX
            regX.incValue();
        }
        else if(opNum == 15) { //INY
            regY.incValue();
        }
    } //end setMemoryOpcode

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
        else if(opNum == 3) { //LDY
            regY.setValue(oprValue);
        }
        else if(opNum == 4) { //ADDA
            accA.addValue(oprValue);
        }
        else if(opNum == 5) { //ADDB
            accB.addValue(oprValue);
        }
        else if(opNum == 6) { //ADX
            regX.addValue(oprValue);
        }
        else if(opNum == 7) { //ADY
            regY.addValue(oprValue);
        }
    } //end setMemory

    public void resetCounter() {
        cc = 0;
    }
} //end Code

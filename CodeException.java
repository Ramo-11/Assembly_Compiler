import java.util.*;

public class CodeException extends Exception {
    
    public CodeException(){
        super("Syntax is not correct!!");
    }
    
    public CodeException(String message) {
        super(message);
    }
}//end codeException


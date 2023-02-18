package lesson15_exception_debug.triangle_exception;

public class IllegalTriangleException extends Exception{
    public IllegalTriangleException(String str){
        super(str);
    }
}


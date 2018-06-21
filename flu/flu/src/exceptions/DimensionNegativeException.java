package exceptions;

public class DimensionNegativeException extends Exception {
    public DimensionNegativeException(){
        super();
    }

    public DimensionNegativeException(String message){
        super(message);
    }
}
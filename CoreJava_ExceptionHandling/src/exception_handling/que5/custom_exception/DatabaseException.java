package exception_handling.que5.custom_exception;

public class DatabaseException extends ApplicationException{
    public DatabaseException(String message){
        super(message);
    }
}

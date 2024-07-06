public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String specificReason)
    {
        super(specificReason);
    }
}

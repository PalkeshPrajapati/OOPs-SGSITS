package hotelSystem;

public class OverbookingException extends Exception {
    public OverbookingException(String message) {
        super(message);
    }
}
package work;

public class WrongPasswordException extends Throwable {
    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}

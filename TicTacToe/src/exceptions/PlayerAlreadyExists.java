package exceptions;

public class PlayerAlreadyExists extends RuntimeException{

    public PlayerAlreadyExists(final String name) {
        super(name + " player already exists");
    }
}

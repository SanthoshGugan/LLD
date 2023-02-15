package exceptions;

public class PlayerNotFound extends RuntimeException{

    public PlayerNotFound(final String name) {
        super(name + " player not found");
    }
}

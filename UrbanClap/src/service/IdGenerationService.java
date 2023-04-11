package service;

import java.util.Random;

public class IdGenerationService {

    private final Random random;

    public IdGenerationService() {
        random = new Random();
    }
    public String generateId(final String prefix) {
        final int randomInt = random.nextInt();
        return prefix + String.format("%10d",randomInt);
    }
}

package service;

import java.util.Random;

public class IdGenerationService {

    private final Random random;

    private static final int noOfDigits = 5;
    private static final int MAX = (int) Math.pow(10, noOfDigits) - 1;
    private static final int MIN = (int) Math.pow(10, noOfDigits - 1);
    public IdGenerationService() {
        random = new Random();
    }
    public String generateId(final String prefix) {
        final int randomInt = random.nextInt(MAX - MIN + 1) + MIN;
        return String.format("%s%010d",prefix, randomInt);
    }
}

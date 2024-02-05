import java.util.Random;

/**
 * Random number generator that generates random numbers within a specified range.
 */
public class RandomGenerator {

    /**
     * Generates a random integer within the specified range.
     *
     * @param lowerBound The lower bound of the range (inclusive).
     * @param upperBound The upper bound of the range (inclusive).
     * @return A random integer within the specified range.
     * @throws IllegalArgumentException if lowerBound is greater than or equals to upperBound.
     */
    public int random(int lowerBound, int upperBound){
        if (lowerBound >= upperBound) {
            throw new IllegalArgumentException("Lower bound must be less than upper bound");
        }
        Random random = new Random();
        return random.nextInt(upperBound-lowerBound + 1)+lowerBound;
    }
}

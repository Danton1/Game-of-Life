import java.util.ArrayList;

/**
 * The class representing a plant in the Game of Life simulation.
 * @author Danton Soares
 * @version Assignment 2a
 */
public class Plant extends Lifeform implements HerbivoreEdible {

    /**
     * Checks if the plant has died.
     */
    @Override
    boolean die() {
        // Since plants cannot die in the game, return false
        return false;
    }

    /**
     * Moves the plant object to a new location on the grid.
     * @return null since plants cannot move
     */
    @Override
    int[] move(int x, int y, World world) {
        return null;
    }

    /**
     * Reproduces the plant object.
     * @param options The amount of empty cells the plant can reproduce into.
     * @return A random number representing the direction the plant should reproduce to.
     */
    @Override
    boolean reproduce(int kinCounter, int foodCounter, int nullCounter){
        return kinCounter >= 4 && nullCounter >= 3 && foodCounter == 0;
    }

    int reproduce(int options) {
        return RandomGenerator.nextNumber(options);
    }

    /**
     * Checks if the plant can eat another lifeform.
     * @param life The lifeform to check if the plant can eat.
     * @return false since plants cannot eat
     */
    @Override
    boolean eat(Lifeform life) {
        return false;
    }

    /**
     * Checks if the plant can pollinate.
     * @return true since plants can pollinate
     */
    @Override
    boolean canReproduce() {
        return true;
    }

    /**
     * Checks if the plant can eat.
     * @return false since plants cannot eat
     */
    @Override
    boolean canEat() {
        return false;
    }

    /**
     * Checks if the plant can eat the specified lifeform.
     * @param life The lifeform to check if the plant can eat.
     * @return false since plants cannot eat
     */
    @Override
    boolean canEat(Lifeform life) {
        return false;
    }

    /**
     * Checks if the plant can move.
     * @return false since plants cannot move
     */
    @Override
    boolean canMove() {
        return false;
    }

    @Override
    boolean isMyType(Lifeform life) {
        return life instanceof Plant;
    }
}

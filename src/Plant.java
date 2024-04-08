import java.util.ArrayList;

/**
 * The class representing a plant in the Game of Life simulation.
 * @author Danton Soares
 * @version Assignment 2b
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
     * @param kinCounter The number of Plant objects around the Plant object.
     * @param foodCounter The number of PlantEdible objects around the Plant object.
     * @param nullCounter The number of null spaces around the Plant object.
     * @return True if conditions are met, false otherwise.
     */
    @Override
    boolean reproduce(int kinCounter, int foodCounter, int nullCounter){
        return kinCounter >= 2 && nullCounter >= 3;
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

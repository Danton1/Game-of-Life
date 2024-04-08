import java.util.ArrayList;

/**
 * The class representing a herbivore in the Game of Life simulation.
 * @author Danton Soares
 * @version Assignment 2b
 */
public class Herbivore extends Lifeform implements CarnivoreEdible{
    /**
     * Constructs a new Herbivore object with default hunger level and maximum hunger.
     */
    Herbivore(){
        maxHunger = 5;
        hunger = 0;
    }

    /**
     * Checks if life is also a Herbivore
     * @param life The lifeform to check if it is the same type as the Herbivore object.
     * @return true if life is a Herbivore, false otherwise.
     */
    boolean isMyType(Lifeform life){
        return life instanceof Herbivore;
    }

    /**
     * Reproduces, creating a new Herbivore object if the conditions are met.
     * @param kinCounter The number of Herbivore objects around the Herbivore object.
     * @param foodCounter The number of HerbivoreEdible objects around the Herbivore object.
     * @param nullCounter The number of null spaces around the Herbivore object.
     * @return The coordinates of the new Herbivore object if the conditions are met, otherwise the coordinates of the current Herbivore object.
     */
    @Override
    boolean reproduce(int kinCounter, int foodCounter, int nullCounter){
        return kinCounter>=1 && nullCounter >=2 && foodCounter>=2;
    }

    /**
     * Checks if the Herbivore object can reproduce.
     * @return false since Herbivores cannot reproduce.
     */
    @Override
    boolean canReproduce() {
        return true;
    }

    /**
     * Checks if the Herbivore object can eat.
     * @return true since Herbivores can eat.
     */
    @Override
    boolean canEat() {
        return true;
    }

    /**
     * Checks if the Herbivore object can eat the specified Lifeform object.
     * @param life The target Lifeform to check if the Herbivore can eat it.
     * @return true if the Lifeform is edible by the Herbivore, false otherwise.
     */
    @Override
    boolean canEat(Lifeform life) {
        return life instanceof HerbivoreEdible;
    }

    /**
     * Checks if the Herbivore object can move.
     * @return true since Herbivores can move.
     */
    @Override
    boolean canMove() {
        return true;
    }
}

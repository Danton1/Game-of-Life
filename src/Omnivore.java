/**
 * The class representing an omnivore in the Game of Life simulation.
 * @author Danton Soares
 * @version Assignment 2b
 */
public class Omnivore extends Lifeform implements CarnivoreEdible {
    /**
     * Constructs a new Omnivore object with default hunger level and maximum hunger.
     */
    Omnivore(){
        maxHunger = 5;
        hunger = 0;
    }

    /**
     * Checks if life is also a Omnivore
     * @param life The lifeform to check if it is the same type as the Omnivore object.
     * @return true if life is a Omnivore, false otherwise.
     */
    boolean isMyType(Lifeform life){
        return life instanceof Omnivore;
    }

    /**
     * Reproduces, creating a new Omnivore object if the conditions are met.
     * @param kinCounter The number of Omnivore objects around the Omnivore object.
     * @param foodCounter The number of Edible objects around the Omnivore object.
     * @param nullCounter The number of null spaces around the Omnivore object.
     * @return The coordinates of the new Omnivore object if the conditions are met, otherwise the coordinates of the current Omnivore object.
     */
    @Override
    boolean reproduce(int kinCounter, int foodCounter, int nullCounter){
        return kinCounter>=1 && nullCounter >=3 && foodCounter>=1;
    }

    /**
     * Checks if the Omnivore object can reproduce.
     * @return false since Omnivores cannot reproduce.
     */
    @Override
    boolean canReproduce() {
        return true;
    }

    /**
     * Checks if the Omnivore object can eat.
     * @return true since Omnivores can eat.
     */
    @Override
    boolean canEat() {
        return true;
    }

    /**
     * Checks if the Omnivore object can eat the specified Lifeform object.
     * @param life The target Lifeform to check if the Omnivore can eat it.
     * @return true if the Lifeform is edible by the Omnivore, false otherwise.
     */
    @Override
    boolean canEat(Lifeform life) {
        return (life instanceof Edible && !isMyType(life));
    }

    /**
     * Checks if the Omnivore object can move.
     * @return true since Omnivores can move.
     */
    @Override
    boolean canMove() {
        return true;
    }
}

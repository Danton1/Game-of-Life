/**
 * The class representing a carnivore in the Game of Life simulation.
 * @author Danton Soares
 * @version Assignment 2b
 */
public class Carnivore extends Lifeform implements Edible{
    /**
     * Constructs a new Carnivore object with default hunger level and maximum hunger.
     */
    Carnivore(){
        maxHunger = 5;
        hunger = 0;
    }

    /**
     * Checks if life is also a Carnivore
     * @param life The lifeform to check if it is the same type as the Carnivore object.
     * @return true if life is a Carnivore, false otherwise.
     */
    boolean isMyType(Lifeform life){
        return life instanceof Carnivore;
    }

    /**
     * Reproduces, creating a new Carnivore object if the conditions are met.
     * @param kinCounter The number of Carnivore objects around the Carnivore object.
     * @param foodCounter The number of CarnivoreEdible objects around the Carnivore object.
     * @param nullCounter The number of null spaces around the Carnivore object.
     * @return True if conditions are met, false otherwise.
     */
    @Override
    boolean reproduce(int kinCounter, int foodCounter, int nullCounter){
        return kinCounter>=1 && nullCounter >=3 && foodCounter>=2;
    }

    /**
     * Checks if the Carnivore object can reproduce.
     * @return false since Carnivores cannot reproduce.
     */
    @Override
    boolean canReproduce() {
        return true;
    }

    /**
     * Checks if the Carnivore object can eat.
     * @return true since Carnivores can eat.
     */
    @Override
    boolean canEat() {
        return true;
    }

    /**
     * Checks if the Carnivore object can eat the specified Lifeform object.
     * @param life The target Lifeform to check if the Carnivore can eat it.
     * @return true if the Lifeform is edible by the Carnivore, false otherwise.
     */
    @Override
    boolean canEat(Lifeform life) {
        return life instanceof CarnivoreEdible;
    }

    /**
     * Checks if the Carnivore object can move.
     * @return true since Carnivores can move.
     */
    @Override
    boolean canMove() {
        return true;
    }
}

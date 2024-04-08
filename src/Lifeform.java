import java.util.ArrayList;

/**
 * The abstract class representing a generic lifeform in the simulation.
 * @author Danton Soares
 * @version Assignment 2b
 */
abstract class Lifeform {
    // Current hunger level of the lifeform
    int hunger = 0;

    // Maximum hunger level before the lifeform dies
    int maxHunger = 0;

    /**
     * Increments the Lifeform's hunger level and checks if it has died from hunger.
     * @return true if the lifeform dies, false otherwise.
     */
    boolean die() {
        hunger++;
        return hunger >= maxHunger;
    }

    /**
     * Method representing the movement of the lifeform.
     * Moves them to a new location in the world.
     * @param x X coordinate of the cell where the lifeform is in.
     * @param y Y coordinate of the cell where the lifeform is in.
     * @param world The World where all cells are in.
     * @return The direction the lifeform should move to or null if no moving options.
     */
    int[] move(int x, int y, World world) {
        int h = x;
        int w = y;
        int[] from = {x,y};
        int[] checked = new int[8];
        int checkedMoves = 0;
        boolean invalid = true;
        while (invalid) {
            int random = RandomGenerator.nextNumber(8);
            switch (random) {
                case 0:
                    h--; w--;
                    break;
                case 1:
                    h--;
                    break;
                case 2:
                    h--; w++;
                    break;
                case 3:
                    w--;
                    break;
                case 4:
                    w++;
                    break;
                case 5:
                    h++; w--;
                    break;
                case 6:
                    h++;
                    break;
                case 7:
                    h++; w++;
                    break;
                default:
                    //should not get here
                    return null;
            }
            if (checked[random] == 1){
                continue;
            }
            int[] to = {h, w};
            World.Cell cell = world.checkMove(h, w);
            if(cell != null){
                if(cell.getLife() == null){
                    return to;
                }
                else if (eat(cell.getLife())){
                    return to;
                }
                invalid = false;
            }
            checked[random] = 1;
            checkedMoves++;
            if(checkedMoves>=8) break;
        }
        return null;
    }

    /**
     * Reproduction method of lifeforms. Checks if they can reproduce, asks world
     * for neighboring cells and check the amount of its own kin, empty cells and food.-
     * @param h The x coordinate of the lifeform.
     * @param w The y coordinate of the lifeform.
     * @param world The world where the lifeform is in.
     * @return The direction the lifeform should reproduce to.
     */
    int[] mate(int h, int w, World world) {
        //Asking the world for all the neighboring cells of this lifeform
        World.Cell[][] neighbors = world.getNeighbors(h, w);
        int foodCounter = 0;
        int kinCounter = 0;
        int nullCounter = 0;
        // Temporary array to store the free spaces
        ArrayList<int[]> freeSpaces = new ArrayList<>();
        // Loop through the 8 surrounding cells
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                int checkH = h + i;
                int checkW = w + j;
                // If the cell being check is out of bounds, continue
                World.Cell cell = neighbors[i+1][j+1];
                if(cell==null) continue;
                if (isMyType(cell.getLife())){
                    kinCounter++;
                }
                else if (canEat(cell.getLife())) {
                    foodCounter++;
                } else if (cell.getCurrState().equalsIgnoreCase("empty")) {
                    nullCounter++;
                    freeSpaces.add(new int[]{checkH, checkW});
                }
            }
        }
        boolean reproduced = reproduce(kinCounter, foodCounter, nullCounter);
        if(reproduced) {
            int random = RandomGenerator.nextNumber(nullCounter);
            return freeSpaces.get(random);
        }
        return null;
    }

    /**
     * Abstract method that checks if a lifeform can reproduce based on its own conditions.
     * @param kinCounter The number of lifeforms of the same type around the lifeform.
     * @param foodCounter The number of edible lifeforms around the lifeform.
     * @param nullCounter The number of empty cells around the lifeform.
     * @return A random number representing the direction the lifeform should reproduce to.
     */
    abstract boolean reproduce(int kinCounter, int foodCounter, int nullCounter);

    /**
     * Method representing the eating of another lifeform.
     * @param life The lifeform to eat.
     * @return true if the lifeform can be eaten, false otherwise.
     * @see Edible
     */
    boolean eat(Lifeform life) {
        if(canEat(life)) {
            hunger = 0;
            return true;
        }
        return false;
    }

    /**
     * Abstract method that checks if the lifeform is able to reproduce.
     * @return true if the lifeform can reproduce, false otherwise.
     */
    abstract boolean canReproduce();

    /**
     * Abstract method that checks if the lifeform is able to eat.
     * @return true if the lifeform can eat, false otherwise.
     */
    abstract boolean canEat();

    /**
     * Abstract method representing the eating of another lifeform.
     * @param life The lifeform to check if the lifeform can eat it.
     * @return true if the lifeform can eat the target lifeform, false otherwise.
     */
    abstract boolean canEat(Lifeform life);

    /**
     * Abstract method representing the movement of the lifeform.
     * @return true if the lifeform can move, false otherwise.
     */
    abstract boolean canMove();

    /**
     * Method that sets the hunger level of the lifeform.
     * @param life The lifeform to get the hunger level from.
     */
    void setHunger(Lifeform life){
        if (life == null) {
            this.hunger = 0;
        } else {
            this.hunger = life.hunger;
        }
    }

    /**
     * Abstract method that checks if the lifeform is of the same type as the target lifeform.
     * @param life The lifeform to check if it is the same type as the lifeform.
     * @return true if the lifeform is of the same type, false otherwise.
     */
    abstract boolean isMyType(Lifeform life);
}


/**
 * The Game class is responsible for managing the game state and the lifecycle of the World object.
 * @author Danton Soares
 * @version Assignment 2b
 */
public class Game {
    private int turn = 0;
    private final World world;

    /**
     * Constructs a Game object with a new World object.
     */
    public Game(){
        world = new World(25,25);
    }

    /**
     * World object getter.
     */
    World getWorld(){
        return world;
    }

    /**
     * Increments the turn counter and calls the lifecycle method of the World object.
     */
    void incrementTurn(){
        turn++;
        world.lifecycle();
    }

    /**
     * Increments the turn counter by the specified number and calls the lifecycle method of the World object.
     *
     * @param num The number of turns to increment the turn counter by.
     */
    void incrementTurn(int num){
        for (int i = 0; i < num; i++){
            turn++;
            world.lifecycle();
        }
    }

    /**
     * Turn counter getter.
     */
    int getTurn(){
        return turn;
    }
}

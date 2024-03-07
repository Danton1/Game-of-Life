/**
 * @author Danton Soares
 * @version Assignment 2a
 */
public class Game {
    private int turn = 0;
    private final World world;

    public Game(){
        world = new World(25,25);
    }
    World getWorld(){
        return world;
    }

    void incrementTurn(){
        turn++;
        world.lifecycle();
    }
    void incrementTurn(int num){
        for (int i = 0; i < num; i++){
            turn++;
            world.lifecycle();
        }
    }
    int getTurn(){
        return turn;
    }
}

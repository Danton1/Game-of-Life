/**
 * @author Danton Soares
 * @version Assignment 2a
 */
public class Game {
    int turn = 0;
    private final World world;

    public Game(){
        world = new World(25,25);
    }
    World getWorld(){
        return world;
    }
//    if click(){
//        turn++;
//        world.lifecycle();
//    }
}

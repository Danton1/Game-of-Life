public class Herbivore implements Movable, Dies{
    @Override
    public boolean canImoveThere() {
        return false;
    }

    @Override
    public void die() {

    }

    public void move(){
        
    }

    public void moveAll(){
        // Also calls eats();
    }

    public void eats(){
        // Check if there's any edible plants at the current tiles
        // If yes, makes one plant die in that specific tile; 
    }
}

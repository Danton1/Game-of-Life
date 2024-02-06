public class Herbivore extends Life implements Movable{
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
        // All Herbivore call eats();
    }

    public void eats(){
        // Check if there's any edible plants at the current tiles
        // If yes, makes one plant die in that specific tile; 

    }
}

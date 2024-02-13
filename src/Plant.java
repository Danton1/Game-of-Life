public class Plant extends Lifeform implements Reproduces {

    @Override
    public void die() {
        
    }

    public boolean canIPollinate(){

    }

    public void seed(){

    }

    public void seedAll(){ 
        // All Plants call seed();
    }

    public boolean isEdible(){
        // Check if there's any herbivores are around
        // If yes, makes them edible in that specific tile; 
    }
}

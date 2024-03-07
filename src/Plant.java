/**
 * @author Danton Soares
 * @version Assignment 2a
 */
public class Plant extends Lifeform implements HerbivoreEdible {

    @Override
    boolean die() {
        return false;
    }

    @Override
    int[] move(int h, int w) {
        return new int[]{0};
    }

    @Override
    void reproduce() {

    }

    @Override
    void eat() {
        return;
    }

    @Override
    boolean canPollinate() {
        return false;
    }

    @Override
    boolean canEat() {
        return false;
    }

    @Override
    public boolean isEdible() {
        return false;
    }
}

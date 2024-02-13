public class Plant extends Lifeform implements HerbivoreEdible {

    @Override
    void die() {

    }

    @Override
    void move() {

    }

    @Override
    void reproduce() {

    }

    @Override
    void eat() {

    }

    @Override
    boolean canPollinate() {
        return false;
    }

    @Override
    boolean canMove() {
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

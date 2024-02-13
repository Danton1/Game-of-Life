abstract class Lifeform {
    int hunger;
    int maxHunger;

    abstract void die();
    abstract void move();
    abstract void seed();
    abstract void eats();
    abstract boolean canPollinate();
    abstract boolean canMove();
    abstract boolean canEat();
}

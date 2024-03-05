/**
 * @author Danton Soares
 * @version Assignment 2a
 */
abstract class Lifeform {
    int hunger;
    int maxHunger;

    abstract void die();
    abstract void move();
    abstract void reproduce();
    abstract void eat();
    abstract boolean canPollinate();
    abstract boolean canMove();
    abstract boolean canEat();
}

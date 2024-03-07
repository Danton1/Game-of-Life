/**
 * @author Danton Soares
 * @version Assignment 2a
 */
abstract class Lifeform {
    int hunger;
    int maxHunger;

    abstract boolean die();
    abstract int[] move(int h, int w);
    abstract void reproduce();
    abstract void eat();
    abstract boolean canPollinate();
    abstract boolean canEat();
}

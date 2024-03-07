/**
 * @author Danton Soares
 * @version Assignment 2a
 */
public class Herbivore extends Lifeform{

    @Override
    boolean die() {
        hunger++;
        return hunger >= 5;
    }

    @Override
    int[] move(int h,int w) {
        int random = RandomGenerator.nextNumber(8);
        switch (random) {
            case 0:
                h--;
                w--;
                break;
            case 1:
                h--;
                break;
            case 2:
                h--;
                w++;
                break;
            case 3:
                w--;
                break;
            case 4:
                w++;
                break;
            case 5:
                h++;
                w--;
                break;
            case 6:
                h++;
                break;
            case 7:
                h++;
                w++;
                break;
            default:
                //should not get here
                return null;
        }
        return new int[]{1,h,w,random};
    }

    @Override
    void reproduce() {
        return;
    }

    @Override
    void eat() {
        hunger = 0;
    }

    @Override
    boolean canPollinate() {
        return false;
    }

    @Override
    boolean canEat() {
        return false;
    }
}

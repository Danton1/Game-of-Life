public class Board {

    private class Tile{
        public enum State {HERBIVORE, PLANT, EMPTY}
        public Tile(){
        }
        public State currState(){

        }
    }
    public Board(int cols, int rows){
        RandomGenerator rg = new RandomGenerator();
        int randomNumber = rg.random(0,99);
        if(randomNumber >= 85){
            new Herbivore();
        } else if(randomNumber >= 65){
            new Plant();
        }
    }
    public boolean canThisGuyMove(Tile whereToMove){
        return false;
    }
}

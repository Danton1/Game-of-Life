public class Board {

    private class Tile {
        public enum State {HERBIVORE, PLANT, EMPTY}
        public Tile(){}
        public State currState(){}
        public boolean isEdible(){}
        public void emptyTile(){}
    }

    Tile[][] grid;

    public Board (int cols, int rows) {
        grid = new Tile[cols][rows];
        RandomGenerator rg = new RandomGenerator();
        int randomNumber = rg.random(0,99);
        if(randomNumber >= 85){
            distribute new Herbivore();
        } else if(randomNumber >= 65){
            distribute new Plant();
        }
    }

    public boolean checkMove (Tile currTile, Tile nextTile) {
        //checks if move is legal or not
        return false;
    }
}

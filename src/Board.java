public class Board {

    private class Tile {
        private enum State {HERBIVORE, PLANT, EMPTY}
        public Life life;
        public Tile(){}
        public State currState(){}
        public void setState (State state) {
            if(state.ordinal() == 0){
                // Herbivore stegossaurus = new Herbivore();
                life = new Herbivore();
            } else if (state.ordinal() == 1){
                // Plant cranBerryBush = new Plant();
                life = new Plant();
            } else if (state.ordinal() == 2){
                life = null;
            } 
        }
    }

    Tile[][] grid;

    public Board (int cols, int rows) {
        grid = new Tile[cols][rows];
        RandomGenerator rg = new RandomGenerator();
        for (Tile[] tile : grid) {
            int randomNumber = rg.random(0,99);
            if(randomNumber >= 85){
                tile.setState(Tile.HERBIVORE);
            } else if(randomNumber >= 65){
                tile.setState(Tile.PLANT);
            } else {
                tile.setState(Tile.EMPTY);
            }
        }
    }

    public boolean checkMove (Tile currTile, Tile nextTile) {
        //checks if move is legal or not
        return false;
    }
}

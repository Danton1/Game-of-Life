public class World {

    private enum State {HERBIVORE, PLANT, EMPTY}

    public void lifecycle() {
        for (Cell[] cells : this.grid) {
            for (Cell cell : cells) {
                cell.life.move();
                cell.life.eat();
                cell.life.reproduce();
            }
        }
    }

    public class Cell {
        private Lifeform life;
        public int[] coord;
        public State currState;
        public Cell(int x, int y){
            coord = new int[]{x, y};
        }
        public String getCurrState(){
            return this.currState.name();
        }
        public void setState (State state) {
            if(state.ordinal() == 0){
                life = new Herbivore();
                currState = state;
            } else if (state.ordinal() == 1){
                life = new Plant();
                currState = state;
            } else if (state.ordinal() == 2){
                life = null;
                currState = state;
            } 
        }
    }

    public Cell[][] grid;

    public World(int cols, int rows) {
        grid = new Cell[cols][rows];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                grid[y][x] = new Cell(x, y);
                int randomNumber = RandomGenerator.random(0, 99);
                if (randomNumber >= 85) {
                    grid[y][x].setState(State.HERBIVORE);
                } else if (randomNumber >= 65) {
                    grid[y][x].setState(State.PLANT);
                } else {
                    grid[y][x].setState(State.EMPTY);
                }
            }
        }
    }

    public boolean checkMove (Cell currCell, Cell nextCell) {
        //checks if move is legal or not
        return false;
    }
}

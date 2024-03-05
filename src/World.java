/**
 * @author Danton Soares
 * @version Assignment 2a
 */
public class World {
    private enum State {HERBIVORE, PLANT, EMPTY}
    public Cell[][] grid;
    private final int height;
    private final int width;

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
        private State currState;
        public Cell(int x, int y){
            coord = new int[]{x, y};
        }
        public String getCurrState(){
            return this.currState.name();
        }
        public void setState (State state) {
            currState = state;
            if(state.ordinal() == 0){
                life = new Herbivore();
            } else if (state.ordinal() == 1){
                life = new Plant();
            } else if (state.ordinal() == 2){
                life = null;
            } 
        }
    }

    public World(int cols, int rows) {
        height = cols;
        width = rows;
        grid = new Cell[cols][rows];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Cell(i, j);
                int randomNumber = RandomGenerator.nextNumber(99);
                if (randomNumber >= 85) {
                    grid[i][j].setState(State.HERBIVORE);
                } else if (randomNumber >= 65) {
                    grid[i][j].setState(State.PLANT);
                } else {
                    grid[i][j].setState(State.EMPTY);
                }
            }
        }
    }

    public boolean checkMove (Cell currCell, Cell nextCell) {
        //checks if move is legal or not
        return false;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}

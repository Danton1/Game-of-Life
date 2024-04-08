/**
 * The class representing the world in the simulation.
 * The world controls the board and each individual cell,
 * functioning like a board in a board-game.
 * @author Danton Soares
 * @version Assignment 2b
 */
public class World {
    private enum State {HERBIVORE, PLANT, CARNIVORE, OMNIVORE, EMPTY}
    // Grid representing the world
    public Cell[][] grid;

    // Grid representing the future state of the world
    public Cell[][] futureGrid;
    // Height of the world
    private final int height;
    private final int width;

    public void lifecycle() {
        // Resetting the future world as present world
        for (int h= 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                futureGrid[h][w].setState(grid[h][w].currState);
            }
        }

        for (int h= 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if(grid[h][w].life != null){
                    reproduce(h,w);
                    move(h, w);
                }
            }
        }
        for (int h= 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                grid[h][w].setState(futureGrid[h][w].currState);
                if(futureGrid[h][w].life != null) {
                    grid[h][w].life.hunger = futureGrid[h][w].life.hunger;
                }
                futureGrid[h][w].setState(State.EMPTY);
            }
        }
    }

    /**
     * The class representing a cell in the world.
     */
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
        public Lifeform getLife() {
            return this.life;
        }
        public void setState (State state) {
            currState = state;
            if(state.ordinal() == 0){
                life = new Herbivore();
            } else if (state.ordinal() == 1){
                life = new Plant();
            } else if (state.ordinal() == 2){
                life = new Carnivore();
            } else if (state.ordinal() == 3){
                life = new Omnivore();
            } else if (state.ordinal() == 4){
                life = null;
            }
        }
    }

    /**
     * Constructs a World object with the specified number of rows and columns.
     * @param cols The number of columns in the world.
     * @param rows The number of rows in the world.
     */
    public World(int cols, int rows) {
        height = cols;
        width = rows;
        grid = new Cell[cols][rows];
        futureGrid = new Cell[cols][rows];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Cell(i, j);
                futureGrid[i][j] = new Cell(i, j);
                futureGrid[i][j].setState(State.EMPTY);
                int randomNumber = RandomGenerator.nextNumber(99)%100;
                if (randomNumber >= 80) {
                    grid[i][j].setState(State.HERBIVORE);
                } else if (randomNumber >= 60) {
                    grid[i][j].setState(State.PLANT);
                } else if (randomNumber >= 50) {
                    grid[i][j].setState(State.CARNIVORE);
                } else if (randomNumber >= 45) {
                    grid[i][j].setState(State.OMNIVORE);
                } else {
                    grid[i][j].setState(State.EMPTY);
                }
            }
        }
    }

    /**
     * Checks if the move from the current cell to the next cell is valid.
     * @param h The row of the next cell.
     * @param w The column of the next cell.
     * @return The next cell if the move is valid, null otherwise.
     */
    public Cell checkMove (int h, int w) {
        // Checking if the next cell is within the world bounds
        if (h >= 0 && w >= 0 && h < height && w < width){
            return futureGrid[h][w];
        }
        return null;
    }

    /**
     * Height getter.
     * @return The height of the world.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Moves the lifeform from the current cell to the next cell.
     * @param from The current cell.
     * @param to The next cell.
     */
    private void move(int[] from, int[] to){
        futureGrid[to[0]][to[1]].setState(grid[from[0]][from[1]].currState);
        futureGrid[to[0]][to[1]].life.setHunger(grid[from[0]][from[1]].life);
        futureGrid[from[0]][from[1]].setState(State.EMPTY);
    }

    /**
     * Invokes the Lifeform's move method to move the lifeform in the cell,
     * letting the lifeform decide where to move.
     * @param h The row of the cell.
     * @param w The column of the cell.
     */
    private void move(int h, int w){
        Lifeform life = grid[h][w].life;
        int[] res = life.move(h, w, this);
        if (res != null) {
            move(new int[]{h, w}, res);
            if (futureGrid[res[0]][res[1]].life != null
                    && futureGrid[res[0]][res[1]].life.die()) {
                futureGrid[res[0]][res[1]].setState(State.EMPTY);
            }
        } else {
            if (futureGrid[h][w].life.die()) {
                futureGrid[h][w].setState(State.EMPTY);
            }
        }
    }

    /**
     * Invokes the Lifeform's reproduce method to reproduce the lifeform in the cell,
     * letting the lifeform decide where to reproduce.
     * @param h The row of the cell.
     * @param w The column of the cell.
     */
    public void reproduce(int h, int w){
        int[] coord = grid[h][w].life.mate(h, w, this);
        if(coord != null){
            futureGrid[coord[0]][coord[1]].setState(grid[h][w].currState);
            futureGrid[coord[0]][coord[1]].life.hunger = 0;
        }
    }

    /**
     * Gets the neighboring cells of the specified cell and returns it as a 2d array of Cells.
     * @param h The row of the cell.
     * @param w The column of the cell.
     * @return A 3x3 array of cells representing the neighbors of the cell.
     */
    public Cell[][] getNeighbors(int h, int w){
        Cell[][] neighbors = new Cell[3][3];
        for (int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if(checkMove(h+i, w+j) != null) {
                    neighbors[i + 1][j + 1] = futureGrid[h + i][w + j];
                } else {
                    neighbors[i + 1][j + 1] = null;
                }
            }
        }
        return neighbors;
    }

    /**
     * Width getter.
     * @return The width of the world.
     */
    public int getWidth() {
        return width;
    }
}

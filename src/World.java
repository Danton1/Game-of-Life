import java.util.Arrays;

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
        int[][] availableMoves = new int[29][2];
        int counter = 0;
        for (int h= 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if(grid[h][w].life != null){
                    boolean invalid = true;
                    int[] checked = new int[8];
                    int checkedMoves = 0;
                    while(invalid) {
                        int[] res = grid[h][w].life.move(h, w);
                        if(res[0] == 0) break;
                        int move = res[3];
                        if (checked[move] == 1){
                            continue;
                        }
                        int[] from = new int[]{h, w};
                        int[] to = Arrays.copyOfRange(res, 1, 3);
                        if (checkMove(from, to)) {
                            move(from, to);
                            invalid = false;
                        }
                        checked[move] = 1;
                        checkedMoves++;
                    }
                }
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

    public boolean checkMove (int[] currCell, int[] nextCell) {
        int currH = currCell[0];
        int currW = currCell[1];
        // Since Plants can't move, return false if they try
        if(grid[currH][currW].life instanceof HerbivoreEdible) return false;
        int h = nextCell[0];
        int w = nextCell[1];
        /* Checking if the next cell is within the world bounds,
        if it's not the same as the current cell and if it's herbivore edible
         */
        return (h >= 0 && w >= 0 && h < height && w < width && !(h == currH && w == currW));
    }

    public int getHeight() {
        return height;
    }

    private void move(int[] from, int[] to){
        grid[to[0]][to[1]].life = grid[from[0]][from[1]].life;
        grid[to[0]][to[1]].setState(grid[from[0]][from[1]].currState);
        grid[from[0]][from[1]].life = null;
        grid[from[0]][from[1]].setState(State.EMPTY);
    }

    public int getWidth() {
        return width;
    }
}

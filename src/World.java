public class World {

    public void lifecycle() {
        for (Cell[] cells : this.grid) {
            for (Cell cell : cells) {
                cell.life.move();
                cell.life.eat();
                cell.life.reproduce();
            }
        }
    }

    private class Cell {
        private enum State {HERBIVORE, PLANT, EMPTY}
        private Lifeform life;
        public int[] coord;
        private State currState;
        public Cell(int x, int y){
            coord = new int[]{x, y};
        }
        public State getCurrState(){
            return this.currState;
        }
        public void setState (State state) {
            if(state.ordinal() == 0){
                // Herbivore herb = new Herbivore();
                life = new Herbivore();
            } else if (state.ordinal() == 1){
                // Plant plant = new Plant();
                life = new Plant();
            } else if (state.ordinal() == 2){
                life = null;
            } 
        }
    }

    Cell[][] grid;

    public World(int cols, int rows) {
        grid = new Cell[cols][rows];
        RandomGenerator rg = new RandomGenerator();
        for (Cell[] cell : grid) {
            int randomNumber = rg.random(0,99);
            if(randomNumber >= 85){
                cell.setState(Cell.HERBIVORE);
            } else if(randomNumber >= 65){
                cell.setState(Cell.PLANT);
            } else {
                cell.setState(Cell.EMPTY);
            }
        }
    }

    public boolean checkMove (Cell currCell, Cell nextCell) {
        //checks if move is legal or not
        return false;
    }
}

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
        public State currState;
        public Cell(int x, int y){
            coord = new int[]{x, y};
        }
        public String getCurrState(){
            return this.currState.name();
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

    public Cell[][] grid;

    public World(int cols, int rows) {
        grid = new Cell[cols][rows];
        RandomGenerator rg = new RandomGenerator();
        for (Cell[] cells : grid) {
            for (Cell cell : cells) {
                int randomNumber = rg.random(0, 99);
                if (randomNumber >= 85) {
                    cell.setState(Cell.State.HERBIVORE);
                } else if (randomNumber >= 65) {
                    cell.setState(Cell.State.PLANT);
                } else {
                    cell.setState(Cell.State.EMPTY);
                }
            }
        }
    }

    public boolean checkMove (Cell currCell, Cell nextCell) {
        //checks if move is legal or not
        return false;
    }
}

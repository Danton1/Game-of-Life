public class Game {
    int turn = 0;
    World world = new World(25,25);
    if click(){
        turn++;
        for(Cell cell : world){
            cell.life.eat();
        }
    }
}

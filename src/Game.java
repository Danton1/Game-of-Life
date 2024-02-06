public class Game {
    int turn = 0;
    Board board = new Board(25,25);
    if click(){
        turn++;
        Herbivore.moveAll();
        Plant.seed();
    }
}

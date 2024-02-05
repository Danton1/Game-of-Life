public class Game {
    int turn = 0;
    Board board = new Board(30,30);
    if click(){
        turn++;
        Herbivore.moveAll();
        Plants.seed();
    }
}

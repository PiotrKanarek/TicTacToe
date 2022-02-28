package pl.piotrkanarek.game.demo;

import pl.piotrkanarek.game.logic.dataModel.Board;
import pl.piotrkanarek.game.logic.playGame.FindWinner;
import pl.piotrkanarek.game.logic.playGame.Game;
import pl.piotrkanarek.game.players.User;
import pl.piotrkanarek.game.players.Computer;

public class TicTacToeDemo {
    public static void main(String[] args) {

        Board board = new Board();
        User user = new User('x');
        User user1 = new User('o');
        Computer computer = new Computer('o');
        FindWinner findWinner = new FindWinner();
        Game game = new Game();
        game.start(board, computer, user, findWinner);
        //game.start(board, user, computer, findWinner);
        //game.start(board, user, user1, findWinner);
    }
}

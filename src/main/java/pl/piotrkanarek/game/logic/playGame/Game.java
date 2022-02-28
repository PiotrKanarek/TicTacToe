package pl.piotrkanarek.game.logic.playGame;

import pl.piotrkanarek.game.logic.dataModel.Board;
import pl.piotrkanarek.game.players.User;
import pl.piotrkanarek.game.players.Computer;

public class Game {

    public void start(Board board, Computer computer, User user, FindWinner findWinner) {
        //method with course of the game between Computer vs User
        board.printInfo();

        while (!(findWinner.isDraw() || findWinner.isSomeoneWin())) {
            computer.computerMove(board, user, findWinner);
            user.userMove(board, computer, findWinner, "TWÓJ RUCH");
        }
        findWinner.assignWin(computer, user);
    }

    public void start(Board board, User user, Computer computer, FindWinner findWinner) {
        //method with course of the game between User vs Computer
        board.printInfo();

        while (!(findWinner.isDraw() || findWinner.isSomeoneWin())) {
            user.userMove(board, computer, findWinner, "TWÓJ RUCH");
            computer.computerMove(board, user, findWinner);
        }
        findWinner.assignWin(computer, user);
    }

    public void start(Board board, User user1, User user2, FindWinner findWinner) {
        //method with course of the game between User vs User
        board.printInfo();

        while (!(findWinner.isDraw() || findWinner.isSomeoneWin())) {
            user1.userMove(board, user2, findWinner, "RUCH GRACZA 1");
            user2.userMove(board, user1, findWinner, "RUCH GRACZA 2");
        }
        findWinner.assignWin(user1, user2);
    }
}

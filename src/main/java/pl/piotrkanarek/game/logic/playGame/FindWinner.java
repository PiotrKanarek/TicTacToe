package pl.piotrkanarek.game.logic.playGame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.piotrkanarek.game.logic.dataModel.Board;
import pl.piotrkanarek.game.players.Computer;
import pl.piotrkanarek.game.players.User;

public class FindWinner {

    Logger logger = LoggerFactory.getLogger(FindWinner.class);

    private char winner;
    private boolean draw = false;
    private boolean someoneWin = false;

    public boolean isDraw() {
        return draw;
    }

    public boolean isSomeoneWin() {
        return someoneWin;
    }

    private boolean checkIfDraw(Board board) {
        int tmp = 0;

        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard().length; j++) {
                if (board.getBoard()[i][j] == board.getEmptyField()) {
                    tmp++;
                }
            }
        }
        return tmp == 0;
    }

    private boolean checkIfSomeoneWin(Board board, char symbol) {
        if (board.getBoard()[0][0] == symbol && board.getBoard()[1][1] == symbol && board.getBoard()[2][2] == symbol) //first diagnal
        {
            winner = symbol;
            someoneWin = true;
            return true;
        } else if (board.getBoard()[0][2] == symbol && board.getBoard()[1][1] == symbol && board.getBoard()[2][0] == symbol) //second diagonal
        {
            winner = symbol;
            someoneWin = true;
            return true;
            } else {
                for (int i = 0; i < board.getBoard().length; i++) {
                    if (board.getBoard()[i][0] == symbol && board.getBoard()[i][1] == symbol && board.getBoard()[i][2] == symbol) { //row
                        winner = symbol;
                        someoneWin = true;
                        return true;
                    } else if (board.getBoard()[0][i] == symbol && board.getBoard()[1][i] == symbol && board.getBoard()[2][i] == symbol) { //col
                        winner = symbol;
                        someoneWin = true;
                        return true;
                    }
                }
        }
        return false;
    }

    public boolean checkIfSomeoneWinOrDraw(Board board, char symbol) {
        if (checkIfSomeoneWin(board, symbol)) {
            return true;
        } else if (checkIfDraw(board)) {
            draw = true;
            return true;
        } else {
            return false;
        }
    }

    public void assignWin(Computer computer, User user) {
        if (draw) {
            logger.info("KONIEC GRY\nREMIS");
        } else if (someoneWin) {
            if (computer.getSymbol() == winner) {
                computer.setComputerWin(true);
                logger.info(computer.toString());
            } else if (user.getSymbol() == winner) {
                user.setUserWin(true);
                logger.info(user.toString());
            }
        }

    }

    public void assignWin(User user, User user1) {
        if (draw) {
            logger.info("KONIEC GRY\nREMIS");
        } else if (someoneWin) {
            if (user.getSymbol() == winner) {
                user.setUserWin(true);
                logger.info(user.toString());
            } else if (user1.getSymbol() == winner) {
                user1.setUserWin(true);
                logger.info(user1.toString());
            }
        }
    }

}

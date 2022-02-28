package pl.piotrkanarek.game.players;

import pl.piotrkanarek.game.logic.dataModel.Board;
import pl.piotrkanarek.game.logic.playGame.FindWinner;

public class User extends Player {

    private boolean userWin;

    public User(char symbol) {
        super(symbol);
    }


    public void setUserWin(boolean userWin) {
        this.userWin = userWin;
    }

    @Override
    public String toString() {
        return super.toString() + "Wygrał gracz\nZnak\t" + this.getSymbol();
    }

    public void userMove(Board board, Computer computer, FindWinner findWinner, String message) {

        if (!findWinner.checkIfSomeoneWinOrDraw(board, computer.getSymbol())) {
            System.out.println("Podaj numer pola, na ktorym chcesz umieścić " + getSymbol() +
                    " [1-9] i wciśnij ENTER");
            if (!findWinner.isDraw()) {
                board.setBoardByNumber(getSymbol());
            }
            board.renderBoard(message);
        }

    }

    public void userMove(Board board, User user1, FindWinner findWinner, String message) {

        if (!findWinner.checkIfSomeoneWinOrDraw(board, user1.getSymbol())) {
            System.out.println("Podaj numer pola, na ktorym chcesz umieścić " + getSymbol() +
                    " [1-9] i wciśnij ENTER");
            board.setBoardByNumber(getSymbol());
            board.renderBoard(message);
        }

    }


}

package pl.piotrkanarek.game.players;

import pl.piotrkanarek.game.logic.dataModel.Board;
import pl.piotrkanarek.game.logic.playGame.FindWinner;

public class Computer extends Player {

    private boolean computerWin;

    public Computer(char symbol) {
        super(symbol);
    }

    public void setComputerWin(boolean computerWin) {
        this.computerWin = computerWin;
    }

    @Override
    public String toString() {
        return super.toString() + "Komputer wygrał\nZnak:\t" + this.getSymbol();
    }

    public boolean checkFor2SameSymbols(Board board) {
        //if Computer has two same O symbols in one line it's set third and the Computer win the game

        // check row for the same two symbols
        for (int i = 0; i < board.getBoard().length; i++) {
            if (board.getBoard()[i][0] == getSymbol() && board.getBoard()[i][1] == getSymbol()) {
                if (board.getBoard()[i][2] == board.getEmptyField()) {
                    board.setBoard(i, 2, getSymbol());
                    return true;
                }
            } else if (board.getBoard()[i][0] == getSymbol() && board.getBoard()[i][2] == getSymbol()) {
                if (board.getBoard()[i][1] == board.getEmptyField()) {
                    board.setBoard(i, 1, getSymbol());
                    return true;
                }
            } else if (board.getBoard()[i][1] == getSymbol() && board.getBoard()[i][2] == getSymbol()) {
                if (board.getBoard()[i][0] == board.getEmptyField()) {
                    board.setBoard(i, 0, getSymbol());
                    return true;
                }
            }

            // check column for the same two symbols
            if (board.getBoard()[0][i] == getSymbol() && board.getBoard()[1][i] == getSymbol()) {
                if (board.getBoard()[2][i] == board.getEmptyField()) {
                    board.setBoard(2, i, getSymbol());
                    return true;
                }
            } else if (board.getBoard()[0][i] == getSymbol() && board.getBoard()[2][i] == getSymbol()) {
                if (board.getBoard()[1][i] == board.getEmptyField()) {
                    board.setBoard(1, i, getSymbol());
                    return true;
                }
            } else if (board.getBoard()[1][i] == getSymbol() && board.getBoard()[2][i] == getSymbol()) {
                if (board.getBoard()[0][i] == board.getEmptyField()) {
                    board.setBoard(0, i, getSymbol());
                    return true;
                }
            }
        }

        // check first diagonal for the same two symbols
        if (board.getBoard()[0][0] == getSymbol() && board.getBoard()[1][1] == getSymbol()) {
            if (board.getBoard()[2][2] == board.getEmptyField()) {
                board.setBoard(2, 2, getSymbol());
                return true;
            }
        } else if (board.getBoard()[0][0] == getSymbol() && board.getBoard()[2][2] == getSymbol()) {
            if (board.getBoard()[1][1] == board.getEmptyField()) {
                board.setBoard(1, 1, getSymbol());
                return true;
            }
        } else if (board.getBoard()[1][1] == getSymbol() && board.getBoard()[2][2] == getSymbol()) {
            if (board.getBoard()[0][0] == board.getEmptyField()) {
                board.setBoard(0, 0, getSymbol());
                return true;
            }
        }

        // check second diagonal for the same two symbols
        if (board.getBoard()[0][2] == getSymbol() && board.getBoard()[1][1] == getSymbol()) {
            if (board.getBoard()[2][0] == board.getEmptyField()) {
                board.setBoard(2, 0, getSymbol());
                return true;
            }
        } else if (board.getBoard()[0][2] == getSymbol() && board.getBoard()[2][0] == getSymbol()) {
            if (board.getBoard()[1][1] == board.getEmptyField()) {
                board.setBoard(1, 1, getSymbol());
                return true;
            }
        } else if (board.getBoard()[1][1] == getSymbol() && board.getBoard()[2][0] == getSymbol()) {
            if (board.getBoard()[0][2] == board.getEmptyField()) {
                board.setBoard(0, 2, getSymbol());
                return true;
            }
        }

        return false;
    }

    public boolean blockPlayer(Board board, User user) { //if User has 2 same symbols in one line the Computer
        //set O symbol in empty field to block the player

        // check row for 2 same symbols
        for (int i = 0; i < board.getBoard().length; i++) {
            if (board.getBoard()[i][0] == user.getSymbol() && board.getBoard()[i][1] == user.getSymbol()) {
                if (board.getBoard()[i][2] == board.getEmptyField()) {
                    board.setBoard(i, 2, getSymbol());
                    return true;

                }
            } else if (board.getBoard()[i][0] == user.getSymbol() && board.getBoard()[i][2] == user.getSymbol()) {
                if (board.getBoard()[i][1] == board.getEmptyField()) {
                    board.setBoard(i, 1, getSymbol());
                    return true;
                }
            } else if (board.getBoard()[i][1] == user.getSymbol() && board.getBoard()[i][2] == user.getSymbol()) {
                if (board.getBoard()[i][0] == board.getEmptyField()) {
                    board.setBoard(i, 0, getSymbol());
                    return true;
                }
            }

            // check column for 2 same symbols
            if (board.getBoard()[0][i] == user.getSymbol() && board.getBoard()[1][i] == user.getSymbol()) {
                if (board.getBoard()[2][i] == board.getEmptyField()) {
                    board.setBoard(2, i, getSymbol());
                    return true;
                }
            } else if (board.getBoard()[0][i] == user.getSymbol() && board.getBoard()[2][i] == user.getSymbol()) {
                if (board.getBoard()[1][i] == board.getEmptyField()) {
                    board.setBoard(1, i, getSymbol());
                    return true;
                }
            } else if (board.getBoard()[1][i] == user.getSymbol() && board.getBoard()[2][i] == user.getSymbol()) {
                if (board.getBoard()[0][i] == board.getEmptyField()) {
                    board.setBoard(0, i, getSymbol());
                    return true;
                }
            }
        }

        // check first diagonal for 2 same symbols
        if (board.getBoard()[0][0] == user.getSymbol() && board.getBoard()[1][1] == user.getSymbol()) {
            if (board.getBoard()[2][2] == board.getEmptyField()) {
                board.setBoard(2, 2, getSymbol());
                return true;

            }
        } else if (board.getBoard()[0][0] == user.getSymbol() && board.getBoard()[2][2] == user.getSymbol()) {
            if (board.getBoard()[1][1] == board.getEmptyField()) {
                board.setBoard(1, 1, getSymbol());
                return true;

            }
        } else if (board.getBoard()[1][1] == user.getSymbol() && board.getBoard()[2][2] == user.getSymbol()) {
            if (board.getBoard()[0][0] == board.getEmptyField()) {
                board.setBoard(0, 0, getSymbol());
                return true;

            }
        }

        // check second diagonal for the same two symbols
        if (board.getBoard()[0][2] == user.getSymbol() && board.getBoard()[1][1] == user.getSymbol()) {
            if (board.getBoard()[2][0] == board.getEmptyField()) {
                board.setBoard(2, 0, getSymbol());
                return true;
            }
        } else if (board.getBoard()[0][2] == user.getSymbol() && board.getBoard()[2][0] == user.getSymbol()) {
            if (board.getBoard()[1][1] == board.getEmptyField()) {
                board.setBoard(1, 1, getSymbol());
                return true;
            }
        } else if (board.getBoard()[1][1] == user.getSymbol() && board.getBoard()[2][0] == user.getSymbol()) {
            if (board.getBoard()[0][2] == board.getEmptyField()) {
                board.setBoard(0, 2, getSymbol());
                return true;
            }
        }
        return false;
    }

    public void computerMove(Board board, User user, FindWinner findWinner) {
        String message = "RUCH KOMPUTERA:";

        if (!findWinner.checkIfSomeoneWinOrDraw(board, user.getSymbol())) {

            if (checkFor2SameSymbols(board)) {
                board.renderBoard(message);
            } else if (blockPlayer(board, user)) {
                board.renderBoard(message);
            } else
                board.setBoard(getSymbol());
                board.renderBoard(message);
            }
        }
    }

package pl.piotrkanarek.game.logic.dataModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.piotrkanarek.exceptions.NotEmptyFieldException;
import pl.piotrkanarek.exceptions.WrongFieldNumberException;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Board {  // class with model of data

    Logger logger = LoggerFactory.getLogger(Board.class);

    private final char[][] board = new char[3][3];
    private final char emptyField = '-';

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(int col, int row, char symbol) {
        try {
            if (board[col][row] == emptyField) {
                board[col][row] = symbol;
            } else {
                throw new NotEmptyFieldException("\nWybrałeś zajęte pole! \nPodaj numer pola ponownie");
            }

        } catch (NotEmptyFieldException err) {
            logger.error(err.getMessage());
            setBoardByNumber(symbol);
        }
    }

    public void setBoard(char symbol) {    //set board with random numbers
        Random randomSymbolFirst = new Random();
        Random randomSymbolSecond = new Random();
        int col = randomSymbolFirst.nextInt(3);
        int row = randomSymbolSecond.nextInt(3);

        if (board[col][row] == emptyField) {
            board[col][row] = symbol;
        } else {
            setBoard(symbol);
        }
    }

    public void setBoardByNumber(char symbol){ //method set symbol in the board by number 1-9 which
                                               //corresponds to the filed number
        try {

            Scanner scan = new Scanner(System.in);
            int fieldNumber = scan.nextInt();

            switch (fieldNumber) {
                case 1:
                    setBoard(0, 0, symbol);
                    break;
                case 2:
                    setBoard(0, 1, symbol);
                    break;
                case 3:
                    setBoard(0, 2, symbol);
                    break;
                case 4:
                    setBoard(1, 0, symbol);
                    break;
                case 5:
                    setBoard(1, 1, symbol);
                    break;
                case 6:
                    setBoard(1, 2, symbol);
                    break;
                case 7:
                    setBoard(2, 0, symbol);
                    break;
                case 8:
                    setBoard(2, 1, symbol);
                    break;
                case 9:
                    setBoard(2, 2, symbol);
                    break;
                default:
                    throw new WrongFieldNumberException();
            }

        } catch (WrongFieldNumberException | InputMismatchException err) {
            logger.error("\nPodałeś numer pola poza zakresem 1-9! \n" +
                    "Podaj numer pola ponownie");
            setBoardByNumber(symbol);
        }
    }

    public char getEmptyField() {
        return emptyField;
    }

    public void resetBoard(){
       for(int i = 0; i < board.length; i++){
           for(int j = 0; j < board.length; j++){
               board[i][j] = emptyField;
           }
       }
    }

    public void renderBoard(String message){
        System.out.println(message);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print("\t" + board[i][j]);
            }
            System.out.println();
        }
    }

    public void printInfo(){
        System.out.println("--------UKŁAD PLANSZY--------");
        System.out.println("\t\t1\t2\t3\n\t\t4\t5\t6\n\t\t7\t8\t9");
        System.out.println("-----------------------------");

       resetBoard();
       renderBoard("---AKTUALNY STAN PLANSZY---");
    }
}

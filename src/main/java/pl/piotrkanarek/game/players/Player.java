package pl.piotrkanarek.game.players;

public class Player {

    private final char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return "\nKONIEC GRY\n";
    }
}

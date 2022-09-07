package Day5;

public enum Symbol {
    PLAYER("P"),
    WALL("W"),
    SPACE("-"),
    EXIT("E");

    private String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbolString() {
        return symbol;
    }
}

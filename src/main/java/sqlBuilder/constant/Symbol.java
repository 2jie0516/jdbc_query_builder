package sqlBuilder.constant;

public enum Symbol {
    COMMA(","),
    SPACE(" "),
    OPEN_PARENTHESIS("("),
    CLOSING_PARENTHESIS(")");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

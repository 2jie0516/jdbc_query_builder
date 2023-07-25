package sqlBuilder.builder.tableBuilder;

import sqlBuilder.constant.Symbol;

import static sqlBuilder.constant.LastIndexLength.INVALID_LAST_COMMA;

public class ValuesBuilder {
    private StringBuilder valuesBuilder = new StringBuilder();

    public ValuesBuilder values(String... values) {
        valuesBuilder.append(" VALUES" + Symbol.SPACE.getSymbol() + Symbol.OPEN_PARENTHESIS.getSymbol());

        for (String value : values) {
            valuesBuilder.append(value + Symbol.COMMA.getSymbol());
        }

        valuesBuilder.setLength(valuesBuilder.length() - INVALID_LAST_COMMA);
        valuesBuilder.append(Symbol.CLOSING_PARENTHESIS.getSymbol());

        return this;
    }

    public String build() {
        return valuesBuilder.toString();
    }
}

package sqlBuilder.tableBuilder;

import sqlBuilder.constant.Symbol;

import static sqlBuilder.constant.LastIndexLength.INVALID_LAST_COMMA;

public class ColumnBuilder {
    private StringBuilder columnBuilder;

    public ColumnBuilder(StringBuilder columnBuilder) {
        this.columnBuilder = columnBuilder;
    }

    public ValuesBuilder values(String... values) {
        columnBuilder.append(" VALUES" + Symbol.SPACE.getSymbol() + Symbol.OPEN_PARENTHESIS.getSymbol());

        for (String value : values) {
            columnBuilder.append(value + Symbol.COMMA.getSymbol());
        }

        columnBuilder.setLength(columnBuilder.length() - INVALID_LAST_COMMA);
        columnBuilder.append(Symbol.CLOSING_PARENTHESIS.getSymbol());

        return new ValuesBuilder(columnBuilder);
    }

    public String build() {
        return columnBuilder.toString();
    }
}

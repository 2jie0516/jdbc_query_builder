package sqlBuilder.builder.tableBuilder;

import sqlBuilder.constant.Symbol;

import static sqlBuilder.constant.LastIndexLength.INVALID_LAST_COMMA;

public class ColumnBuilder {
    private StringBuilder columnBuilder = new StringBuilder();

    public ColumnBuilder columns(String... columns) {
        columnBuilder.append(Symbol.OPEN_PARENTHESIS.getSymbol());

        for (String column : columns) {
            columnBuilder.append(column + Symbol.COMMA.getSymbol());
        }

        columnBuilder.setLength(columnBuilder.length() - INVALID_LAST_COMMA);
        columnBuilder.append(Symbol.CLOSING_PARENTHESIS.getSymbol());

        return this;
    }

    public String build() {
        return columnBuilder.toString();
    }
}

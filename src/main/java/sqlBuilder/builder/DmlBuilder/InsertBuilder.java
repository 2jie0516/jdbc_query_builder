package sqlBuilder.builder.DmlBuilder;

import sqlBuilder.constant.Symbol;
import sqlBuilder.builder.tableBuilder.ColumnBuilder;
import sqlBuilder.type.TableType;

import static sqlBuilder.constant.LastIndexLength.INVALID_LAST_COMMA;


public class InsertBuilder {
    private StringBuilder insertSqlBuilder = new StringBuilder();

    public InsertBuilder insert(TableType table) {
        insertSqlBuilder.append("INSERT INTO ").append(table);
        return this;
    }

    public ColumnBuilder columns(String... columns) {
        insertSqlBuilder.append(Symbol.OPEN_PARENTHESIS.getSymbol());

        for (String column : columns) {
            insertSqlBuilder.append(column + Symbol.COMMA.getSymbol());
        }

        insertSqlBuilder.setLength(insertSqlBuilder.length() - INVALID_LAST_COMMA);
        insertSqlBuilder.append(Symbol.CLOSING_PARENTHESIS.getSymbol());

        return new ColumnBuilder(insertSqlBuilder);
    }

    public String build() {
        return insertSqlBuilder.toString();
    }
}

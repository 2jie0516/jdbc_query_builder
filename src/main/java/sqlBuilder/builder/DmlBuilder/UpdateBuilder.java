package sqlBuilder.builder.DmlBuilder;

import sqlBuilder.constant.Symbol;
import sqlBuilder.builder.tableBuilder.SetBuilder;
import sqlBuilder.type.TableType;

import static sqlBuilder.constant.LastIndexLength.INVALID_LAST_COMMA;

public class UpdateBuilder {
    private StringBuilder updateSqlBuilder = new StringBuilder();

    public UpdateBuilder update(TableType table) {
        updateSqlBuilder.append("UPDATE ").append(table);
        return this;
    }

    public SetBuilder set(String... column) {
        updateSqlBuilder.append(" SET ");

        for (String columnValue : column) {
            updateSqlBuilder.append(columnValue + Symbol.COMMA.getSymbol());
        }

        updateSqlBuilder.setLength(updateSqlBuilder.length() - INVALID_LAST_COMMA);

        return new SetBuilder(updateSqlBuilder);
    }

    public String build() {
        return updateSqlBuilder.toString();
    }
}

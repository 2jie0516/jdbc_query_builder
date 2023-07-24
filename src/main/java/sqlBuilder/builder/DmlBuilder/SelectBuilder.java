package sqlBuilder.builder.DmlBuilder;

import sqlBuilder.constant.Symbol;
import sqlBuilder.builder.tableBuilder.FromBuilder;
import sqlBuilder.type.TableType;

import java.lang.reflect.Field;

import static sqlBuilder.constant.LastIndexLength.INVALID_LAST_COMMA;

public class SelectBuilder<T> {
    private StringBuilder selectSqlBuilder = new StringBuilder();

    public SelectBuilder<T> select(T column) {
        selectSqlBuilder.append("SELECT ");
        appendColumns(column);
        return this;
    }

    public SelectBuilder<T> selectAll(T column) {
        selectSqlBuilder.append("SELECT ");
        appendColumns(column);
        return this;
    }

    private void appendColumns(T column) {
        Class<?> clazz = column.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            String columnName = field.getName();

            selectSqlBuilder.append(columnName + Symbol.COMMA.getSymbol());
        }

        selectSqlBuilder.setLength(selectSqlBuilder.length() - INVALID_LAST_COMMA);
    }

    public FromBuilder from(TableType table) {
        return new FromBuilder(selectSqlBuilder.append(" FROM ").append(table));
    }

    public String build() {
        return selectSqlBuilder.toString();
    }
}


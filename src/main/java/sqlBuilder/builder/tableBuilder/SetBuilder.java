package sqlBuilder.builder.tableBuilder;

import sqlBuilder.constant.Symbol;

import static sqlBuilder.constant.LastIndexLength.INVALID_LAST_COMMA;

public class SetBuilder {
    private StringBuilder setBuilder = new StringBuilder();

    public SetBuilder set(String... column) {
        setBuilder.append(" SET ");

        for (String columnValue : column) {
            setBuilder.append(columnValue + Symbol.COMMA.getSymbol());
        }

        setBuilder.setLength(setBuilder.length() - INVALID_LAST_COMMA);

        return this;
    }

    public String build() {
        return setBuilder.toString();
    }
}

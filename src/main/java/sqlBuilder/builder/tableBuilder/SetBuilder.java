package sqlBuilder.builder.tableBuilder;

import sqlBuilder.builder.conditionBuilder.WhereBuilder;

import static sqlBuilder.constant.LastIndexLength.INVALID_LAST_AND;

public class SetBuilder {
    private StringBuilder setBuilder;

    public SetBuilder(StringBuilder setBuilder) {
        this.setBuilder = setBuilder;
    }

    public WhereBuilder where(String... condition) {
        setBuilder.append(" WHERE ");

        for (String conditionValue : condition) {
            setBuilder.append(conditionValue + " AND ");
        }

        setBuilder.setLength(setBuilder.length() - INVALID_LAST_AND);
        return new WhereBuilder(setBuilder);
    }

    public String build() {
        return setBuilder.toString();
    }
}

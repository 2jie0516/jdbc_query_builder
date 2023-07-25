package sqlBuilder.builder.conditionBuilder;

public class WhereBuilder {
    private StringBuilder whereBuilder = new StringBuilder();

    public WhereBuilder where(String columnValue) {
        whereBuilder.append(" WHERE ").append(columnValue);
        return this;
    }

    public WhereBuilder equal(String matchValue) {
        whereBuilder.append(" = ").append(matchValue);
        return this;
    }

    public WhereBuilder and(String condition) {
        whereBuilder.append(" AND ").append(condition);
        return this;
    }

    public WhereBuilder or(String condition) {
        whereBuilder.append(" OR ").append(condition);
        return this;
    }

    public String build() {
        return whereBuilder.toString();
    }
}

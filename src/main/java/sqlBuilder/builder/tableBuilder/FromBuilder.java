package sqlBuilder.builder.tableBuilder;

import sqlBuilder.builder.conditionBuilder.OrderBuilder;
import sqlBuilder.builder.conditionBuilder.WhereBuilder;
import sqlBuilder.constant.Symbol;
import sqlBuilder.type.OrderType;

public class FromBuilder {
    private StringBuilder fromBuilder;

    public FromBuilder(StringBuilder fromBuilder) {
        this.fromBuilder = fromBuilder;
    }

    public WhereBuilder where(String condition) {
        return new WhereBuilder(fromBuilder.append(" WHERE ").append(condition));
    }

    public OrderBuilder orderBy(String column, OrderType orderType) {
        fromBuilder.append(" ORDER BY ").append(column).append(Symbol.SPACE.getSymbol()).append(orderType);
        return new OrderBuilder(fromBuilder);
    }

    public String build() {
        return fromBuilder.toString();
    }
}

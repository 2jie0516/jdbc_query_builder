package sqlBuilder.builder.conditionBuilder;

import sqlBuilder.constant.Symbol;
import sqlBuilder.type.OrderType;

public class OrderBuilder {
    private StringBuilder orderBuilder;

    public OrderBuilder(StringBuilder orderBuilder) {
        this.orderBuilder = orderBuilder;
    }

    public OrderBuilder orderBy(String column, OrderType orderType) {
        orderBuilder.append(Symbol.COMMA.getSymbol()).append(column).append(Symbol.SPACE.getSymbol()).append(orderType);
        return this;
    }

    public String build() {
        return orderBuilder.toString();
    }
}

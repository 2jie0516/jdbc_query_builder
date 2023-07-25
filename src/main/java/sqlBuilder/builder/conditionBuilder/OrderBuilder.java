package sqlBuilder.builder.conditionBuilder;

import sqlBuilder.constant.Symbol;
import sqlBuilder.type.OrderType;

public class OrderBuilder {
    private StringBuilder orderBuilder = new StringBuilder();

    public OrderBuilder orderBy(String column) {
        orderBuilder.append(" ORDER BY ").append(column).append(Symbol.SPACE.getSymbol());
        return this;
    }

    public OrderBuilder orderType(OrderType orderType){
        orderBuilder.append(orderType);
        return this;
    }

    public OrderBuilder addOrder(String column) {
        orderBuilder.append(Symbol.COMMA.getSymbol()).append(column).append(Symbol.SPACE.getSymbol());
        return this;
    }

    public String build() {
        return orderBuilder.toString();
    }
}

package sqlBuilder.builder.DmlBuilder;

import sqlBuilder.builder.conditionBuilder.OrderBuilder;
import sqlBuilder.builder.conditionBuilder.WhereBuilder;
import sqlBuilder.constant.Symbol;
import sqlBuilder.type.TableType;

import java.lang.reflect.Field;

import static sqlBuilder.constant.LastIndexLength.INVALID_LAST_COMMA;

public class SelectBuilder {
    private String select;
    private String from;
    private String where;
    private String order;

    public SelectBuilder(String select, String from, String where, String order) {
        this.select = select;
        this.from = from;
        this.where = where;
        this.order = order;
    }

    public static class Builder<T>{
        private String select;
        private String from;
        private String where;
        private String order;

        public Builder<T> select(T column) {
            select = appendColumns(column);
            return this;
        }

        public Builder<T> selectAll(T column) {
            select = appendColumns(column);
            return this;
        }

        public Builder<T> from(TableType table) {
            from = table.name();
            return this;
        }

        public Builder<T> where(WhereBuilder whereBuilder) {
            where = whereBuilder.build();
            return this;
        }

        public Builder<T> order(OrderBuilder orderBuilder) {
            order = orderBuilder.build();
            return this;
        }

        private String appendColumns(T column) {
            StringBuilder selectSqlBuilder = new StringBuilder();

            Class<?> clazz = column.getClass();
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                String columnName = field.getName();

                selectSqlBuilder.append(columnName + Symbol.COMMA.getSymbol());
            }

            selectSqlBuilder.setLength(selectSqlBuilder.length() - INVALID_LAST_COMMA);
            return selectSqlBuilder.toString();
        }

        public SelectBuilder build(){
            boolean whereIsEmpty = where == null;
            boolean orderIsEmpty = order == null;

            if(whereIsEmpty){
                where ="";
            }
            if (orderIsEmpty){
                order ="";
            }

            return new SelectBuilder(select,from,where,order);
        }
    }

    public String toString() {
        StringBuilder selectSqlBuilder = new StringBuilder();
        selectSqlBuilder.append("SELECT ")
                .append(select)
                .append(" FROM ")
                .append(from)
                .append(where)
                .append(order);

        return selectSqlBuilder.toString();
    }
}


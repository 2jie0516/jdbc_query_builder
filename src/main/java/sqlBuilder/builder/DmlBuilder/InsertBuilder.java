package sqlBuilder.builder.DmlBuilder;

import sqlBuilder.builder.tableBuilder.ValuesBuilder;
import sqlBuilder.builder.tableBuilder.ColumnBuilder;
import sqlBuilder.type.TableType;

public class InsertBuilder {
    private String table;
    private String columns;
    private String values;

    public InsertBuilder(String table, String columns, String values) {
        this.table = table;
        this.columns = columns;
        this.values = values;
    }

    public static class Builder<T> {
        private String insert;
        private String columns;
        private String values;

        public Builder<T> insert(TableType table) {
            insert = table.name();
            return this;
        }

        public Builder<T> columns(ColumnBuilder columnBuilder) {
            columns = columnBuilder.build();
            return this;
        }

        public Builder<T> values(ValuesBuilder valuesBuilder) {
            values = valuesBuilder.build();
            return this;
        }

        public InsertBuilder build(){
            boolean valesIsEmpty = values == null;

            if (valesIsEmpty){
                values = "";
            }

            return new InsertBuilder(insert,columns,values);
        }
    }

    public String toString() {
        StringBuilder insertSqlBuilder = new StringBuilder();

        insertSqlBuilder.append("INSERT INTO ")
                .append(table)
                .append(columns)
                .append(values);

        return insertSqlBuilder.toString();
    }
}

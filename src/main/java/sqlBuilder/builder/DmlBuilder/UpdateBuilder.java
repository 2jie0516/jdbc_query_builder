package sqlBuilder.builder.DmlBuilder;

import sqlBuilder.builder.conditionBuilder.WhereBuilder;
import sqlBuilder.builder.tableBuilder.SetBuilder;
import sqlBuilder.type.TableType;

public class UpdateBuilder {
    private String table;
    private String set;
    private String where;

    public UpdateBuilder(String update, String set, String where) {
        this.table = update;
        this.set = set;
        this.where = where;
    }

    public static class Builder<T> {
        private String update;
        private String set;
        private String where;


        public Builder<T> update(TableType table) {
            update = table.name();
            return this;
        }

        public Builder<T> set(SetBuilder setBuilder) {
            set = setBuilder.build();
            return this;
        }

        public Builder<T> where(WhereBuilder whereBuilder){
            where = whereBuilder.build();
            return this;
        }

        public UpdateBuilder build(){
            return new UpdateBuilder(update,set,where);
        }
    }

    public String toString() {
        StringBuilder updateSqlBuilder = new StringBuilder();
        updateSqlBuilder.append("UPDATE ").append(table).append(set).append(where);

        return updateSqlBuilder.toString();
    }
}

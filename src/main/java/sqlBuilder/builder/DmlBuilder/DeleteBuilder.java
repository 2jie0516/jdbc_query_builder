package sqlBuilder.builder.DmlBuilder;


import sqlBuilder.builder.conditionBuilder.WhereBuilder;
import sqlBuilder.type.TableType;

public class DeleteBuilder {
    private String from;
    private String where;

    public DeleteBuilder(String from, String where) {
        this.from = from;
        this.where = where;
    }

    public static class Builder<T> {
        private String from;
        private String where;

        public Builder<T> deleteFrom(TableType table) {
            from = table.name();
            return this;
        }

        public Builder<T> where(WhereBuilder whereBuilder) {
            where = whereBuilder.build();
            return this;
        }

        public DeleteBuilder build() {
            boolean whereIsEmpty = where == null;

            if (whereIsEmpty) {
                where = "";
            }

            return new DeleteBuilder(from, where);
        }
    }

    public String toString() {
        StringBuilder deleteSqlBuilder = new StringBuilder();
        deleteSqlBuilder.append("DELETE FROM ")
                .append(from)
                .append(where);

        return deleteSqlBuilder.toString();
    }

}

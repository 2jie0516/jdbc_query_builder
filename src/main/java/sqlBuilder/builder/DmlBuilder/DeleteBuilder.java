package sqlBuilder.builder.DmlBuilder;


import sqlBuilder.builder.tableBuilder.FromBuilder;
import sqlBuilder.type.TableType;

public class DeleteBuilder {
    private StringBuilder deleteSqlBuilder = new StringBuilder();

    public DeleteBuilder delete() {
        deleteSqlBuilder.append("DELETE");
        return this;
    }

    public FromBuilder from(TableType table) {
        return new FromBuilder(deleteSqlBuilder.append(" FROM ").append(table));
    }

    public String build() {
        return deleteSqlBuilder.toString();
    }
}

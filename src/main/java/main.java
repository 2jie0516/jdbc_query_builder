import sqlBuilder.Customer;
import sqlBuilder.builder.DmlBuilder.DeleteBuilder;
import sqlBuilder.builder.DmlBuilder.InsertBuilder;
import sqlBuilder.builder.DmlBuilder.SelectBuilder;
import sqlBuilder.builder.DmlBuilder.UpdateBuilder;
import sqlBuilder.builder.conditionBuilder.OrderBuilder;
import sqlBuilder.builder.conditionBuilder.WhereBuilder;
import sqlBuilder.builder.tableBuilder.ColumnBuilder;
import sqlBuilder.builder.tableBuilder.SetBuilder;
import sqlBuilder.builder.tableBuilder.ValuesBuilder;
import sqlBuilder.dto.GetCustomerNameDto;
import sqlBuilder.type.OrderType;
import sqlBuilder.type.TableType;

public class main {
    public static void main(String[] args) {

        WhereBuilder where = new WhereBuilder()
                .where("email")
                .equal(":email")
                .and("name")
                .equal(":name");

        OrderBuilder order1 = new OrderBuilder()
                .orderBy("name")
                .orderType(OrderType.ASC)
                .addOrder("email")
                .orderType(OrderType.DESC);

        ColumnBuilder column = new ColumnBuilder().columns("email", "name");
        ValuesBuilder values = new ValuesBuilder().values(":email", ":name");
        SetBuilder set = new SetBuilder().set("email = :afterUpdateEmail");

        InsertBuilder insertSQL = new InsertBuilder.Builder<>()
                .insert(TableType.CUSTOMERS)
                .columns(column)
                .values(values)
                .build();

        System.out.println(insertSQL);

        SelectBuilder findAllSql = new SelectBuilder.Builder<>()
                .selectAll(new Customer("name", "email"))
                .from(TableType.CUSTOMERS)
                .where(where)
                .order(order1)
                .build();

        System.out.println(findAllSql.toString());


        SelectBuilder findByEmailSql = new SelectBuilder.Builder<>()
                .select(new GetCustomerNameDto("name", "email"))
                .from(TableType.CUSTOMERS)
                .where(where)
                .build();

        System.out.println(findByEmailSql.toString());

        UpdateBuilder updateInfoSql = new UpdateBuilder.Builder<>()
                .update(TableType.CUSTOMERS)
                .set(set)
                .where(where)
                .build();

        System.out.println(updateInfoSql.toString());

        DeleteBuilder deleteByEmailSql = new DeleteBuilder.Builder<>()
                .deleteFrom(TableType.CUSTOMERS)
                .where(where)
                .build();

        System.out.println(deleteByEmailSql.toString());

        DeleteBuilder deleteAllSql = new DeleteBuilder.Builder<>()
                .deleteFrom(TableType.CUSTOMERS)
                .build();

        System.out.println(deleteAllSql.toString());
    }
}
